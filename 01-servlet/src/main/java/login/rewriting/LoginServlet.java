package login.rewriting;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLEncoder;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "LoginWritingServlet", urlPatterns = { "/loginWriting" })
@SuppressWarnings("serial")
public class LoginServlet extends HttpServlet {

	@Override
	public void init(ServletConfig config) throws ServletException {

		System.out.println("LoginServlet.init() 실행");

	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		System.out.println("LoginServlet.doPost() 실행");

		// ------ 요청 ------
		request.setCharacterEncoding("utf-8");

		// 초기화
		String userId = request.getParameter("userId");
		String userPw = request.getParameter("userPw");
		String userAddress = request.getParameter("userAddress");
		String userEmail = request.getParameter("userEmail");
		String userHp = request.getParameter("userHp");

		// ------ 응답 ------
		response.setContentType("text/html;charset=utf-8");

		// 출력
		PrintWriter out = response.getWriter();

		out.println("<html>");
		out.println("<head>");
		out.println("	<title>메인</title>");
		out.println("</head>");
		out.println("<body>");
		out.println("	아이디: " + userId + "<br>");
		out.println("	패스워드: " + userPw + "<br>");
		out.println("	주소: " + userAddress + "<br>");
		out.println("	email: " + userEmail + "<br>");
		out.println(" 	휴대전화: " + userHp + "<br>");

		userAddress = URLEncoder.encode(userAddress, "utf-8");	// get 방식으로 한글을 전송하기 위해 인코딩

		out.println("	<a href='/servlet/loginWriting2?userId=" + userId + "&userPw=" + userPw + "&userAddress=" + userAddress + "'>두 번째 서블릿으로 보내기</a>");
		out.println("</body>");
		out.println("</html>");
		out.close();

	}

	@Override
	public void destroy() {

		System.out.println("LoginServlet.destroy() 실행");

	}

}
