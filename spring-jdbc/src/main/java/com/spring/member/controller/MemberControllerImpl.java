package com.spring.member.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.multiaction.MultiActionController;

import com.spring.member.service.MemberService;

public class MemberControllerImpl extends MultiActionController implements MemberController {

	private MemberService memberService;

	public void setMemberService(MemberService memberService) {	// 반드시 setter를 구현

		this.memberService = memberService;

	}

	@Override
	public ModelAndView listMembers(HttpServletRequest request, HttpServletResponse response) throws Exception {	// /member/listmembers.do로 요청시 호출

		String viewName = getViewName(request);
		List membersList = memberService.listMembers();
		ModelAndView mav = new ModelAndView(viewName);
		mav.addObject("membersList", membersList);	// addObject() 메서드를 이용해 조회한 회원 정보를 바인딩 함
		return mav;

	}

	private String getViewName(HttpServletRequest request) throws Exception {

		String contextPath = request.getContextPath();
		String uri = (String) request.getAttribute("javax.servlet.include.request_uri");

		if (uri == null || uri.trim().equals("")) {

			uri = request.getRequestURI();

		}

		int begin = 0;

		if (!((contextPath == null) || ("".equals(contextPath)))) {

			begin = contextPath.length();

		}

		int end;

		if (uri.indexOf(";") != -1) {

			end = uri.indexOf(";");

		} else if (uri.indexOf("?") != -1) {

			end = uri.indexOf("?");

		} else {

			end = uri.length();

		}

		String fileName = uri.substring(begin, end);

		if (fileName.indexOf(".") != -1) {

			fileName = fileName.substring(0, fileName.lastIndexOf("."));

		}

		if (fileName.lastIndexOf("/") != -1) {

			fileName = fileName.substring(fileName.lastIndexOf("/"), fileName.length());

		}

		return fileName;

	}

}