package login.cookie;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLEncoder;
import java.util.Date;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/setCookie")
@SuppressWarnings("serial")
public class SetCookie extends HttpServlet {

	@Override
	public void init(ServletConfig config) throws ServletException {

		System.out.println("SetCookie.init() 실행");

	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		System.out.println("SetCookie.doGet() 실행");

		// ------ 요청 ------
		request.setCharacterEncoding("utf-8");

		// ------ 응답 ------
		response.setContentType("text/html;charset=utf-8");

		// 초기화
		Cookie cookie = new Cookie("cookieTest", URLEncoder.encode("JSP프로그래밍입니다.", "utf-8"));	// Cookie 객체를 생성한 후 CookieTest 이름으로 한글 정보를 인코딩해서 쿠키에 저장
		cookie.setMaxAge(24 * 60 * 60);	// 유효기간 설정
		response.addCookie(cookie);		// 생성된 쿠키를 브라우저로 전송
		Date date = new Date();

		// 출력
		PrintWriter out = response.getWriter();

		out.println("<html>");
		out.println("<head>");
		out.println("	<title>메인</title>");
		out.println("</head>");
		out.println("<body>");
		out.println("	현재시간: " + date + "<br>");
		out.println("	문자열을 Cookie에 저장합니다. <br>");
		out.println("	<a href='/servlet/getCookie'>쿠키 확인</a>");
		out.println("</body>");
		out.println("</html>");
		out.close();

	}

	@Override
	public void destroy() {

		System.out.println("SetCookie.destroy() 실행");

	}

}
