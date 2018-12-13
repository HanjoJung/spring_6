package com.jhj.s6;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.jhj.animal.AnimalDTO;
import com.jhj.animal.AnimalService;

@Controller
@RequestMapping(value = "/ani/**")
public class AnimalController {
	@Inject
	private AnimalService animalService;

	@RequestMapping(value = "list")
	public ModelAndView list() throws Exception {
		ModelAndView mv = animalService.list();
		return mv;
	}

	public ModelAndView select() throws Exception {
		ModelAndView mv = new ModelAndView();
		return mv;
	}

	@RequestMapping(value = "write")
	public void insert() throws Exception {
	}

	@RequestMapping(value = "write", method = RequestMethod.POST)
	public ModelAndView insert(AnimalDTO animalDTO, MultipartFile f1, HttpSession session) throws Exception {
		ModelAndView mv = animalService.insert(animalDTO, f1, session);
		return mv;
	}

	public ModelAndView update() throws Exception {
		ModelAndView mv = new ModelAndView();
		return mv;
	}

	public ModelAndView delete() throws Exception {
		ModelAndView mv = new ModelAndView();
		return mv;
	}

}
