package ten.scope;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/setAttribute")
@SuppressWarnings("serial")
public class SetAttribute extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		System.out.println("SetAttribute.doGet() 실행");

		// ------ 요청 ------
		request.setCharacterEncoding("utf-8");

		// ------ 응답 ------
		response.setContentType("text/html;charset=utf-8");

		// 초기화
		HttpSession session = request.getSession();
		ServletContext ctx = getServletContext();

		ctx.setAttribute("context", "context에 반인딩됩니다.");		// 객체를 얻은 후 속성을 바인딩 함

		session.setAttribute("session", "session에 반인딩됩니다.");	// 객체를 얻은 후 속성을 바인딩 함

		request.setAttribute("request", "request에 반인딩됩니다.");	// 객체를 얻은 후 속성을 바인딩 함

		// 출력
		PrintWriter out = response.getWriter();

		out.println("<html>");
		out.println("<head>");
		out.println("	<title>메인</title>");
		out.println("</head>");
		out.println("<body>");
		out.println("	바인딩을 수행합니다.<br>");
		out.println("	<a href='/servlet/getAttribute'>확인</a>");
		out.println("</body>");
		out.println("</html>");
		out.close();

	}

	@Override
	public void destroy() {

		System.out.println("SetAttribute.destroy() 실행");

	}

}
