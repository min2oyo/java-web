package controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.multiaction.MultiActionController;

public class UserController extends MultiActionController {	// 설정 파일의 userMethodNameResolver 프로퍼티를 사용하려면 반드시 MultiactionController를 상속받아야 함

//	// 로그인
//	public ModelAndView login(HttpServletRequest request, HttpServletResponse response) throws Exception {
//
//		request.setCharacterEncoding("utf-8");
//
//		ModelAndView mav = new ModelAndView();
//		mav.addObject("userID", request.getParameter("userID"));	// ModelAndView에 로그인 정보를 바인딩 함
//		mav.addObject("passwd", request.getParameter("passwd"));
//		mav.setViewName("result");				// ModelAndView 객체에 포워딩할 JSP 이름을 설정함
//
//		return mav;
//
//	}

	// 로그인 (URL 요청명 사용)
	public ModelAndView login(HttpServletRequest request, HttpServletResponse response) throws Exception {

		request.setCharacterEncoding("utf-8");

		ModelAndView mav = new ModelAndView();
		mav.addObject("userID", request.getParameter("userID"));
		mav.addObject("passwd", request.getParameter("passwd"));
		mav.setViewName(getViewName(request));	// getViewName()를 호출해 요청명에서 확장명 .do를 제외한 뷰 이름을 가져옴. 뷰 이름 지정
		System.out.println("ViewName: " + getViewName(request));

		return mav;

	}

	// 회원 정보
	public ModelAndView memberInfo(HttpServletRequest request, HttpServletResponse response) throws Exception {

		request.setCharacterEncoding("utf-8");

		ModelAndView mav = new ModelAndView();
		mav.addObject("id", request.getParameter("id"));	// 회원가입창에서 전송된 회원 정보를 addObject()을 이용해 ModelAndView 객체에 바인딩 함
		mav.addObject("pwd", request.getParameter("pwd"));
		mav.addObject("name", request.getParameter("name"));
		mav.addObject("email", request.getParameter("email"));
		mav.setViewName("memberInfo");	// memberInfo.jsp로 포워딩 함

		return mav;

	}

	// URL 요청명(?)
	private String getViewName(HttpServletRequest request) throws Exception {	// request 객체에서 URL 요청명을 가져와 .do를 제외한 요청명을 구함

		String contextPath = request.getContextPath();
		String uri = (String) request.getAttribute("javax.servlet.include.request_uri");

		if (uri == null || uri.trim().equals("")) {

			uri = request.getRequestURI();

		}

		// http://localhost:8090/member/listMember.do로 요청시
		int begin = 0;  //

		if (!((contextPath == null) || ("".equals(contextPath)))) {

			begin = contextPath.length();  // 전체 요청명 의 길이를 구함

		}

		int end;

		if (uri.indexOf(";") != -1) {

			end = uri.indexOf(";");  // 요청 uri에 ';'가 있을 경우 ';'문자 위치를 구함

		} else if (uri.indexOf("?") != -1) {

			end = uri.indexOf("?");   // 요청 uri에 '?'가 있을 경우 '?' 문자 위치를 구함

		} else {

			end = uri.length();

		}

		// http://localhost:8090/member/listMember.do로 요청시 먼저 '.do'를 제거한 http://localhost:8090/member/listMember를 구한 후,
		// 다시 http://localhost:8090/member/listMember에서 역순으로 첫번째 '/' 위치를 구한 후, 그 뒤의 listMember를 구한다.
		String fileName = uri.substring(begin, end);

		if (fileName.indexOf(".") != -1) {

			fileName = fileName.substring(0, fileName.lastIndexOf("."));  // 요청명에서 역순으로 최초 '.'의 위치를 구한후, '.do' 앞에까지의 문자열을 구함

		}

		if (fileName.lastIndexOf("/") != -1) {

			fileName = fileName.substring(fileName.lastIndexOf("/"), fileName.length()); // 요청명에서 역순으로 최초 '/'의 위치를 구한후, '/' 다음부터의 문자열을 구함

		}

		return fileName;

	}

}
