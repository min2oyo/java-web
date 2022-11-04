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

@WebServlet("/listener")
@SuppressWarnings("serial")
public class Login extends HttpServlet {

	ServletContext context = null;
	List<String> userList = new ArrayList<String>();	// 로그인한 접속자 ID를 저장

//	@Override
//	public void init(ServletConfig config) throws ServletException {
//
//		System.out.println("Login.init() 실행");
//
//	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		System.out.println("Login.doPost() 실행");

		// ------ 요청 ------
		request.setCharacterEncoding("utf-8");

		// ------ 응답 ------
		response.setContentType("text/html;charset=utf-8");

		// 초기화
		context = getServletContext();
		HttpSession session = request.getSession();

		String userId = request.getParameter("userId");
		String userPw = request.getParameter("userPw");

		LoginImpl loginUser = new LoginImpl(userId, userPw);	// LoginImpl 객체를 생성한 후 전송된 ID와 비밀번호를 저장

		if (session.isNew()) {	// 최초 로그인 시 접속자 ID를 ArrayList에 차례로 저장한 후 다시 context 객체에 속성으로 저장

			session.setAttribute("loginUser", loginUser);
			userList.add(userId);
			context.setAttribute("userList", userList);

		}

		// 출력
		PrintWriter out = response.getWriter();

		out.println("<html>");
		out.println("<head>");
		out.println("	<title>Hello</title>");
		out.println("</head>");
		out.println("<body>");
		out.println("	ID: " + loginUser.userId + "<br>");
		out.println("	총 접속자수: " + LoginImpl.totalUser + "<br>");	// 세션에 바인딩 이벤트 처리 후 총 접속자 수를 표시
		out.println("	접속 ID: <br>");

		List<?> list = (ArrayList<?>) context.getAttribute("userList");	// context 객체의 ArrayList를 가져와 접속자 ID를 차레로 브라우저로 출력

		for (int i = 0; i < list.size(); i++) {

			out.println("	" + list.get(i) + "<br>");

		}

		out.println("	<a href='listenerLogout?userId=" + userId + "'>로그아웃</a>");	// 로그아웃 클릭시 서블릿 logout으로 접속자 ID를 전송해 로그아웃
		out.println("</body>");
		out.println("</html>");
		out.close();

	}

	@Override
	public void destroy() {

		System.out.println("Login.destroy() 실행");

	}

}
