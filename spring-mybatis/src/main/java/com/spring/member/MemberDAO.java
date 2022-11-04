package com.spring.member;

import java.io.Reader;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class MemberDAO {

	public static SqlSessionFactory sqlMapper = null;

	private static SqlSessionFactory getInstance() {

		if (sqlMapper == null) {

			try {

				String resource = "mybatis/SqlMapConfig.xml";	// MemberDAO의 각 메서드 호출 시 src/mybatis/SqlMapConfin.xml에서 설정 정보를 읽은 후 데이터베이스와의 연동 준비를 함
				Reader reader = Resources.getResourceAsReader(resource);
				sqlMapper = new SqlSessionFactoryBuilder().build(reader);	// 마이바티스를 이용하는 sqlMapper 객체를 가져옴
				reader.close();

			} catch (Exception e) {

				e.printStackTrace();

			}

		}

		return sqlMapper;

	}

	// 회원 목록 | MemberVO
	public List<MemberVO> selectAllMemberList() {

		sqlMapper = getInstance();
		SqlSession session = sqlMapper.openSession();	// 실제 member.xml의 SQL문을 호출하는 데 사용되는 SqlSession 객체를 가져옴
		List<MemberVO> memlist = session.selectList("mapper.member.selectAllMemberList");	// 여러 개의 레코드를 조회하므로 selectList()에 실행하고자 하는 SQL문의 id를 인자로 전달

		return memlist;

	}

	// 회원 목록 | HashMap
	public List<HashMap<String, String>> selectAllMemberList2() {

		sqlMapper = getInstance();
		SqlSession session = sqlMapper.openSession();
		List<HashMap<String, String>> memlist = session.selectList("mapper.member.selectAllMemberList2");

		return memlist;

	}

	// 이름 조회
	public String selectName() {

		sqlMapper = getInstance();
		SqlSession session = sqlMapper.openSession();
		String name = session.selectOne("mapper.member.selectName");

		return name;

	}

	// 비밀번호 조회
	public int selectPwd() {

		sqlMapper = getInstance();
		SqlSession session = sqlMapper.openSession();
		int pwd = session.selectOne("mapper.member.selectPwd");

		return pwd;

	}

	// 아이디 검색
	public MemberVO selectMemberById(String id) {

		sqlMapper = getInstance();
		SqlSession session = sqlMapper.openSession();
		MemberVO memberVO = session.selectOne("mapper.member.selectMemberById", id);

		return memberVO;

	}

	// 비밀번호 검색
	public List<MemberVO> selectMemberByPwd(int pwd) {

		sqlMapper = getInstance();
		SqlSession session = sqlMapper.openSession();
		List<MemberVO> membersList = session.selectList("mapper.member.selectMemberByPwd", pwd);

		return membersList;

	}

	// 회원 추가 | memberVO
	public int insertMember(MemberVO memberVO) {

		sqlMapper = getInstance();
		SqlSession session = sqlMapper.openSession();
		int result = session.insert("mapper.member.insertMember", memberVO);	// 지정한 id에 SQL문에 memberVO 값을 전달하여 회원 정보를 테이블에 추가
		session.commit();	// 수동 커밋으로 반드시 commit()을 호출하여 영구 반영함

		return result;

	}

	// 회원 추가 | HashMap
	public int insertMember2(Map<String, String> memberMap) {

		sqlMapper = getInstance();
		SqlSession session = sqlMapper.openSession();
		int result = session.insert("mapper.member.insertMember2", memberMap);
		session.commit();

		return result;

	}
//ㅊ
//	public int updateMember(MemberVO memberVO) {
//
//		sqlMapper = getInstance();
//		SqlSession session = sqlMapper.openSession();
//		int result = session.update("mapper.member.updateMember", memberVO);
//		session.commit();
//		return result;
//
//	}
//
//	public int deleteMember(String id) {
//
//		sqlMapper = getInstance();
//		SqlSession session = sqlMapper.openSession();
//		int result = 0;
//		result = session.delete("mapper.member.deleteMember", id);
//		session.commit();
//		return result;
//
//	}
//
//	public List<MemberVO> searchMember(MemberVO memberVO) {
//
//		sqlMapper = getInstance();
//		SqlSession session = sqlMapper.openSession();
//		List list = session.selectList("mapper.member.searchMember", memberVO);
//		return list;
//
//	}
//
//	public List<MemberVO> foreachSelect(List nameList) {
//
//		sqlMapper = getInstance();
//		SqlSession session = sqlMapper.openSession();
//		List list = session.selectList("mapper.member.foreachSelect", nameList);
//		return list;
//
//	}
//
//	public int foreachInsert(List memList) {
//
//		sqlMapper = getInstance();
//		SqlSession session = sqlMapper.openSession();
//		int result = session.insert("mapper.member.foreachInsert", memList);
//		session.commit();
//		return result;
//
//	}
//
//	public List<MemberVO> selectLike(String name) {
//
//		sqlMapper = getInstance();
//		SqlSession session = sqlMapper.openSession();
//		List list = session.selectList("mapper.member.selectLike", name);
//		return list;
//
//	}
//
//	public String selectName() {
//
//		sqlMapper = getInstance();
//		SqlSession session = sqlMapper.openSession();
//		String name = session.selectOne("mapper.member.selectName");
//		return name;
//
//	}
//
//	public int selectPwd() {
//
//		sqlMapper = getInstance();
//		SqlSession session = sqlMapper.openSession();
//		int pwd = session.selectOne("mapper.member.selectPwd");
//		return pwd;
//
//	}

}
