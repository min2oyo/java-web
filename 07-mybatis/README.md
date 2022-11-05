# 회원 관리
- URL
	- http://localhost:8080/spring-mybatis/member	// 회원 목록
	- http://localhost:8080/spring-mybatis/views/search.jsp	// 하드 검색
	- http://localhost:8080/spring-mybatis/views/memberForm.jsp // 회원가입
	- http://localhost:8080/spring-mybatis/views/searchMember.jsp	// 회원 검색
	- http://localhost:8080/spring-mybatis/member?action=foreachSelect	// 회원 정보 조회 (foreach)
	- http://localhost:8080/spring-mybatis/member?action=foreachInsert	// 회원 다중 추가 (1회성)
	- http://localhost:8080/spring-mybatis/member?action=selectLike			// like 검색
- java.com.spring.member
	- MemberServlet.java
	- MemberDAO.java
	- MemberVO.java
- java.com.spring.mybatis.mappers
	- member.xml
- java.com.spring.mybatis
	- SqlMapConfig.xml
- webapp.views
	- listMembers.jsp
	- memberInfo.jsp
	- search.jsp
	- ...
- 작업
	- jsp 파일들 잘 통합 시켜보기