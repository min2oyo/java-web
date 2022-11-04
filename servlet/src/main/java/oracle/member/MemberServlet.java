//package oracle.member;
//
//import java.io.IOException;
//import java.io.PrintWriter;
//import java.util.Date;
//import java.util.List;
//
//import javax.servlet.ServletConfig;
//import javax.servlet.ServletException;
//import javax.servlet.annotation.WebServlet;
//import javax.servlet.http.HttpServlet;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//
//import binding.member.MemberDAO;
//import binding.member.MemberVO;
//
//@WebServlet("/member")
//@SuppressWarnings("serial")
//public class MemberServlet extends HttpServlet {
//
//	@Override
//	public void init(ServletConfig config) throws ServletException {
//
//		System.out.println("MemberServlet.init() 실행");
//
//	}
//
//	@Override
//	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//
//		doHandle(request, response);
//
//	}
//
//	@Override
//	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//
//		doHandle(request, response);
//
//	}
//
//	private void doHandle(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//
//		System.out.println("MemberServlet.doHandle() 실행");
//
//		// 요청
//		request.setCharacterEncoding("utf-8");
//
//		// 응답
//		response.setContentType("text/html;charset=utf-8");
//
//		String command = request.getParameter("command");	// command 값을 받아 옴
//		MemberDAO dao = new MemberDAO();
//		PrintWriter out = response.getWriter();
//
//		if (command != null && command.equals("addMember")) {	// 회원 추가
//
//			MemberVO memberVO = new MemberVO();
//
//			memberVO.setId(request.getParameter("id"));	// 전송된 값들을 VO객체에 저장하고 SQL문을 이용해 전달
//			memberVO.setPwd(request.getParameter("pwd"));
//			memberVO.setName(request.getParameter("name"));
//			memberVO.setEmail(request.getParameter("email"));
//
//			dao.addMember(memberVO);
//
//		} else if (command != null && command.equals("delMember")) {	// 회원 삭제
//
//			dao.delMember(request.getParameter("id"));	// id를 가져와 SQL문으로 전달해 삭제
//
//		}
//
//		List<MemberVO> list = dao.listMembers();
//
//		out.println("<html>");
//
//		out.println("<head>");
//		out.println("	<title>Member</title>");
//		out.println("</head>");
//		out.println("<body>");
//		out.println("	<h1>회원 현황</h1>");
//		out.println("	<table border=1>");
//		out.println("		<tr align='center' bgcolor='lightgreen'>");
//		out.println("			<td>아이디</td>");
//		out.println("			<td>비밀번호</td>");
//		out.println("			<td>이름</td>");
//		out.println("			<td>이메일</td>");
//		out.println("			<td>가입일</td>");
//		out.println("			<td>삭제</td>");
//		out.println("		</tr>");
//
//		for (int i = 0; i < list.size(); i++) {
//
//			MemberVO memberVO = list.get(i);
//
//			String id = memberVO.getId();
//			String pwd = memberVO.getPwd();
//			String name = memberVO.getName();
//			String email = memberVO.getEmail();
//			Date joinDate = memberVO.getJoinDate();
//
//			out.println("		<tr>");
//			out.println("			<td>" + id + "</td>");
//			out.println("			<td>" + pwd + "</td>");
//			out.println("			<td>" + name + "</td>");
//			out.println("			<td>" + email + "</td>");
//			out.println("			<td>" + joinDate + "</td>");
//			out.println("			<td><a href='/servlet/member?command=delMember&id=" + id + "'>삭제</a></td>");
//			out.println("		</tr>");
//
//		}
//
//		out.println("	</table>");
//		out.println("	<a href='/servlet/views/oracle/memberForm.html'>새 회원 등록하기</a");
//		out.println("</body>");
//		out.println("</html>");
//
//	}
//
//	@Override
//	public void destroy() {
//
//		System.out.println("MemberServlet.destroy() 실행");
//
//	}
//
//}
