package com.spring.member;

import java.io.Reader;
import java.util.HashMap;
import java.util.List;

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

	public List<MemberVO> selectAllMemberList() {

		sqlMapper = getInstance();
		SqlSession session = sqlMapper.openSession();	// 실제 member.xml의 SQL문을 호출하는 데 사용되는 SqlSession 객체를 가져옴
		List<MemberVO> memlist = session.selectList("mapper.member.selectAllMemberList");	// 여러 개의 레코드를 조회하므로 selectList()에 실행하고자 하는 SQL문의 id를 인자로 전달

		return memlist;

	}

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

}
