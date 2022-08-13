package api.binding.member;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/viewMembers")
@SuppressWarnings({ "serial", "unchecked" })
public class viewServlet extends HttpServlet {

	@Override
	public void init(ServletConfig config) throws ServletException {

		System.out.println("viewServlet.init() 실행");

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

		System.out.println("viewServlet.doHandle() 실행");

		// 요청
		request.setCharacterEncoding("utf-8");

		// 응답
		response.setContentType("text/html;charset=utf-8");

		List<MemberVO> membersList = (List<MemberVO>) request.getAttribute("memberList");

		PrintWriter out = response.getWriter();

		out.println("<html>");

		out.println("<head>");
		out.println("	<title>Member</title>");
		out.println("</head>");
		out.println("<body>");
		out.println("	<h1>회원 현황</h1>");
		out.println("	<table border=1>");
		out.println("		<tr align='center' bgcolor='lightgreen'>");
		out.println("			<td>아이디</td>");
		out.println("			<td>비밀번호</td>");
		out.println("			<td>이름</td>");
		out.println("			<td>이메일</td>");
		out.println("			<td>가입일</td>");
		out.println("			<td>삭제</td>");
		out.println("		</tr>");

		for (int i = 0; i < membersList.size(); i++) {

			MemberVO memberVO = membersList.get(i);

			String id = memberVO.getId();
			String pwd = memberVO.getPwd();
			String name = memberVO.getName();
			String email = memberVO.getEmail();
			Date joinDate = memberVO.getJoinDate();

			out.println("		<tr>");
			out.println("			<td>" + id + "</td>");
			out.println("			<td>" + pwd + "</td>");
			out.println("			<td>" + name + "</td>");
			out.println("			<td>" + email + "</td>");
			out.println("			<td>" + joinDate + "</td>");
			out.println("			<td><a href='/servlet/member?command=delMember&id=" + id + "'>삭제</a></td>");
			out.println("		</tr>");

		}

		out.println("	</table>");
		out.println("	<a href='/servlet/views/oracle/memberForm.html'>새 회원 등록하기</a");
		out.println("</body>");
		out.println("</html>");

	}

	@Override
	public void destroy() {

		System.out.println("viewServlet.destroy() 실행");

	}

}
