package local;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/gugudan")
@SuppressWarnings("serial")
public class Gugudan extends HttpServlet {

	@Override
	public void init(ServletConfig config) throws ServletException {

		System.out.println("Gugudan.init() 실행");

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

		System.out.println("Gugudan.doHandle() 실행");

		// 요청
		request.setCharacterEncoding("utf-8");	// 전송된 데이터를 utf-8로 인코딩

		int dan = Integer.parseInt(request.getParameter("dan"));

		// 응답
		response.setContentType("text/html;charset=utf-8");

		PrintWriter out = response.getWriter();	// HttpServletResponse 객체의 getWriter()를 이용해 출력 스트림 PrintWriter 객체를 받아 옴

		out.println("<html>");
		out.println("<head>");
		out.println("	<title>구구단</title>");
		out.println("</head>");
		out.println("<body>");
		out.println("	<table border=1 width=500 align=center>");
		out.println("		<tr align=center bgcolor='#ffff66'>");
		out.println("			<td colspan=3>" + dan + "단 출력</td>");
		out.println("		</tr>");

		for (int i = 1; i < 10; i++) {

			if (i % 2 == 0) {

				out.println("		<tr align=center bgcolor='#acfa58'>");

			} else {

				out.println("		<tr align=center bgcolor='#81bef7'>");

			}

			out.println("			<td width=50><input type='radio' />" + i + "</td>");
			out.println("			<td width=50><input type='checkbox' />" + i + "</td>");
			out.println("			<td width=400>" + dan + " * " + i + " = " + i * dan + "</td>");
			out.println("		</tr>");

		}

		out.println("	</table>");
		out.println("</body>");
		out.println("</html>");

	}

	@Override
	public void destroy() {

		System.out.println("Gugudan.destroy() 실행");

	}

}
