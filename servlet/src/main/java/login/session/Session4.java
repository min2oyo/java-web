package login.session;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/session4")
@SuppressWarnings("serial")
public class Session4 extends HttpServlet {

	@Override
	public void init(ServletConfig config) throws ServletException {

		System.out.println("session4.init() 실행");

	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		System.out.println("session4.doGet() 실행");
		doHandle(request, response);

	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		System.out.println("session4.doPost() 실행");
		doHandle(request, response);

	}

	private void doHandle(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		System.out.println("session4.doHandle() 실행");

		// ------ 요청 ------
		request.setCharacterEncoding("utf-8");

		// 초기화
		String userId = request.getParameter("userId");
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

		if (session.isNew()) {	// 최초 요청 시 수행

			if (userId != null) {	// 로그인 창에서 서블릿으로 요청했다면 ID가 null이 아니므로 세션에 ID를 바인딩 함

				session.setAttribute("userId", userId);
				out.println("	<a href='/servlet/session4'>로그인 상태 확인</a>");

			} else {

				out.println("	<a href='/servlet/views/login/session4.html'>다시 로그인 하세요!! 전송된 id가 없음</a>");
				session.invalidate();	// 생성된 세션 객체를 강제 삭제

			}

		} else {	// 재요청 시 세션에서 ID를 가져와 이전에 로그인 했는지 여부 확인

			userId = (String) session.getAttribute("userId");

			if (userId != null && userId.length() != 0) {

				out.println("	안녕하세요. " + userId + "님!");

			} else {

				out.println("	<a href='/servlet/views/login/session4.html'>다시 로그인 하세요!! 사용자 정보 없음</a>");
				session.invalidate();	// 생성된 세션 객체를 강제 삭제

			}

		}

		out.println("</body>");
		out.println("</html>");
		out.close();

	}

	@Override
	public void destroy() {

		System.out.println("session4.destroy() 실행");

	}

}
