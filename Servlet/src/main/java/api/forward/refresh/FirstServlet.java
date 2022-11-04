package api.forward.refresh;

import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/firstRefresh")
@SuppressWarnings("serial")
public class FirstServlet extends HttpServlet {

	@Override
	public void init(ServletConfig config) throws ServletException {

		System.out.println("FirstServlet.init() 실행");

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

		System.out.println("FirstServlet.handle() 실행");

		// 응답
		response.addHeader("Refresh", "1;url=secondRefresh?name=lee");	// 1초 후 서블릿 secondRefresh로 재요청

	}

	@Override
	public void destroy() {

		System.out.println("FirstServlet.destroy() 실행");

	}

}
