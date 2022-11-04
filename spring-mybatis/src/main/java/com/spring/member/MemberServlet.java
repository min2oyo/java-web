package com.spring.member;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/member")
public class MemberServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doHandle(request, response);

	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doHandle(request, response);

	}

	private void doHandle(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");

		MemberVO memberVO = new MemberVO();
		MemberDAO memberDao = new MemberDAO();
		String action = request.getParameter("action");
		String nextPage = null;

		// 경로
		if (action == null || action.equals("listMembers")) {	// 회원 목록

			List<MemberVO> membersList = memberDao.selectAllMemberList();	// 택1: MemberVO
//		List<HashMap<String, String>> membersList = dao.selectAllMemberList2();	// 택2: HashMap
			request.setAttribute("membersList", membersList);

			nextPage = "/views/listMembers.jsp";

		} else if (action.equals("selectMemberById")) {				// 아이디 검색

			String id = request.getParameter("value");
			memberVO = memberDao.selectMemberById(id);
			request.setAttribute("member", memberVO);

			nextPage = "/views/memberInfo.jsp";

		} else if (action.equals("selectMemberByPwd")) {			// 비밀번호 검색

			int pwd = Integer.parseInt(request.getParameter("value"));
			List<MemberVO> membersList = memberDao.selectMemberByPwd(pwd);
			request.setAttribute("membersList", membersList);

			nextPage = "/views/listMembers.jsp";

		}

		// 이름, 비밀번호 조회
		String name = memberDao.selectName();
		int pwd = memberDao.selectPwd();

		System.out.println("이름: " + name);
		System.out.println("비밀번호: " + pwd);

		// 이동
		RequestDispatcher dispatch = request.getRequestDispatcher(nextPage);
		dispatch.forward(request, response);

	}

}
