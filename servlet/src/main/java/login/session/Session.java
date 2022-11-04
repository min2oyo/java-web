package login.session;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

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

		System.out.println("session.init() 실행");

	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		System.out.println("session.doGet() 실행");

		// ------ 요청 ------
		request.setCharacterEncoding("utf-8");

		// 초기화
		HttpSession session = request.getSession();	// getSession()을 호출해 최초 요청 시 세션 객체를 새로 생성하거나 기존 세션을 반환함

		// ------ 응답 ------
		response.setContentType("text/html;charset=utf-8");

		// 출력
		PrintWriter out = response.getWriter();

		out.println("<html>");
		out.println("<head>");
		out.println("	<title>session</title>");
		out.println("</head>");
		out.println("<body>");
		out.println("	세션 아이디: " + session.getId() + "<br>");									// 생성된 세션 객체의 id를 가져옴
		out.println("	최초 세션 생성 시각: " + new Date(session.getCreationTime()) + "<br>");		// 최초 세션 객체 생성 시간을 가져옴
		out.println("	최초 세션 접근 시각: " + new Date(session.getLastAccessedTime()) + "<br>");	// 세션 객체에 가장 최근에 접근한 시간을 가져옴
		out.println("	세션 유효 시간: " + session.getMaxInactiveInterval() + "<br>");				// 세션 객체의 유효시간을 가져옴

		if (session.isNew()) {	// 최소 생성된 세션인지 판별

			out.println("	새 세션이 만들어졌습니다. ");

		}

		out.println("</body>");
		out.println("</html>");
		out.close();

	}

	@Override
	public void destroy() {

		System.out.println("session.destroy() 실행");

	}

}
