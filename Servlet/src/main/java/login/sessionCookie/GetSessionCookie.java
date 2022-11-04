package login.sessionCookie;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLDecoder;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/getSessionCookie")
@SuppressWarnings("serial")
public class GetSessionCookie extends HttpServlet {

	@Override
	public void init(ServletConfig config) throws ServletException {

		System.out.println("GetSessionCookie.init() 실행");

	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		System.out.println("GetSessionCookie.doGet() 실행");

		// ------ 요청 ------
		request.setCharacterEncoding("utf-8");

		// ------ 응답 ------
		response.setContentType("text/html;charset=utf-8");

		// 출력
		PrintWriter out = response.getWriter();

		out.println("<html>");
		out.println("<head>");
		out.println("	<title>메인</title>");
		out.println("</head>");
		out.println("<body>");

		if (request.getCookies() == null) {

			out.println("	<h2>쿠기가 없습니다</h2>");

		} else {

			Cookie[] allValues = request.getCookies();	// request의 getCookies()를 호출해 브라우저에게 쿠키 정보를 요청한 후 쿠키 정보를 배열로 가져 옴

			for (int i = 0; i < allValues.length; i++) {	// 배열에서 저장할 때 사용한 쿠키 이름인 cookieTest로 검색해 쿠키 값을 가져 옴

				if (allValues[i].getName().equals("cookieTest")) {

					out.println("	<h2>Cookie값 가져오기: " + URLDecoder.decode(allValues[i].getValue(), "utf-8") + "</h2>");

				} else {

					out.println("	<h2>쿠키 값이 없습니다</h2>");

				}

			}

		}

		out.println("</body>");
		out.println("</html>");
		out.close();

	}

	@Override
	public void destroy() {

		System.out.println("GetSessionCookie.destroy() 실행");

	}

}
