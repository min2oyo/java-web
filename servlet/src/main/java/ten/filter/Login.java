package ten.filter;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/filter")
@SuppressWarnings("serial")
public class Login extends HttpServlet {

	@Override
	public void init(ServletConfig config) throws ServletException {

		System.out.println("Login.init() 실행");

	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		System.out.println("Login.doPost() 실행");

		// ------ 응답 ------
		response.setContentType("text/html;charset=utf-8");

		// 초기화
		String userId = request.getParameter("userId");
		String userPw = request.getParameter("userPw");

		// 출력
		PrintWriter out = response.getWriter();

		out.println("<html>");
		out.println("<head>");
		out.println("	<title>filter</title>");
		out.println("</head>");
		out.println("<body>");
		out.println("	이름: " + userId + "<br>");
		out.println("	비밀번호: " + userPw + "<br>");
		out.println("</body>");
		out.println("</html>");
		out.close();

	}

	@Override
	public void destroy() {

		System.out.println("Login.destroy() 실행");

	}

}
