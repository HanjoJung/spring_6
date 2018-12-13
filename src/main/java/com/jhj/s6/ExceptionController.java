package com.jhj.s6;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

@ControllerAdvice
public class ExceptionController {
	
	@ExceptionHandler(NullPointerException.class)
	public ModelAndView ex1() {
		ModelAndView mv = new ModelAndView();
		
		return mv;
	}
}
