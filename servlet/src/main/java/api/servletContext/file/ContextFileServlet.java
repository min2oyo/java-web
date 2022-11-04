package api.servletContext.file;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/contextFile")
@SuppressWarnings("serial")
public class ContextFileServlet extends HttpServlet {

//	@Override
//	public void init(ServletConfig config) throws ServletException {	// 주석 풀면 'ServletContext context = getServletContext()'와 충돌(?) 생김
//
//		System.out.println("ContextParamServlet.init() 실행");
//
//	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		System.out.println("ContextParamServlet.doGet() 실행");

		// ------ 요청 ------
		request.setCharacterEncoding("utf-8");

		// ------ 응답 ------
		response.setContentType("text/html;charset=utf-8");

		// 초기화
		ServletContext context = getServletContext();					// ServletContext 객체를 가져옴
		InputStream is = context.getResourceAsStream("/WEB-INF/bin/init.txt");
		BufferedReader buffer = new BufferedReader(new InputStreamReader(is));	// 해당 위치의 파일을 읽어 들임

		String menu = null;
		String menuMember = null;
		String menuOrder = null;
		String menuGoods = null;

		// 작업
		while ((menu = buffer.readLine()) != null) {	// 콤마(,)로 메뉴 항목 분리

			StringTokenizer tokens = new StringTokenizer(menu, ",");
			menuMember = tokens.nextToken();
			menuOrder = tokens.nextToken();
			menuGoods = tokens.nextToken();

		}

		// 출력
		PrintWriter out = response.getWriter();

		out.println("<html>");
		out.println("<head>");
		out.println("	<title>메뉴</title>");
		out.println("</head>");
		out.println("<body>");
		out.println("	" + menuMember + "<br>");
		out.println("	" + menuOrder + "<br>");
		out.println("	" + menuGoods + "<br>");
		out.println("</body>");
		out.println("</html>");
		out.close();

	}

	@Override
	public void destroy() {

		System.out.println("ContextParamServlet.destroy() 실행");

	}

}
