package api.loadOnStartup;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "loadConfig", urlPatterns = { "/loadConfig" }, loadOnStartup = 1)	// loadOnStartup 속성을 추가하고 우선순위를 1로 설정
@SuppressWarnings("serial")
public class LoadAppConfig extends HttpServlet {

	private ServletContext context;	// 변수 context를 멤버 변수로 선언

	@Override
	public void init(ServletConfig config) throws ServletException {

		System.out.println("LoadAppConfig.init() 실행");

		context = config.getServletContext();	// init() 메서드에서 ServletContext 객체를 얻음

		String menuMember = context.getInitParameter("menuMember");	// getInitParameter()로 web.xml의 메뉴정보를 가져옴
		String menuOrder = context.getInitParameter("menuOrder");
		String menuGoods = context.getInitParameter("menuGoods");

		context.setAttribute("menuMember", menuMember);	// 메뉴 정보를 ServletContext 객체를 바인딩 함
		context.setAttribute("menuOrder", menuOrder);
		context.setAttribute("menuGoods", menuGoods);

	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		System.out.println("LoadAppConfig.doGet() 실행");

		// ------ 요청 ------
		request.setCharacterEncoding("utf-8");

		// ------ 응답 ------
		response.setContentType("text/html;charset=utf-8");

		// 초기화
		String menuMember = context.getInitParameter("menuMember");	// 브라우저에서 요청 시 ServletContext 객체의 바인딩된 메뉴 항목을 가져옴
		String menuOrder = context.getInitParameter("menuOrder");
		String menuGoods = context.getInitParameter("menuGoods");

		// 출력
		PrintWriter out = response.getWriter();

		out.println("<html>");
		out.println("<head>");
		out.println("	<title>정보</title>");
		out.println("</head>");
		out.println("<body>");
		out.println("	<table border=1 cellspacing=0>");
		out.println("		<tr>메뉴 이름</tr>");
		out.println("		<tr>");
		out.println("			<td>" + menuMember + "</td>");
		out.println("			<td>" + menuOrder + "</td>");
		out.println("			<td>" + menuGoods + "</td>");
		out.println("		</tr>");
		out.println("	</table>");
		out.println("</body>");
		out.println("</html>");
		out.close();

	}

	@Override
	public void destroy() {

		System.out.println("LoadAppConfig.destroy() 실행");

	}

}
