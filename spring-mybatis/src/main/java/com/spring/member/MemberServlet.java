package com.spring.member;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

		} else if (action.equals("insertMember")) {						// 회원 추가 | memberVO

			String id = request.getParameter("id");
			String pwd = request.getParameter("pwd");
			String name = request.getParameter("name");
			String email = request.getParameter("email");
			memberVO.setId(id);
			memberVO.setPwd(pwd);
			memberVO.setName(name);
			memberVO.setEmail(email);
			memberDao.insertMember(memberVO);

			nextPage = "/member?action=listMembers";

		} else if (action.equals("insertMember2")) {	// 회원 추가 | HashMap

			String id = request.getParameter("id");
			String pwd = request.getParameter("pwd");
			String name = request.getParameter("name");
			String email = request.getParameter("email");
			Map<String, String> memberMap = new HashMap<String, String>();
			memberMap.put("id", id);
			memberMap.put("pwd", pwd);
			memberMap.put("name", name);
			memberMap.put("email", email);
			memberDao.insertMember2(memberMap);

			nextPage = "/member?action=listMembers";

		} else if (action.equals("updateMember")) {		// 회원 수정

			String id = request.getParameter("id");
			String pwd = request.getParameter("pwd");
			String name = request.getParameter("name");
			String email = request.getParameter("email");
			memberVO.setId(id);
			memberVO.setPwd(pwd);
			memberVO.setName(name);
			memberVO.setEmail(email);
			memberDao.updateMember(memberVO);

			nextPage = "/member?action=listMembers";

		} else if (action.equals("deleteMember")) {		// 회원 삭제

			System.out.println("경과 1");
			String id = request.getParameter("id");
			System.out.println("경과 2");
			memberDao.deleteMember(id);
			System.out.println("경과 3");

			nextPage = "/member?action=listMembers";

//		} else if (action.equals("searchMember")) {
//
//			String name = request.getParameter("name");
//			String email = request.getParameter("email");
//			memberVO.setName(name);
//			memberVO.setEmail(email);
//			List<MemberVO> membersList = memberDao.searchMember(memberVO);
//			request.setAttribute("membersList", membersList);
//			nextPage = "/views/listMembers.jsp";
//
//		} else if (action.equals("foreachSelect")) {
//
//			List<String> nameList = new ArrayList<String>();
//			nameList.add("ȫ�浿");
//			nameList.add("������");
//			nameList.add("�̼���");
//			List<MemberVO> membersList = memberDao.foreachSelect(nameList);
//			request.setAttribute("membersList", membersList);
//			nextPage = "/views/listMembers.jsp";
//
//		} else if (action.equals("foreachInsert")) {
//
//			List<MemberVO> memList = new ArrayList<MemberVO>();
//			memList.add(new MemberVO("m1", "1234", "�ڱ浿", "m1@test.com"));
//			memList.add(new MemberVO("m2", "1234", "�̱浿", "m2@test.com"));
//			memList.add(new MemberVO("m3", "1234", "��浿", "m3@test.com"));
//			int result = memberDao.foreachInsert(memList);
//			nextPage = "/member?action=listMembers";
//
//		} else if (action.equals("selectLike")) {
//
//			String name = "�浿";
//			List<MemberVO> membersList = memberDao.selectLike(name);
//			request.setAttribute("membersList", membersList);
//			nextPage = "/views/listMembers.jsp";
//
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
