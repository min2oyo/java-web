ServletConfig
- Servlet 객체에 대해 생성
- ServletConfig 인터페이스를 GenericServlet 클래스가 실제로 구현
- ServletContext 객체를 가져오는 것이 대표적인 기능
- ServletConfig는 javax.servlet 패키지에 인터페이스로 선언
- 각 서블릿에서만 접근할 수 있으며 공유 불가
- 서블릿과 동일하게 생성되고 소멸됨

기능
- ServletContext 객체를 얻음
- 서블릿에 대한 초기화가 작업

초기화
- '@WebServlet 애너테이션' 사용
- 'web.xml' 사용

!menu_member -> menuMember로 실험 