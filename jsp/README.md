# 일반
- URL
	- http://localhost:8080/jsp/views/hello.jsp
- webapp.views.jsp
	- hello.jsp

# 스크립트릿
- 작업
	- 상위 폴더 scriptlet로 주소 바꾸기
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
	- http://localhost:8080/jsp/views/scriptlet/scripting/apps/login/login.jsp
- webapp.views.scripting.apps.login
	- login.jsp
	- result.jsp
	
#### 학점 계산
- URL
	- http://localhost:8080/jsp/views/scriptlet/scripting/apps/score/score.jsp?score=-1
- webapp.views.scripting.apps.score
	- score.jsp
	
#### 구구단
- URL
	- http://localhost:8080/jsp/views/scriptlet/scripting/apps/multiplication-table/multiplication-table.jsp
- webapp.views.scripting.apps.multiplication-table
	- multiplication-table.jsp
	- result.jsp
- 작업
	- 파일 하나로 합치기
	- CSS 정리
	
#### 이미지 리스트
- URL
	- http://localhost:8080/jsp/views/scriptlet/scripting/apps/image-list/image-list.jsp
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
		
## 예외 처리
### page
- URL
	- http://localhost:8080/jsp/views/exception/page/add.html
- webapp.views.exception.page
	- add.html
	- add.jsp
	- addException.jsp

### xml
- URL
	- http://localhost:8080/jsp/views/exception/xml/num.jsp 		// 404
	- http://localhost:8080/jsp/views/exception/xml/number.jsp	// 500
- webapp.views.exception.xml
	- number.jsp
	- error_404.jsp
	- error_500.jsp
- webapp.WEB-INF
	- web.xml

## 시작 페이지
- URL
	- http://localhost:8080/jsp/
- webapp.views.welcome
	- main.jsp
- webapp.WEB-INF
	- web.xml

## 검색
- URL
	- http://localhost:8080/jsp/views/search/member.jsp
- java.member
	- memberVO.java
	- memberDAO.java
- webapp.views.search
	- member.jsp
- webapp.WEB-IFN.lib
	- ojdbc11.jar
	- tomcat-dbcp-7.0.30.jar
- Servers.Tomcat v9.0 Server at localhost-config
	- context.xml

# 액션 태그
## 인클루드 액션 태그
- URL
	- http://localhost:8080/jsp/views/action-tag/include/include.jsp
- webapp.views.action-tag.include
	- include.jsp
	- duke_image.jsp
- webapp.views.images
	- duke.png
	- duke2.png
	
## 포워드 액션 태그
- URL
	- http://localhost:8080/jsp/views/action-tag/forward/login.jsp
- webapp.views.action-tag.forward
	- login.jsp
	- result.jsp

## 자바 빈
- URL
	- http://localhost:8080/jsp/views/action-tag/java-bean/member.jsp
- java.member
	- MemberVO.java
	- MemberDAO.java
- webapp.views.action-tag.java-bean
	- member.jsp
	- memberFrom.jsp
- webapp.WEB-IFN.lib
	- ojdbc11.jar
	- tomcat-dbcp-7.0.30.jar
- Servers.Tomcat v9.0 Server at localhost-config
	- context.xml
- 작업
	- 'memberForm.jsp' 최신 문법으로 수정
	- 회원가입 할 때 '아이디 중복검사' 추가
	- '회원 목록' 테이블 너비 조정
	- 'MemberDAO.java' 회원 목록, 회원 조회 합쳐보기

## 유즈 빈
- URL
	- http://localhost:8080/jsp/views/action-tag/use-bean/member.jsp
- java.member
	- MemberVO.java
	- MemberDAO.java
- webapp.views.action-tag.use-bean
	- member.jsp
	- memberFrom.jsp
- webapp.WEB-IFN.lib
	- ojdbc11.jar
	- tomcat-dbcp-7.0.30.jar
- Servers.Tomcat v9.0 Server at localhost-config
	- context.xml

# 표현 언어
## 연산자
- URL
	- http://localhost:8080/jsp/views/expression-language/operator/operator.jsp
- webapp.views.expression-language.operator
	- operator.jsp

## 내장 객체
- URL
	- http://localhost:8080/jsp/views/expression-language/built-in-object/sign-up.jsp
- java.member
	- MemberVO.java
	- Address.jsva
- webapp.views.expression-language.built-in-object
	- sign-up.jsp
	- forward.jsp
	- member.jsp

## 바인딩
- URL
	- http://localhost:8080/jsp/views/expression-language/binding/forward.jsp
- webapp.views.expression-language.binding
	- forward.jsp
	- member.jsp

# JSTL
## Core 태그
- URL
	- http://localhost:8080/jsp/views/jstl/core/member.jsp
	- http://localhost:8080/jsp/views/jstl/core/login.jsp
	- http://localhost:8080/jsp/views/jstl/core/url.jsp
	- http://localhost:8080/jsp/views/jstl/core/redirect.jsp
	- http://localhost:8080/jsp/views/jstl/core/sign-up.jsp
	- http://localhost:8080/jsp/views/jstl/core/escapeXml.jsp
- java.member
	- MemberVO.java
- webapp.views.jstl.core
	- member.jsp
	- login.jsp
	- url.jsp
	- redirect.jsp
	- sign-up.jsp
	- escapeXml.jsp
- 작업
	- member.jsp에 login.jsp 링트 걸기

### 실습
#### 로그인
- URL
	- http://localhost:8080/jsp/views/jstl/core/apps/login/login.jsp
- webapp.views.jstl.core.apps.login
	- login.jsp
	- result.jsp
	
#### 학점 계산
- URL
	- http://localhost:8080/jsp/views/jstl/core/apps/score/score.jsp
- webapp.views.jstl.core.apps.score
	- score.jsp
	
#### 구구단
- URL
	- http://localhost:8080/jsp/views/jstl/core/apps/multiplication-table/multiplication-table.jsp
- webapp.views.jstl.core.apps.multiplication-table
	- multiplication-table.jsp
	- result.jsp
- 작업
	- 파일 하나로 합치기
	- CSS 정리
#### 이미지 리스트
- URL
	- http://localhost:8080/jsp/views/jstl/core/apps/image-list/image-list.jsp
- webapp.views.jstl.core.apps.image-list
	- image-list.jsp
- 작업
	- 반응형 만들기









