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

@WebServlet("/loginMember")
@SuppressWarnings("serial")
public class LoginServlet extends HttpServlet {

	@Override
	public void init(ServletConfig config) throws ServletException {

		System.out.println("LoginServlet.init() 실행");

	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		System.out.println("LoginServlet.doGet() 실행");
		doHandle(request, response);

	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		System.out.println("LoginServlet.doPost() 실행");

		doHandle(request, response);

	}

	private void doHandle(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		System.out.println("Session5.doHandle() 실행");

		// ------ 요청 ------
		request.setCharacterEncoding("utf-8");

		// 초기화
		String userId = request.getParameter("userId");
		String userPwd = request.getParameter("userPwd");
		MemberVO memberVO = new MemberVO();
		memberVO.setId(userId);
		memberVO.setPwd(userPwd);
		MemberDAO memberDAO = new MemberDAO();
		boolean result = memberDAO.isExisted(memberVO);

		// ------ 응답 ------
		response.setContentType("text/html;charset=utf-8");

		// 출력
		PrintWriter out = response.getWriter();

		out.println("<html>");
		out.println("<head>");
		out.println("	<title>Hello!</title>");
		out.println("</head>");
		out.println("<body>");

		if (result) {

			HttpSession session = request.getSession();	// getSession()을 호출해 최초 요청 시 세션 객체를 새로 생성하거나 기존 세션을 반환함

			session.setAttribute("isLogOn", true);		// 조회한 결과가 true이면 isLogOn 속성을 true로 세션에 저장
			session.setAttribute("login.id", userId);	// 조죄한 결과가 true이면 ID와 비밀번호를 세션에 저장
			session.setAttribute("login.pwd", userPwd);

			out.println("	안녕하세요" + userId + "님!!<br>");
			out.println("	<a href='/servlet/showMember'>회원정보 보기</a>");

		} else {

			out.println("	회원 아이디가 틀립니다.<br>");
			out.println("	<a href='/servlet/views/login/member.html'>다시 로그인하기</a>");

		}

		out.println("</body>");
		out.println("</html>");
		out.close();

	}

	@Override
	public void destroy() {

		System.out.println("LoginServlet.destroy() 실행");

	}

}
