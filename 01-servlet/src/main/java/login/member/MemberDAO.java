package login.member;

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

			Context ctx = new InitialContext();	// JNDI에 접근하기 위해 기본 경로(java:/comp/env)를 지정
			Context envContext = (Context) ctx.lookup("java:/comp/env");
			dataFactory = (DataSource) envContext.lookup("jdbc/oracle");	// 톰캣 context.xml에 설정한 name값인 jdbc/oracle을 이용해 톰캣이 미리 연결한 DataSource를 받아 옴

		} catch (Exception e) {

			e.printStackTrace();

		}

	}

	// 회원 목록
	public List<MemberVO> listMembers() {

		List<MemberVO> list = new ArrayList<MemberVO>();

		try {

			// DB연결
			con = dataFactory.getConnection();	// DataSource를 이용해 DB에 연결

			pstmt = con.prepareStatement("select * from t_member");	// SQL문을 전달해서 PreparedStatement 객체를 생성
			ResultSet rs = pstmt.executeQuery();	// executeQuery()를 호출해 미리 설정한 SQL문을 실행

			// 저장
			while (rs.next()) {

				MemberVO memberVO = new MemberVO();	// 조회한 레코드의 각 컬럼을 받아와서 MemberVO 객체에 저장

				memberVO.setId(rs.getString("id"));
				memberVO.setPwd(rs.getString("pwd"));
				memberVO.setName(rs.getString("name"));
				memberVO.setEmail(rs.getString("email"));
				memberVO.setJoinDate(rs.getDate("joinDate"));

				list.add(memberVO);	// ArrayList에 옮겨서 저장

			}

			rs.close();
			pstmt.close();
			con.close();

		} catch (Exception e) {

			e.printStackTrace();

		}

		return list;

	}

	// 회원 추가
	public void addMember(MemberVO memberVO) {

		try {

			con = dataFactory.getConnection();	// DataSource를 이용해 DB에 연결

			pstmt = con.prepareStatement("insert into t_member (id, pwd, name, email) values(?, ?, ?, ?)");
			pstmt.setString(1, memberVO.getId());	// 테이블에 저장할 회원 정보를 가져와서 insert문의 각 '?'에 순서대로 회원 정보를 세팅
			pstmt.setString(2, memberVO.getPwd());
			pstmt.setString(3, memberVO.getName());
			pstmt.setString(4, memberVO.getEmail());
			pstmt.executeUpdate();
			pstmt.close();	// 회원 정보 테이블에 추가

		} catch (Exception e) {

			e.printStackTrace();

		}

	}

	// 회원 확인
	public boolean isExisted(MemberVO memberVO) {

		boolean result = false;
		String id = memberVO.getId();
		String pwd = memberVO.getPwd();

		try {

			con = dataFactory.getConnection();

			String query = "select decode(count(*), 1, 'true', 'false') as result from t_member where id=? and pwd=?";	// 오라클의 decode()로 ID와 비밀번호가 테이블에 존재하는지 확인
			pstmt = con.prepareStatement(query);	// 메서드로 전달된 ID와 비밀번호를 이용해 SQL문에 작성한 후 DB에 조회
			pstmt.setString(1, id);
			pstmt.setString(2, pwd);
			ResultSet rs = pstmt.executeQuery();
			rs.next();	// 커서를 첫 번째 레코드로 위치

			result = Boolean.parseBoolean(rs.getString("result"));
			System.out.println("result: " + result);

		} catch (Exception e) {

			e.printStackTrace();

		}

		return result;

	}

	// 회원 삭제
	public void delMember(String id) {

		try {

			con = dataFactory.getConnection();

			pstmt = con.prepareStatement("delete from t_member" + " where id=?");
			pstmt.setString(1, id);
			pstmt.executeUpdate();
			pstmt.close();

		} catch (Exception e) {

			e.printStackTrace();

		}

	}

}
