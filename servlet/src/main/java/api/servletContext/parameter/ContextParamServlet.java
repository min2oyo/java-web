package api.servletContext.parameter;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/contextParam")
@SuppressWarnings("serial")
public class ContextParamServlet extends HttpServlet {

//	@Override
//	public void init(ServletConfig config) throws ServletException {	// 주석 풀면 'ServletContext context = getServletContext()'와 충돌(?) 생김
//
//		System.out.println("ContextParamServlet.init() 실행");
//
//	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		System.out.println("ContextParamServlet.doGet() 실행");

		// ------ 요청 ------
		request.setCharacterEncoding("utf-8");

		// ------ 응답 ------
		response.setContentType("text/html;charset=utf-8");

		// 초기화
		ServletContext context = getServletContext();					// ServletContext 객체를 가져옴
		String menuMember = context.getInitParameter("menu_member");	// web.xml의 <param-name> 태그의 이름으로 <param-value> 값을 가져옴
		String menuOrder = context.getInitParameter("menu_order");
		String menuGoods = context.getInitParameter("menu_goods");

		// 출력
		PrintWriter out = response.getWriter();

		out.println("<html>");
		out.println("<head>");
		out.println("	<title>메뉴</title>");
		out.println("</head>");
		out.println("<body>");
		out.println("	<table border=1 cellspacing=0>");
		out.println("		<tr>");
		out.println("			<td>" + menuMember + "</td>");
		out.println("		</tr>");
		out.println("		<tr>");
		out.println("			<td>" + menuOrder + "</td>");
		out.println("		</tr>");
		out.println("		<tr>");
		out.println("			<td>" + menuGoods + "</td>");
		out.println("		</tr>");
		out.println("	</table>");
		out.println("</body>");
		out.println("</html>");

	}

	@Override
	public void destroy() {

		System.out.println("ContextParamServlet.destroy() 실행");

	}

}
