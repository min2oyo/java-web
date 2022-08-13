package input;


import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/input")
@SuppressWarnings("serial")
public class InputServlet extends HttpServlet {

	@Override
	public void init(ServletConfig config) throws ServletException {

		System.out.println("InputServlet.init() 실행");

	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 웹 브라우저에서 전송한 정보를 톰캣 컨테이너가 HttpServletRequest 객체를 생성한 후 doGet()으로 넘겨줌

		System.out.println("InputServlet.doGet() 실행");

		request.setCharacterEncoding("utf-8");	// 전송된 데이터를 utf-8로 인코딩

		String userId = request.getParameter("user_id");
		String userPw = request.getParameter("user_pw");
		String[] subject = request.getParameterValues("subject");

		System.out.println("아이디: " + userId);
		System.out.println("비밀번호: " + userPw);

		for (String str : subject) {

			System.out.println("선택한 과목: " + str);

		}

	}

	@Override
	public void destroy() {

		System.out.println("InputServlet.destroy() 실행");

	}

}
