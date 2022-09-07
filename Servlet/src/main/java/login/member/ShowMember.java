package login.member;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/showMember")
@SuppressWarnings("serial")
public class ShowMember extends HttpServlet {

	@Override
	public void init(ServletConfig config) throws ServletException {

		System.out.println("ShowMember.init() 실행");

	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		System.out.println("ShowMember.doGet() 실행");
		doHandle(request, response);

	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		System.out.println("ShowMember.doPost() 실행");
		doHandle(request, response);

	}

	private void doHandle(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		System.out.println("ShowMember.doHandle() 실행");

		// ------ 요청 ------
		request.setCharacterEncoding("utf-8");

		// ------ 응답 ------
		response.setContentType("text/html;charset=utf-8");

		// 초기화
		String id = "";
		String pwd = "";
		Boolean isLogOn = false;
		HttpSession session = request.getSession(false);			// 이미 세션이 존재하면 세션을 반환하고, 없으면 null을 반환함

		if (session != null) {										// 먼저 세션이 생성되어 있는지 확인

			isLogOn = (Boolean) session.getAttribute("isLogOn");	// isLogOn 속성을 가져와 로그인 상태를 확인

			if (isLogOn == true) {									// isLogOn이 true면 로그인 상태이므로 회원 정보를 브라우저에 표시

				id = (String) session.getAttribute("login.id");
				pwd = (String) session.getAttribute("login.pwd");

			} else {

				response.sendRedirect("/servlet/views/login/member.html");	// 로그인이 아니면 로그인 창으로 이동

			}

		} else {

			response.sendRedirect("/servlet/views/login/member.html");		// 세션이 없으면 로그인 창으로 이동

		}

		// 출력
		PrintWriter out = response.getWriter();

		out.println("<html>");
		out.println("<head>");
		out.println("	<title>Member</title>");
		out.println("</head>");
		out.println("<body>");

		out.println("	아이디: " + id + "<br>");
		out.println("	비밀번호: " + pwd + "<br>");
		out.println("</body>");
		out.println("</html>");

	}

	@Override
	public void destroy() {

		System.out.println("ShowMember.destroy() 실행");

	}

}
