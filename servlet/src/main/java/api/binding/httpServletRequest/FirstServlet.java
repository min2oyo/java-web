package api.binding.httpServletRequest;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/firstHttpServletRequest")
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

		// 요청
		request.setCharacterEncoding("utf-8");
		request.setAttribute("address", "서울시 강남구");	// 웹 브라우저의 최초 요청 request에 바인딩

		// 응답
		response.setContentType("text/html;charset=utf-8");

		RequestDispatcher dispatch = request.getRequestDispatcher("secondHttpServletRequest");	// 바인딩 된 request를 다시 두 번째 서블릿으로 포워드

		dispatch.forward(request, response);

	}

	@Override
	public void destroy() {

		System.out.println("FirstServlet.destroy() 실행");

	}

}
