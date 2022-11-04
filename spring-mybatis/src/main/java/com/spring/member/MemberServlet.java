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

		MemberDAO dao = new MemberDAO();

		// 회원 목록
		List<MemberVO> membersList = dao.selectAllMemberList();	// 택1: MemberVO
//		List<HashMap<String, String>> membersList = dao.selectAllMemberList2();	// 택2: HashMap
		request.setAttribute("membersList", membersList);

		// 이름, 비밀번호 조회
		String name = dao.selectName();
		int pwd = dao.selectPwd();

		System.out.println("이름: " + name);
		System.out.println("비밀번호: " + pwd);

		// 이동
		RequestDispatcher dispatch = request.getRequestDispatcher("/views/listMembers.jsp");
		dispatch.forward(request, response);

	}

}
