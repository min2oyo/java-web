package login.rewriting;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "LoginWritingServlet2", urlPatterns = { "/loginWriting2" })
@SuppressWarnings("serial")
public class LoginServlet2 extends HttpServlet {

	@Override
	public void init(ServletConfig config) throws ServletException {

		System.out.println("LoginServlet2.init() 실행");

	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		System.out.println("LoginServlet2.doGet() 실행");

		// ------ 요청 ------
		request.setCharacterEncoding("utf-8");

		// 초기화
		String userId = request.getParameter("userId");	// 첫 번째 서블릿에서 전송한 로그인 정보를 가져옴
		String userPw = request.getParameter("userPw");
		String userAddress = request.getParameter("userAddress");

		// ------ 응답 ------
		response.setContentType("text/html;charset=utf-8");

		// 출력
		PrintWriter out = response.getWriter();

		out.println("<html>");
		out.println("<head>");
		out.println("	<title>메인</title>");
		out.println("</head>");
		out.println("<body>");

		if (userId != null && userId.length() != 0) {

			out.println("	이미 로그인 상태입니다!<br><br>");	// 첫 번째 서블릿의 ID 정보를 이용해 로그인 상태 유지
			out.println("	첫 번째 서블릿에서 넘겨준 아이디: " + userId + "<br>");
			out.println("	첫 번째 서블릿에서 넘겨준 비밀번호: " + userPw + "<br>");
			out.println("	첫 번째 서블릿에서 넘겨준 주소: " + userAddress + "<br>");

		} else {

			out.println("	로그인 하지 않았습니다. <br><br>");	// 로그인 창을 거치지 않고 바로 요청한 경우 나타남
			out.println("	다시 로그인하세요!. <br>");
			out.println("	<a href='/servlet/views/login/loginWriting.html'>로그인 창으로 이동하기</a>");

		}

		out.println("</body>");
		out.println("</html>");
		out.close();

	}

	@Override
	public void destroy() {

		System.out.println("LoginServlet2.destroy() 실행");

	}

}
