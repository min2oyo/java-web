package mapping;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@SuppressWarnings("serial")
public class XmlB extends HttpServlet {

	@Override
	public void init() throws ServletException {

		System.out.println("SecondServlet.init() 실행");

	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		System.out.println("SecondServlet.doGet() 실행");

	}

	@Override
	public void destroy() {

		System.out.println("SecondServlet.dstroy() 실행");

	}

}
