servletContext 특징
- javax.servlet.ServletContext로 정의
- 서블릿과 컨테이너 간의 연동을 위해 사용
- 컨텍스트(웹 애플리케이션)마다 하나의 ServletContext가 생성
- 서블릿끼리 자원(데이터)을 공유하는데 사용
- 컨테이너 실행시 생성되고 컨테이너 종료 시 소멸

servletContext 기능
- 서블릿에서 파일 접근 기능
- 자원 바인딩 기능
- 로그 파일 기능
- 컨텍스트에서 제공하는 설정 정보 제공 기능

!개념 다시 읽어보기