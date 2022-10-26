package member;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class MemberDAO {

	private Connection con;
	private PreparedStatement pstmt;
	private DataSource dataFactory;

	public MemberDAO() {

		try {

			Context ctx = new InitialContext();
			Context envContext = (Context) ctx.lookup("java:/comp/env");
			dataFactory = (DataSource) envContext.lookup("jdbc/oracle");

		} catch (Exception e) {

			e.printStackTrace();

		}

	}

	// 회원 목록
	public List<MemberVO> listMembers() {

		List<MemberVO> list = new ArrayList<MemberVO>();

		try {

			con = dataFactory.getConnection();
			String query = "select * from t_member order by joinDate desc ";	// 최근 가입일 순으로 회원 조회
			pstmt = con.prepareStatement(query);
			ResultSet rs = pstmt.executeQuery();

			while (rs.next()) {

				MemberVO memberVO = new MemberVO();

				memberVO.setId(rs.getString("id"));
				memberVO.setPwd(rs.getString("pwd"));
				memberVO.setName(rs.getString("name"));
				memberVO.setEmail(rs.getString("email"));
				memberVO.setJoinDate(rs.getDate("joinDate"));

				list.add(memberVO);

			}

			rs.close();
			pstmt.close();
			con.close();

		} catch (Exception e) {

			e.printStackTrace();

		}

		return list;

	}

	// 회원 조회
	public List<MemberVO> listMembers(MemberVO memberVO) {

		List<MemberVO> membersList = new ArrayList<MemberVO>();
		String searchName = memberVO.getName();	// 조회할 이름을 가져옴

		try {

			con = dataFactory.getConnection();
			String query = "select * from t_member ";

			if ((searchName != null && searchName.length() != 0)) {	// 값이 존재하면 SQL문에 where절을 추가하여 해당 이름으로 조회

				query += "where name like ?";
				pstmt = con.prepareStatement(query);
				pstmt.setString(1, "%" + searchName + "%");	// 첫 번째 '?'에 전달된 이름을 지정

			} else {	// 값이 없으면 모든 회원 정보 조회

				pstmt = con.prepareStatement(query);

			}

			ResultSet rs = pstmt.executeQuery();

			while (rs.next()) {

				MemberVO vo = new MemberVO();

				vo.setId(rs.getString("id"));
				vo.setPwd(rs.getString("pwd"));
				vo.setName(rs.getString("name"));
				vo.setEmail(rs.getString("email"));
				vo.setJoinDate(rs.getDate("joinDate"));

				membersList.add(vo);

			}

			rs.close();
			pstmt.close();
			con.close();

		} catch (Exception e) {

			e.printStackTrace();

		}

		return membersList;

	}

	// 회원가입
	public void addMember(MemberVO memberVO) {

		try {

			con = dataFactory.getConnection();
			String query = "insert into t_member (id, pwd, name, email) values (?, ?, ?, ?)";
			pstmt = con.prepareStatement(query);

			pstmt.setString(1, memberVO.getId());
			pstmt.setString(2, memberVO.getPwd());
			pstmt.setString(3, memberVO.getName());
			pstmt.setString(4, memberVO.getEmail());

			pstmt.executeUpdate();
			pstmt.close();

		} catch (Exception e) {

			e.printStackTrace();

		}

	}

}
