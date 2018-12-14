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
import com.jhj.util.Pager;

@Controller
@RequestMapping(value = "/ani/**")
public class AnimalController {
	@Inject
	private AnimalService animalService;

	@RequestMapping(value = "list")
	public ModelAndView list(Pager pager) throws Exception {
		ModelAndView mv = animalService.list(pager);
		return mv;
	}

	@RequestMapping(value = "select")
	public ModelAndView select(int num) throws Exception {
		ModelAndView mv = animalService.select(num);
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

	@RequestMapping(value = "update")
	public ModelAndView update(int num) throws Exception {
		ModelAndView mv = animalService.select(num);
		mv.setViewName("ani/update");
		return mv;
	}

	@RequestMapping(value = "update", method = RequestMethod.POST)
	public ModelAndView update(AnimalDTO animalDTO, MultipartFile f1, HttpSession session) throws Exception {
		ModelAndView mv = animalService.update(animalDTO, f1, session);
		return mv;
	}

	@RequestMapping(value = "delete")
	public ModelAndView delete(int num, HttpSession session) throws Exception {
		ModelAndView mv = animalService.delete(num, session);
		return mv;
	}

}
