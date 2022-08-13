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

@WebServlet("/getContext")
@SuppressWarnings("serial")
public class GetServletContext extends HttpServlet {

//	@Override
//	public void init(ServletConfig config) throws ServletException {	// 주석 풀면 'ServletContext context = getServletContext()'와 충돌(?) 생김
//
//		System.out.println("GetServletContext.init() 실행");
//
//	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		System.out.println("GetServletContext.doGet() 실행");

		// ------ 응답 ------
		response.setContentType("text/html;charset=utf-8");

		// 초기화
		ServletContext context = getServletContext();					// ServletContext 객체를 가져옴
		List<?> member = (ArrayList<?>) context.getAttribute("member");	// member로 이전에 바인딩 된 회원 정보를 가져옴
		String name = (String) member.get(0);
		int age = (int) member.get(1);

		// 출력
		PrintWriter out = response.getWriter();

		out.println("<html>");
		out.println("<head>");
		out.println("	<title>회원 조회</title>");
		out.println("</head>");
		out.println("<body>");
		out.println("	" + name + "<br>");
		out.println("	" + age + "<br>");
		out.println("</body>");
		out.println("</html>");

	}

	@Override
	public void destroy() {

		System.out.println("GetServletContext.destroy() 실행");

	}

}
