package api.forward.dispatch;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/secondDispatch")
@SuppressWarnings("serial")
public class SecondServlet extends HttpServlet {

	@Override
	public void init(ServletConfig config) throws ServletException {

		System.out.println("SecondServlet.init() 실행");

	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doHandle(request, response);

	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doHandle(request, response);

	}

	private void doHandle(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		System.out.println("SecondServlet.handle() 실행");

		// 요청
		String name = request.getParameter("name");

		// 응답
		response.setContentType("text/html;charset=utf-8");

		PrintWriter out = response.getWriter();

		out.println("<html>");
		out.println("<head>");
		out.println("	<title>dispatch</title>");
		out.println("</head>");
		out.println("<body>");
		out.println("	dispatch를 이용한 forward 실습입니다.<br>");
		out.println("	이름: " + name);
		out.println("</body>");
		out.println("</html>");

	}

	@Override
	public void destroy() {

		System.out.println("SecondServlet.destroy() 실행");

	}

}
