package api.forward.dispatch;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/firstDispatch")
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
		response.setContentType("text/html;charset=utf-8");

		RequestDispatcher dispatch = request.getRequestDispatcher("/secondDispatch?name=lee");

		dispatch.forward(request, response);

	}

	@Override
	public void destroy() {

		System.out.println("FirstServlet.destroy() 실행");

	}

}
