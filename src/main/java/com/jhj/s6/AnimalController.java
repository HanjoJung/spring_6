package com.jhj.s6;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.jhj.animal.AnimalDTO;
import com.jhj.animal.AnimalService;

@Controller
@RequestMapping(value="/ani/**")
public class AnimalController {
	@Inject
	private AnimalService animalService;

	@RequestMapping(value = "list")
	public List<AnimalDTO> list() throws Exception {
		return null;
	}
	public AnimalDTO select() throws Exception {
		return null;
	}
	public int write() throws Exception {
		return 0;
	}
	public int update() throws Exception {
		return 0;
	}
	public int delete() throws Exception {
		return 0;
	}	

}
