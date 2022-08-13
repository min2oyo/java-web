package login;


import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/login2")
@SuppressWarnings("serial")
public class LoginServlet2 extends HttpServlet {

	@Override
	public void init(ServletConfig config) throws ServletException {

		System.out.println("LoginServlet2.init() 실행");

	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		System.out.println("LoginServlet2.doGet() 실행");

		// 요청
		request.setCharacterEncoding("utf-8");	// 전송된 데이터를 utf-8로 인코딩

		String userId = request.getParameter("user_id");
		String userPw = request.getParameter("user_pw");
		System.out.println("아이디: " + userId);
		System.out.println("비밀번호: " + userPw);

		// 응답
		response.setContentType("text/html;charset=utf-8");

		PrintWriter out = response.getWriter();	// HttpServletResponse 객체의 getWriter()를 이용해 출력 스트림 PrintWriter 객체를 받아 옴

		out.print("<html>");
		out.print("<head>");
		out.print("	<title>로그인 결과</title>");
		out.print("</head>");
		out.print("	<body>");
		out.print("		아이디: " + userId + "<br>");
		out.print("		패스워드: " + userPw + "<br>");
		out.print("	</body>");
		out.print("</html>");

	}

	@Override
	public void destroy() {

		System.out.println("LoginServlet2.destroy() 실행");

	}

}
