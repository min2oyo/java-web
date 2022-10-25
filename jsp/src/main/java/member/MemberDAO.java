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

}
