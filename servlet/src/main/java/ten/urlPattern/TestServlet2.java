package ten.urlPattern;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/frist/*")	// 디렉토리 이름만 일치하는 URL 패턴
@SuppressWarnings("serial")
public class TestServlet2 extends HttpServlet {

	@Override
	public void init(ServletConfig config) throws ServletException {

		System.out.println("TestServlet2.init() 실행");

	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		System.out.println("TestServlet2.doGet() 실행");

		// ------ 요청 ------
		request.setCharacterEncoding("utf-8");

		// ------ 응답 ------
		response.setContentType("text/html;charset=utf-8");

		// 초기화
		String context = request.getContextPath();			// 컨텍스트 이름만 가져옴
		String mapping = request.getServletPath();			// 서블릿 매핑 이름만 가져옴
		String url = request.getRequestURI().toString();	// 전체 URL을 가져옴
		String uri = request.getRequestURI();				// URI를 가져옴

		// 출력
		PrintWriter out = response.getWriter();

		out.println("<html>");
		out.println("<head>");
		out.println("	<title>Test Servlet 2</title>");
		out.println("</head>");
		out.println("<body bgcolor='yellow'>");
		out.println("	<b>Test Servlet 2입니다.</b><br>");
		out.println("	<b>컨텍스트 이름: " + context + " </b><br>");
		out.println("	<b>매핑 이름: " + mapping + " </b><br>");
		out.println("	<b>전체 경로: " + url + " </b><br>");
		out.println("	<b>URI: " + uri + " </b><br>");
		out.println("</body>");
		out.println("</html>");
		out.close();

	}

	@Override
	public void destroy() {

		System.out.println("TestServlet2.destroy() 실행");

	}

}
