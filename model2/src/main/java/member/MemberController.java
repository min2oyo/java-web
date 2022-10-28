package member;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/member/*")	// 브라우저에서 요청 시 두 단계로 이러어짐
public class MemberController extends HttpServlet {

	private static final long serialVersionUID = 1L;
	MemberDAO memberDAO;

	@Override
	public void init(ServletConfig config) throws ServletException {

		System.out.println("member.init() 실행");

		memberDAO = new MemberDAO();

	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		System.out.println("member.doGet() 실행");

		doHandle(request, response);

	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		System.out.println("member.doPost() 실행");

		doHandle(request, response);

	}

	private void doHandle(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String nextPage = null;
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");

		String action = request.getPathInfo();	// URL에서 요청명을 가져옴
		System.out.println("action: " + action);

		if (action == null || action.equals("/list")) {	// 회원 목록

			List<MemberVO> membersList = memberDAO.listMembers();
			request.setAttribute("membersList", membersList);
			nextPage = "/views/member/list.jsp";

		} else if (action.equals("/add")) {	// 회원 추가

			String id = request.getParameter("id");
			String pwd = request.getParameter("pwd");
			String name = request.getParameter("name");
			String email = request.getParameter("email");
			MemberVO memberVO = new MemberVO(id, pwd, name, email);
			memberDAO.addMember(memberVO);
			nextPage = "/member/list";

		} else if (action.equals("/sing-up")) {	// 회원가입 이동

			nextPage = "/views/member/sing-up.jsp";

		} else {	// 회원 목록

			List<MemberVO> membersList = memberDAO.listMembers();
			request.setAttribute("membersList", membersList);
			nextPage = "/views/member/list.jsp";

		}

		RequestDispatcher dispatch = request.getRequestDispatcher(nextPage);
		dispatch.forward(request, response);

	}

	@Override
	public void destroy() {

		System.out.println("member.destroy() 실행");

	}

}
