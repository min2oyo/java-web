package input;


import java.io.IOException;
import java.util.Enumeration;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/input2")
@SuppressWarnings("serial")
public class InputServlet2 extends HttpServlet {

	@Override
	public void init(ServletConfig config) throws ServletException {

		System.out.println("InputServlet2.init() 실행");

	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 웹 브라우저에서 전송한 정보를 톰캣 컨테이너가 HttpServletRequest 객체를 생성한 후 doGet()으로 넘겨줌

		System.out.println("InputServlet2.doGet() 실행");

		request.setCharacterEncoding("utf-8");	// 전송된 데이터를 utf-8로 인코딩

		Enumeration<String> enu = request.getParameterNames();	// 전송되어 온 name 속성들만 Enumeration 타입으로 받아 옴

		while (enu.hasMoreElements()) {	// 각 name을 하나씩 가져와 대응해서 전송되어 온 값을 출력

			String name = enu.nextElement();
			String[] values = request.getParameterValues(name);

			for (String value : values) {

				System.out.println("name: " + name + ", value: " + value);

			}

		}

	}

	@Override
	public void destroy() {

		System.out.println("InputServlet2.destroy() 실행");

	}

}
