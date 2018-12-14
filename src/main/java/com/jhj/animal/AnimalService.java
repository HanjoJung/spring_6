package com.jhj.animal;

import java.io.File;
import java.util.List;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.jhj.util.FileSaver;
import com.jhj.util.Pager;

@Service
public class AnimalService {

	@Inject
	private AnimalDAO animalDAO;

	public ModelAndView list(Pager pager) throws Exception {
		ModelAndView mv = new ModelAndView();
		pager.makeRow();
		int totalCount = animalDAO.totalCount();
		pager.makePage(totalCount);
		List<AnimalDTO> ar = animalDAO.list(pager);
		mv.addObject("list", ar);
		mv.setViewName("ani/list");
		return mv;
	}

	public ModelAndView select(int num) throws Exception {
		ModelAndView mv = new ModelAndView();
		AnimalDTO animalDTO = animalDAO.select(num);
		mv.addObject("dto", animalDTO);
		mv.setViewName("ani/select");
		return mv;
	}

	public ModelAndView insert(AnimalDTO animalDTO, MultipartFile f1, HttpSession session) throws Exception {

		FileSaver fs = new FileSaver();
		String realPath = session.getServletContext().getRealPath("resources/ani");

		System.out.println(realPath);
		if (!f1.isEmpty()) {
			String name = fs.saveFile3(realPath, f1);
			animalDTO.setFname(name);
			animalDTO.setOname(f1.getOriginalFilename());
		}
		animalDTO.setId(animalDTO.getKind() + System.currentTimeMillis());
		System.out.println(animalDTO.getId());

		int result = animalDAO.insert(animalDTO);

		ModelAndView mv = new ModelAndView();
		if (result > 0) {
			mv.addObject("msg", "작성 성공");
		} else {
			mv.addObject("msg", "작성 실패");
		}
		mv.setViewName("redirect:./list");
		return mv;
	}

	public ModelAndView update(AnimalDTO animalDTO, MultipartFile f1, HttpSession session) throws Exception {
		FileSaver fs = new FileSaver();
		String realPath = session.getServletContext().getRealPath("resources/ani");

		System.out.println(realPath);
		if (!f1.isEmpty()) {
			String name = fs.saveFile3(realPath, f1);
			animalDTO.setFname(name);
		}
		animalDTO.setId(animalDTO.getKind() + System.currentTimeMillis());
		animalDTO.setOname(f1.getOriginalFilename());

		int result = animalDAO.update(animalDTO);

		ModelAndView mv = new ModelAndView();
		if (result > 0) {
			mv.addObject("msg", "수정 성공");
		} else {
			mv.addObject("msg", "수정 실패");
		}
		mv.setViewName("redirect:./select?num=" + animalDTO.getNum());
		return mv;
	}

	public ModelAndView delete(int num, HttpSession session) throws Exception {
		AnimalDTO animalDTO = animalDAO.select(num);
		int result = animalDAO.delete(num);

		if (animalDTO != null) {
			String realPath = session.getServletContext().getRealPath("resources/ani");
			File file = new File(realPath, animalDTO.getFname());
			file.delete();
		}

		ModelAndView mv = new ModelAndView();
		if (result > 0) {
			mv.addObject("msg", "삭제 성공");
		} else {
			mv.addObject("msg", "삭제 실패");
		}
		mv.setViewName("redirect:./list");
		return mv;
	}
}
