package api.servletContext.basic;

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

@WebServlet("/setContext")
@SuppressWarnings("serial")
public class SetServletContext extends HttpServlet {

//	@Override
//	public void init(ServletConfig config) throws ServletException {	// 주석 풀면 'ServletContext context = getServletContext()'와 충돌(?) 생김
//
//		System.out.println("SetServletContext.init() 실행");
//
//	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		System.out.println("SetServletContext.doGet() 실행");

		// ------ 응답 ------
		response.setContentType("text/html;charset=utf-8");

		ServletContext context = getServletContext();	// ServletContext 객체를 가져옴

		// 초기화
		String name = "이혜리";
		int age = 30;

		// 저장
		List<Object> member = new ArrayList<>();

		member.add(name);
		member.add(age);

		context.setAttribute("member", member);			// ServletContext 객체에 바인딩 함

		// 출력
		PrintWriter out = response.getWriter();

		out.println("<html>");
		out.println("<head>");
		out.println("	<title>회원 설정</title>");
		out.println("</head>");
		out.println("<body>");
		out.println("	" + name + "와 " + age + "설정");
		out.println("<body>");
		out.println("</body>");
		out.println("</html>");

	}

	@Override
	public void destroy() {

		System.out.println("SetServletContext.destroy() 실행");

	}

}
