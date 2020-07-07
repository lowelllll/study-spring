package com.lowell.member.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.lowell.member.dto.Member;
import com.lowell.member.service.MemberService;

@Controller
public class MemberController {

	@Autowired
	MemberService service;
	
	@RequestMapping(value="/memJoin", method=RequestMethod.POST)
	public String memJoin(@ModelAttribute("mem") Member member) {
		
		service.memberRegister(member.getMemId(), member.getMemPw(), member.getMemMail(), 
				member.getMemPhone1(), member.getMemPhone2(), member.getMemPhone3());
		
		
		return "memJoinOk";
	}
	
	@RequestMapping(value="/memLogin", method=RequestMethod.POST)
	public ModelAndView memLogin(@RequestParam("memId") String memId, 
			@RequestParam(value="memPw", required=true) String memPw) {
		
		Member member = service.memberSearch(memId, memPw);
		
		ModelAndView modelAndView = new ModelAndView();
		
		try {
			modelAndView.addObject("memId", member.getMemId());
			modelAndView.addObject("memPw", member.getMemPw());
			modelAndView.setViewName("memLoginOk");
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return modelAndView;
	}
	
}