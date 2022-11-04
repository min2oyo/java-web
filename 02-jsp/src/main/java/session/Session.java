package session;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/session")
@SuppressWarnings("serial")
public class Session extends HttpServlet {

	@Override
	public void init(ServletConfig config) throws ServletException {

		System.out.println("Session.init() 실행");

	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doHandle(request, response);

	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doHandle(request, response);

	}

	private void doHandle(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		System.out.println("Session.doHandle() 실행");

		// request
		HttpSession session = request.getSession();	// session 객체를 가져옴
		session.setAttribute("name", "이혜리");				// session 객체에 name을 바인딩 함

		// response
		response.setContentType("text/html; charset=utf-8");

		// 출력
		PrintWriter out = response.getWriter();

		out.println("<html>");
		out.println("<head>");
		out.println("	<title>session</title>");
		out.println("</head>");
		out.println("<body>");
		out.println("	<h1>세션에 이름을 바인딩합니다</h1>");
		out.println("	<a href='/jsp/views/built-in-object/session/session1.jsp'>첫 번째 페이지로 이동하기</a>");
		out.println("</body>");
		out.println("</html>");

	}

	@Override
	public void destroy() {

		System.out.println("Session.destroy() 실행");

	}

}
