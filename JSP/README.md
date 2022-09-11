# JSP
## theory(이론)
### JSP 변환
- jsp
	- hello.jsp
		
### 디렉티브 태그
- directive
	- hello.jsp
		
### 인클루드 디렉티브 태그
- hello
	- include.jsp
	- duke_image.jsp
- image
	- duke.png
	
### 선언문, 스크립트릿, 표현식
- hello
	- hello3.jsp

## apps(프로그램)
### 로그인
- login
	- login.html
	- result.jsp
	
### 학점 변환
- score
	- score.html
	- score.jsp
	
### 구구단
- gugudan
	- gugudan.html
	- gugudan.jsp
	
### 이미지 리스트
- imageList
	- imageList.jsp

## builtInObject(내장 객체)
###	session (같은 브라우저만 공유)
- Session.java	| http://localhost:8080/JSP/session
- session1.jsp
- session2.jsp

###	application (모든 브라우저에 공유)
- application1.jsp
- application2.jsp
	
###	request (dispatch)
- request1.jsp
- request2.jsp
	
###	out
- out1.jsp
- out2.jsp
		
## exception(예외 처리)
###	add (errorPage, isErrorPage) - 1순위
- add.html
- add.jsp
- addException.jsp

###	error (xml)	- 차순위
- http://localhost:8080/JSP/views/JSP/exception/error/num.jsp
- http://localhost:8080/JSP/views/JSP/exception/error/number.jsp
- number.jsp
- error_404.jsp
- error_500.jsp
- /WEB-INF/web.xml
	
## welcome(메인화면)
- http://localhost:8080/JSP/
- main.jsp
- web.xml

## search(스크립트 요소)
- search.jsp
- member.jsp
- jsp.search
	- memberVO.java
	- memberDAO.java
	- /WEB-IFN/lib/ojdbc11.jar
		
# 액션 태그
## 개념
- include
	- views.actionTag.concept.include
		- include1.jsp
		- include2.jsp
		- duke_image.jsp
	- views.image
		- duke.png
		- duke2.png
	
- forward
	- views.actionTag.concept.forward
		- login.jsp
		- result.jsp

## 실습: 회원정보 조회
- javaBean (DB)
	- views.actionTag.program.javaBean
		- memberFrom.html
		- member.jsp
	- java.actionTag.bean
		- MemberDTO.java
		- MemberDAO.java

- useBean (DB)
	- views.actionTag.program.useBean
		- memberFrom.html
		- member.jsp
	- java.actionTag.bean
		- MemberDTO.java
		- MemberDAO.java











구성요소
	• 디렉티브 태그(Directive Tag)
		○ 페이지 디렉티브 태그(Page Directive Tag)
		○ 인클루드 디렉티브 태그(Include Directive Tag)
		○ 태그라이브 디렉티브 태그(Taglib Directive Tag)
	• 스크립트 요소(Scripting Element)
		○ 주석문
		○ 스크립트릿(Scriptlet): 자바 코드 작성
		○ 표현식: 변수값 출력
		○ 선언식(선언문?): 변수, 메서드 선언
	• 표현 언어(Expression Language)
	• 내장 객체(내장 변수)
	• 액션 태그(Action Tag)
	• 커스텀 태그(Custom Tag)

톰캣 컨테이너에서 JSP 변환과정
(523)