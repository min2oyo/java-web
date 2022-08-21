package ten.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpFilter;
import javax.servlet.http.HttpServletRequest;

@WebFilter("/*")	// WebFilter 애너테이션을 이용해 모든 요청이 필터를 거침
@SuppressWarnings({ "serial", "deprecation" })
public class EncodeFilter extends HttpFilter implements Filter {	// 사용자 정의 필터는 반드시 Filter 인터페이스를 구현해야 함

	ServletContext context;

	@Override
	public void init(FilterConfig fConfig) throws ServletException {

		System.out.println("EncodeFilter.init() 실행");
		System.out.println("utf-8 인코딩...");
		context = fConfig.getServletContext();

	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {	// 실제 필터 기능 구현

		System.out.println("EncodeFilter.doFilter() 실행");

		// ------ 요청 ------
		request.setCharacterEncoding("utf-8");		// 한글 인코딩 설정 작업

		String context = ((HttpServletRequest) request).getContextPath();	// 웹 애플리케이션의 컨텍스트 이름을 가져옴
		String pathinfo = ((HttpServletRequest) request).getRequestURI();	// 웹 브라우저에서 요청한 요청 URI를 가져옴
		String realPath = request.getRealPath(pathinfo);					// 요청 URI의 실제 경로를 가져옴

		System.out.println("Context 정보: " + context);
		System.out.println("URI 정보: " + pathinfo);
		System.out.println("물리적 정보: " + realPath);	// 다음 필터로 넘김
		System.out.println("");

		long begin = System.currentTimeMillis();	// 요청 필터에서 요청 처리 전의 시각을 구함

		chain.doFilter(request, response);

		long end = System.currentTimeMillis();		// 응답 필터에서 요청 처리 후의 시각을 구함

		System.out.println("작업 시간: " + (end - begin) + "ms");	// 작업 요청 전과 후의 시각 차를 구해 작업 수행 시간을 구함
		System.out.println("");

	}

	@Override
	public void destroy() {

		System.out.println("EncodeFilter.destroy() 실행");

	}

}
