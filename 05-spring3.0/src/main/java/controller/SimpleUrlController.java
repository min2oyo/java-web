package controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

public class SimpleUrlController implements Controller {	// 스프링에서 제공하는 Controller 인터페이스를 반드시 구현

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {

		return new ModelAndView("index");	// 작업을 마친 후 뷰 이름을 ModelAndView에 index.jsp로 설정하여 반환

	}

}
