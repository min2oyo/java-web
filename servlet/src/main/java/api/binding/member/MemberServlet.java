package api.binding.member;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/member")
@SuppressWarnings("serial")
public class MemberServlet extends HttpServlet {

	@Override
	public void init(ServletConfig config) throws ServletException {

		System.out.println("MemberServlet.init() 실행");

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

		System.out.println("MemberServlet.doHandle() 실행");

		// 요청
		request.setCharacterEncoding("utf-8");

		// 응답
		response.setContentType("text/html;charset=utf-8");

		MemberDAO dao = new MemberDAO();
		List<MemberVO> memberList = dao.listMembers();
		request.setAttribute("memberList", memberList);	// 조회된 회원 정보를 ArrayList 객체에 저장한 후 request에 바인딩

		RequestDispatcher dispatch = request.getRequestDispatcher("viewMembers");	// 바인딩 한 request를 viewMembers 서블릿으로 포워딩
		dispatch.forward(request, response);

	}

	@Override
	public void destroy() {

		System.out.println("MemberServlet.destroy() 실행");

	}

}
