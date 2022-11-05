package com.spring.ex01;	// 애너테이션이 적용되도록 하려면 해당 클래스가 반드시 <component-scan>에서 설정한 패키지나 하위 패키지에 존재해야 함

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller("mainController")	// MainController 클래스를 빈으로 자동 변환함. 빈 id는 mainController임
@RequestMapping("/test")	// 첫 번째 단계의 URL 요청이 /test이면 mainController 빈을 요청함
public class MainController {

	@RequestMapping(value = "/main1.do", method = RequestMethod.GET)	// 두 번쨰 단계의 URL 요청이 /main1.do이면 mainController 빈의 main1()에게 요청함. GET 방식으로 요청 시 해당 메서드가 호출
	public ModelAndView main1(HttpServletRequest request, HttpServletResponse response) throws Exception {

		ModelAndView mav = new ModelAndView();
		mav.addObject("msg", "main1");
		mav.setViewName("main");
		return mav;

	}

	@RequestMapping(value = "/main2.do", method = RequestMethod.GET)
	public ModelAndView main2(HttpServletRequest request, HttpServletResponse response) throws Exception {

		ModelAndView mav = new ModelAndView();
		mav.addObject("msg", "main2");
		mav.setViewName("main");
		return mav;

	}

}
