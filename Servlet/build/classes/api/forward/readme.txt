redirect
- HttpServletResponse 객체의 sendRedirect() 이용
- 웹 브라우저에 재요청
- sendRedirect("포워드할 서블릿 or JSP");

Refresh
- HttpServletResponse 객체의 addHeader() 이용
- 웹 브라우저에 재요청
- response.addHeader("Refresh", 경과시간(초); url=요청할 서블릿 or JSP");

location
- JS location 객체의 href 속성 이용
- JS에서 재요청
- location.href='요청할 서블릿 or JSP';

dispatch
- 일반적으로 포워딩 기능을 지칭
- 서블릿이 직정 요청
- RequestDispatcher 클래스의 forward() 이용
- RequestDispatcher dis = request.getRequestDispatcher("포워드할 서블릿 or JSP");
	dis.forward(request, response);