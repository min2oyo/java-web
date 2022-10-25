package actionTag.bean;

import java.sql.Connection;
import java.sql.Date;
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

	public List<MemberDTO> listMembers() {

		List<MemberDTO> list = new ArrayList<MemberDTO>();

		try {

			con = dataFactory.getConnection();
			String query = "select * from t_member order by joinDate desc ";	// 회원 정보를 최근 가입일 순으로 조회
			System.out.println("prepareStatememt: " + query);
			pstmt = con.prepareStatement(query);
			ResultSet rs = pstmt.executeQuery();

			while (rs.next()) {

				String id = rs.getString("id");
				String pwd = rs.getString("pwd");
				String name = rs.getString("name");
				String email = rs.getString("email");
				Date joinDate = rs.getDate("joinDate");
				MemberDTO memberDTO = new MemberDTO();	// 조회한 회원 정보를 MemberDTO 객체의 속성에 저장한 후 다시 ArrayList에 저장
				memberDTO.setId(id);
				memberDTO.setPwd(pwd);
				memberDTO.setName(name);
				memberDTO.setEmail(email);
				memberDTO.setJoinDate(joinDate);
				list.add(memberDTO);

			}

			rs.close();
			pstmt.close();
			con.close();

		} catch (Exception e) {

			e.printStackTrace();

		}

		return list;

	}

	public void addMember(MemberDTO memberDTO) {	// MemberDAO 객체에 저장된 회원 정보를 전달

		try {

			Connection con = dataFactory.getConnection();
			String id = memberDTO.getId();	// getter를 이용해 회원 정보를 가져옴
			String pwd = memberDTO.getPwd();
			String name = memberDTO.getName();
			String email = memberDTO.getEmail();
			String query = "insert into t_member";	// 회원 정보 추가
			query += " (id,pwd,name,email)";
			query += " values(?,?,?,?)";
			System.out.println("prepareStatememt: " + query);
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, id);
			pstmt.setString(2, pwd);
			pstmt.setString(3, name);
			pstmt.setString(4, email);
			pstmt.executeUpdate();
			pstmt.close();

		} catch (Exception e) {

			e.printStackTrace();

		}

	}

}
