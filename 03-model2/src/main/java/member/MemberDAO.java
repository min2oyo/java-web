package member;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class MemberDAO {

	private DataSource dataFactory;
	private Connection conn;
	private PreparedStatement pstmt;

	public MemberDAO() {

		try {

			Context ctx = new InitialContext();
			Context envContext = (Context) ctx.lookup("java:/comp/env");
			dataFactory = (DataSource) envContext.lookup("jdbc/oracle");

		} catch (Exception e) {

			e.printStackTrace();

		}

	}

	// 회원 조회
	public List<MemberVO> listMembers() {

		List<MemberVO> membersList = new ArrayList<MemberVO>();

		try {

			conn = dataFactory.getConnection();
			String query = "select * from t_member order by joinDate desc";
			pstmt = conn.prepareStatement(query);
			ResultSet rs = pstmt.executeQuery();

			while (rs.next()) {

				String id = rs.getString("id");
				String pwd = rs.getString("pwd");
				String name = rs.getString("name");
				String email = rs.getString("email");
				Date joinDate = rs.getDate("joinDate");
				MemberVO memberVO = new MemberVO(id, pwd, name, email, joinDate);
				membersList.add(memberVO);

			}

			rs.close();
			pstmt.close();
			conn.close();

		} catch (SQLException e) {

			e.printStackTrace();

		}

		return membersList;

	}

	// 회원 추가
	public void addMember(MemberVO memberVO) {

		try {

			conn = dataFactory.getConnection();
			String id = memberVO.getId();
			String pwd = memberVO.getPwd();
			String name = memberVO.getName();
			String email = memberVO.getEmail();
			String query = "INSERT INTO t_member(id, pwd, name, email) VALUES(?, ? ,? ,?)";
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, id);
			pstmt.setString(2, pwd);
			pstmt.setString(3, name);
			pstmt.setString(4, email);
			pstmt.executeUpdate();	// SQL문 실행
			pstmt.close();
			conn.close();

		} catch (SQLException e) {

			e.printStackTrace();

		}

	}

	// 회원 조회
	public MemberVO findMember(String _id) {

		MemberVO memInfo = null;

		try {

			conn = dataFactory.getConnection();
			String query = "select * from  t_member where id = ?";
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, _id);
			ResultSet rs = pstmt.executeQuery();
			rs.next();
			String id = rs.getString("id");
			String pwd = rs.getString("pwd");
			String name = rs.getString("name");
			String email = rs.getString("email");
			Date joinDate = rs.getDate("joinDate");
			memInfo = new MemberVO(id, pwd, name, email, joinDate);
			pstmt.close();
			conn.close();

		} catch (Exception e) {

			e.printStackTrace();

		}

		return memInfo;

	}

	// 회원 수정
	public void modMember(MemberVO memberVO) {

		String id = memberVO.getId();
		String pwd = memberVO.getPwd();
		String name = memberVO.getName();
		String email = memberVO.getEmail();

		try {

			conn = dataFactory.getConnection();
			String query = "update t_member set pwd = ?, name = ?, email = ? where id = ?";
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, pwd);
			pstmt.setString(2, name);
			pstmt.setString(3, email);
			pstmt.setString(4, id);
			pstmt.executeUpdate();	// SQL문 실행
			pstmt.close();
			conn.close();

		} catch (Exception e) {

			e.printStackTrace();

		}

	}

	// 회원 삭제
	public void delMember(String id) {

		try {

			conn = dataFactory.getConnection();
			String query = "delete from t_member where id = ?";
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, id);
			pstmt.executeUpdate();	// SQL문 실행

		} catch (Exception e) {

			e.printStackTrace();

		}

	}

}
