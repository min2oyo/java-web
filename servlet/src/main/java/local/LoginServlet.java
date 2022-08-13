package local;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/login")
@SuppressWarnings("serial")
public class LoginServlet extends HttpServlet {

	@Override
	public void init(ServletConfig config) throws ServletException {

		System.out.println("LoginServlet.init() 실행");

	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doHandle(request, response);

	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doHandle(request, response);

	}

	protected void doHandle(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		System.out.println("LoginServlet.doHandle() 실행");

		// 요청 1
		System.out.println("\n요청 1");
		request.setCharacterEncoding("utf-8");	// 전송된 데이터를 utf-8로 인코딩

		String userId = request.getParameter("user_id");
		String userPw = request.getParameter("user_pw");
		String address = request.getParameter("user_address");
		String[] subject = request.getParameterValues("subject");
		System.out.println("아이디: " + userId);
		System.out.println("비밀번호: " + userPw);
		System.out.println("주소: " + address);

		if (subject != null) {

			for (String str : subject) {

				System.out.println("선택한 과목: " + str);

			}

		}

		// 요청2
		System.out.println("\n요청 2");
		Enumeration<String> enu = request.getParameterNames();	// 전송되어 온 name 속성들만 Enumeration 타입으로 받아 옴

		while (enu.hasMoreElements()) {	// 각 name을 하나씩 가져와 대응해서 전송되어 온 값을 출력

			String name = enu.nextElement();
			String[] values = request.getParameterValues(name);

			for (String value : values) {

				System.out.println("name: " + name + ", value: " + value);

			}

		}

		// 응답
		response.setContentType("text/html;charset=utf-8");

		PrintWriter out = response.getWriter();	// HttpServletResponse 객체의 getWriter()를 이용해 출력 스트림 PrintWriter 객체를 받아 옴

		out.println("<html>");
		out.println("<head>");
		out.println("	<title>로그인 결과</title>");
		out.println("</head>");
		out.println("	<body>");

		if (userId.equals("admin")) {

			out.println("		<font size=12>관리자로 로그인하셨습니다!!</font><br>");
			out.println("		<input type='button' value='회원정보 수정하기' />");
			out.println("		<input type='button' value='회원정보 삭제하기' />");

		} else if (userId != null && userId.length() != 0) {

			out.println("		" + userId + "님! 로그인 하셨습니다<br>");

		} else {

			out.println("		아이디를 입력하세요!!<br>");
			out.println("		<a href='/servlet/views/local/login/login.html'>로그인 창으로 이동</a><br>");

		}

		out.println("	</body>");
		out.println("</html>");

	}

	@Override
	public void destroy() {

		System.out.println("LoginServlet.destroy() 실행");

	}

}
