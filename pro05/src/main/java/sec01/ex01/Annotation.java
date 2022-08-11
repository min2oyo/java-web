package sec01.ex01;

import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/third")
@SuppressWarnings("serial")
public class Annotation extends HttpServlet {

	@Override
	public void init(ServletConfig config) throws ServletException {

		System.out.println("ThirdServlet.init() 실행");

	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		System.out.println("ThirdServlet.doGet() 실행");

	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		System.out.println("ThirdServlet.doPost() 실행");

	}

	@Override
	public void destroy() {

		System.out.println("ThirdServlet.destroy() 실행");

	}

}
