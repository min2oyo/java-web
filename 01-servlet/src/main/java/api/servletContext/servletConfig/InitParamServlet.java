package api.servletContext.servletConfig;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = { // urlPatterns로 매핑 이름을 여러 개 설정
		"/initConfig",		//
		"/initConfig2" },	//
		initParams = { 	// @WebInitParam로 여러 개의 매개변수 설정
				@WebInitParam(name = "email", value = "admin@jweb.com"),	//
				@WebInitParam(name = "tel", value = "010-1111-2222") })		//
@SuppressWarnings("serial")
public class InitParamServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		System.out.println("InitParamServlet.doGet() 실행");

		// ------ 요청 ------
		request.setCharacterEncoding("utf-8");

		// ------ 응답 ------
		response.setContentType("text/html;charset=utf-8");

		// 초기화
		String email = getInitParameter("email");
		String tel = getInitParameter("tel");

		// 출력
		PrintWriter out = response.getWriter();

		out.println("<html>");
		out.println("<head>");
		out.println("	<title>정보</title>");
		out.println("</head>");
		out.println("<body>");
		out.println("	<table>");
		out.println("		<tr>");
		out.println("			<td>email: </td>");
		out.println("			<td>" + email + "</td>");
		out.println("		</tr>");
		out.println("		<tr>");
		out.println("			<td>핸드폰: </td>");
		out.println("			<td>" + tel + "</td>");
		out.println("		</tr>");
		out.println("	</table>");
		out.println("</body>");
		out.println("</html>");

	}

	@Override
	public void destroy() {

		System.out.println("InitParamServlet.destroy() 실행");

	}

}
