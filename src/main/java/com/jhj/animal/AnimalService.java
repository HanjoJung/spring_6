package com.jhj.animal;

import java.util.List;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.jhj.util.FileSaver;

@Service
public class AnimalService {

	@Inject
	private AnimalDAO animalDAO;

	public ModelAndView list() throws Exception {
		ModelAndView mv = new ModelAndView();
		List<AnimalDTO> ar = animalDAO.list();
		mv.addObject("list", ar);
		mv.setViewName("ani/list");
		return mv;
	}

	public ModelAndView select() throws Exception {
		ModelAndView mv = new ModelAndView();
		return mv;
	}

	public ModelAndView insert(AnimalDTO animalDTO, MultipartFile f1, HttpSession session) throws Exception {
		
		FileSaver fs = new FileSaver();
		String realPath = session.getServletContext().getRealPath("resources/animal");

		System.out.println(realPath);
		if (!f1.isEmpty()) {
			String name = fs.saveFile3(realPath, f1);
			animalDTO.setFname(name);
		}
		animalDTO.setId(animalDTO.getKind()+System.currentTimeMillis());
		animalDTO.setOname(f1.getOriginalFilename());
		System.out.println(animalDTO.getId());

		int result = animalDAO.insert(animalDTO);

		ModelAndView mv = new ModelAndView();
		if(result > 0) {
			mv.addObject("msg", "작성 성공");
		}else {
			mv.addObject("msg", "작성 실패");
		}
		mv.setViewName("redirect:./list");
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
