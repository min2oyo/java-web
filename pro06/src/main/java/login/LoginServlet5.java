package login;


import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/login5")
@SuppressWarnings("serial")
public class LoginServlet5 extends HttpServlet {

	@Override
	public void init(ServletConfig config) throws ServletException {

		System.out.println("LoginServlet5.init() 실행");

	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		System.out.println("LoginServlet5.doGet() 실행");
		doHandle(request, response);

	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		System.out.println("LoginServlet5.doPost() 실행");
		doHandle(request, response);

	}

	protected void doHandle(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		System.out.println("LoginServlet5.doHandle() 실행");

		// 요청
		request.setCharacterEncoding("utf-8");	// 전송된 데이터를 utf-8로 인코딩

		String userId = request.getParameter("user_id");
		String userPw = request.getParameter("user_pw");
		String address = request.getParameter("user_address");
		System.out.println("아이디: " + userId);
		System.out.println("비밀번호: " + userPw);
		System.out.println("주소: " + address);

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
		out.print("		주소: " + address + "<br>");
		out.print("	</body>");
		out.print("</html>");

	}

	@Override
	public void destroy() {

		System.out.println("LoginServlet5.destroy() 실행");

	}

}
