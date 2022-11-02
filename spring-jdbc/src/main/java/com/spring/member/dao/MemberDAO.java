package com.spring.member.dao;

import java.util.List;

import org.springframework.dao.DataAccessException;

import com.spring.member.vo.MemberVO;

public interface MemberDAO {

	// 회원 목록
	public List<?> selectAllMembers() throws DataAccessException;

	// 회원 추가
	public int addMember(MemberVO memberVO) throws DataAccessException;

}
