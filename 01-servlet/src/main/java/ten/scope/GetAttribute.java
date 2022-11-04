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

@WebServlet("/getAttribute")
@SuppressWarnings("serial")
public class GetAttribute extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		System.out.println("GetAttribute.doGet() 실행");

		// ------ 요청 ------
		request.setCharacterEncoding("utf-8");

		// ------ 응답 ------
		response.setContentType("text/html;charset=utf-8");

		// 초기화
		ServletContext ctx = getServletContext();
		HttpSession sess = request.getSession();

		String ctxMsg = (String) ctx.getAttribute("context");
		String sesMsg = (String) sess.getAttribute("session");
		String reqMsg = (String) request.getAttribute("request");

		// 출력
		PrintWriter out = response.getWriter();

		out.println("<html>");
		out.println("<head>");
		out.println("	<title>메인</title>");
		out.println("</head>");
		out.println("<body>");
		out.println("	context값: " + ctxMsg + "<br>");
		out.println("	session값: " + sesMsg + "<br>");
		out.println("	request값: " + reqMsg + "<br>");
		out.println("</body>");
		out.println("</html>");
		out.close();

	}

	@Override
	public void destroy() {

		System.out.println("GetAttribute.destroy() 실행");

	}

}
