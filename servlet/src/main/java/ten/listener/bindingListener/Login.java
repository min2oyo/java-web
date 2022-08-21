package ten.listener.bindingListener;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/bindingListener")
@SuppressWarnings("serial")
public class Login extends HttpServlet {

	@Override
	public void init(ServletConfig config) throws ServletException {

		System.out.println("Login.init() 실행");

	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		System.out.println("Login.doPost() 실행");

		// ------ 요청 ------
		request.setCharacterEncoding("utf-8");

		// ------ 응답 ------
		response.setContentType("text/html;charset=utf-8");

		// 초기화
		HttpSession session = request.getSession();

		String userId = request.getParameter("userId");
		String userPw = request.getParameter("userPw");

		LoginImpl loginUser = new LoginImpl(userId, userPw);	// 이벤트 핸들러를 생성한 후 세션에 저장

		if (session.isNew()) {

			session.setAttribute("loginUser", loginUser);		// 세션에 바인딩 시 LoginImpl의 valueBound() 메서드를 호출

		}

		// 출력
		PrintWriter out = response.getWriter();

		out.println("<html>");
		out.println("<head>");
		out.println("	<title>Hello</title>");
		out.println("</head>");
		out.println("<body>");
		out.println("	아이디: " + loginUser.userId + "<br>");	// 접속자수를 브라우저로 출력
		out.println("	총 접속자수: " + LoginImpl.totalUser + "<br>");
		out.println("	<script>");
		out.println("		setTimeout('history.go(0);', 5000");	// JS의 setTimeout()를 이용해 5초마다 서블릿에 재요청하여 현재 접속자수 표시
		out.println("	</script>");
		out.println("</body>");
		out.println("</html>");
		out.close();

	}

	@Override
	public void destroy() {

		System.out.println("Login.destroy() 실행");

	}

}
