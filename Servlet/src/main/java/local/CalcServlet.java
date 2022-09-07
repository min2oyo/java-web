package local;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/calc")
@SuppressWarnings("serial")
public class CalcServlet extends HttpServlet {

	@Override
	public void init(ServletConfig config) throws ServletException {

		System.out.println("CalcServlet.init() 실행");

	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		System.out.println("CalcServlet.doGet() 실행");

		// 요청
		request.setCharacterEncoding("utf-8");

		String[][] money = { { "dollar", "달러", "1124.70" }, { "en", "엔화", "10.113" }, { "yuan", "위안", "163.30" }, { "pound", "파운드", "1444.35" }, { "euro", "유로", "1295.97" } };	// 데이터
		String won = request.getParameter("won");			// 원화
		won = won == null ? "" : won;						// 출력 조정
		String operator = request.getParameter("operator");	// 외화 종류
		String command = request.getParameter("command");	// 요청
		String selected = "";
		String result = null;

		// 응답
		response.setContentType("text/html;charset=utf-8");

		PrintWriter out = response.getWriter();

		out.println("<html>");
		out.println("<head>");
		out.println("	<title>환율 계산기</title>");
		out.println("</head>");
		out.println("<body>");
		out.println("	<font size=5>환율 계산기</font><br>");
		out.println("	<form action='/servlet/calc' method='get'>");
		out.println("		원화: <input type='number' name='won' value='" + won + "' size=10 />");
		out.println("		<select name='operator'>");

		for (int i = 0; i < money.length; i++) {	// 환전 선택 지정

			selected = operator != null && operator.equals(money[i][0]) ? " selected" : "";
			out.println("			<option value='" + money[i][0] + "'" + selected + ">" + money[i][1] + "</option>");

		}

		out.println("		</select>");
		out.println("		<input type='hidden' name='command' value='calculate' /><br>");
		out.println("		<input type='submit' value='변환' />");
		out.println("		<a href='/servlet/calc'><input type='button' value='초기화' /></a>");
		out.println("	</form>");

		if (won != "" && command != null && command.equals("calculate")) {	// 환율 계산

			for (int i = 0; i < money.length; i++) {

				if (operator.equals(money[i][0])) {

					result = String.format("%.6f", Float.parseFloat(won) / Float.parseFloat(money[i][2]));
					break;

				}

			}

			out.println("	<font size=10>변환 결과: " + result + "</font><br>");

		}

		out.println("	<font size='5'>환율 현황</font><br>");

		for (int i = 0; i < money.length; i++) {	// 환율 현황

			out.println("	" + money[i][1] + ": " + money[i][2] + "<br>");

		}

		out.println("</body>");
		out.println("</html>");

	}

	@Override
	public void destroy() {

		System.out.println("CalcServlet.destroy() 실행");

	}

}
