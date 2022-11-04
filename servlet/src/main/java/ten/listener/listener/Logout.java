package ten.listener.listener;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/listenerLogout")
@SuppressWarnings("serial")
public class Logout extends HttpServlet {

	ServletContext context;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		System.out.println("Logout.doGet() 실행");
		doHandle(request, response);

	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		System.out.println("Logout.doPost() 실행");
		doHandle(request, response);

	}

	private void doHandle(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		// ------ 요청 ------
		request.setCharacterEncoding("utf-8");

		// ------ 응답 ------
		response.setContentType("text/html;charset=utf-8");

		// 초기화
		context = getServletContext();
		HttpSession session = request.getSession();

		String userId = request.getParameter("userId");	// userList에서 삭제할 ID를 가져옴
		session.invalidate();	// 로그아웃 시 세션을 소멸

		List<?> userList = (ArrayList<?>) context.getAttribute("userList");	// userList에서 로그아웃한 접속자 ID를 삭제한 후 다시 userList를 컨텍스트에 저장
		userList.remove(userId);
		context.removeAttribute("userList");
		context.setAttribute("userList", userList);

		// 출력
		PrintWriter out = response.getWriter();

		out.println("<html>");
		out.println("<head>");
		out.println("	<title>Test Servlet 3</title>");
		out.println("</head>");
		out.println("<body>");
		out.println("	로그아웃 했습니다.<br>");
		out.println("</body>");
		out.println("</html>");
		out.close();

	}

	@Override
	public void destroy() {

		System.out.println("Logout.destroy() 실행");

	}

}
