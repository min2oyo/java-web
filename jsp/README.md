# Start
## 일반
- URL
	- http://localhost:8080/jsp/views/hello.jsp
- webapp.views.jsp
	- hello.jsp

# JSP 구성요소
## 디렉티브 태그
### 페이지 디렉티브 태그
- URL
	- http://localhost:8080/jsp/views/directive/page/hello.jsp
- webapp.views.directive.page
	- hello.jsp
		
### 인클루드 디렉티브 태그
- URL
	- http://localhost:8080/jsp/views/directive/include/include.jsp
- webapp.views.directive.include
	- include.jsp
	- duke_image.jsp
- webapp.views.images
	- duke.png

## 스크립트 요소
### 선언문, 스크립트릿, 표현식, 주석문
- URL
	- http://localhost:8080/jsp/views/scripting/hello.jsp?age=22
- webapp.views.scripting
	- hello.jsp

### 실습
#### 로그인
- URL
	- http://localhost:8080/jsp/views/scripting/apps/login/login.jsp
- webapp.views.scripting.apps.login
	- login.jsp
	- result.jsp
	
#### 학점 계산
- URL
	- http://localhost:8080/jsp/views/scripting/apps/score/score.jsp?score=-1
- webapp.views.scripting.apps.score
	- score.jsp
	
#### 구구단
- URL
	- http://localhost:8080/jsp/views/scripting/apps/multiplication-table/multiplication-table.jsp
- webapp.views.scripting.apps.multiplication-table
	- multiplication-table.jsp
	- result.jsp
- 작업
	- 파일 하나로 합치기
	- CSS 정리
	
#### 이미지 리스트
- URL
	- http://localhost:8080/jsp/views/scripting/apps/image-list/image-list.jsp
- webapp.views.scripting.apps.image-list
	- image-list.jsp
- 작업
	- 반응형 만들기

## 내장 객체(내장 변수, built in object(?))
### session
- URL
	- http://localhost:8080/jsp/session
- java.session
	- Session.java
- webapp.views.built-in-object.session
	- session1.jsp
	- session2.jsp

### application
- URL
	- http://localhost:8080/jsp/views/built-in-object/application/application1.jsp
- webapp.views.built-in-object.application
	- application1.jsp
	- application2.jsp
	
### request
- URL
	- http://localhost:8080/jsp/views/built-in-object/request/request1.jsp
- webapp.views.built-in-object.request
	- request1.jsp
	- request2.jsp
	
### out
- URL
	- http://localhost:8080/jsp/views/built-in-object/out/out1.jsp
- webapp.views.built-in-object.out
	- out1.jsp
	- out2.jsp
		
## 예외 처리(exception)
###	page
- URL
	- http://localhost:8080/jsp/views/exception/page/add.html
- webapp.views.exception.page
	- add.html
	- add.jsp
	- addException.jsp

###	xml
- URL
	- http://localhost:8080/jsp/views/exception/xml/num.jsp 		// 404
	- http://localhost:8080/jsp/views/exception/xml/number.jsp	// 500
- webapp.views.exception.xml
	- number.jsp
	- error_404.jsp
	- error_500.jsp
- webapp.WEB-INF
	- web.xml
	
## 시작 화면
- URL
	- http://localhost:8080/jsp/
- webapp.views.welcome
	- main.jsp
- webapp.WEB-INF
	- web.xml

## 검색
- URL
	- 
- java.member
	- memberVO.java
	- memberDAO.java
- webapp.views.
	- member.jsp
	- search.jsp
	- jsp.search
- webapp.WEB-IFN.lib
	- ojdbc11.jar
		
# 액션 태그
## 개념
- include
	- webapp.views.actionTag.concept.include
		- include1.jsp
		- include2.jsp
		- duke_image.jsp
	- webapp.views.image
		- duke.png
		- duke2.png
	
- forward
	- webapp.views.actionTag.concept.forward
		- login.jsp
		- result.jsp

## 실습: 회원정보 조회
- javaBean (DB)
	- webapp.views.actionTag.program.javaBean
		- memberFrom.html
		- member.jsp
	- java.actionTag.bean
		- MemberDTO.java
		- MemberDAO.java

- useBean (DB)
	- webapp.views.actionTag.program.useBean
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