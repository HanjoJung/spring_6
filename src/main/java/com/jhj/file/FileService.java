package com.jhj.file;

import java.io.File;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;

@Service
public class FileService {

	@Inject
	private FileDAO fileDAO;

	public ModelAndView delete(int fnum, HttpSession session) throws Exception {
		ModelAndView mv = new ModelAndView();
		int result = fileDAO.delete(fnum);
		FileDTO fileDTO = fileDAO.select(fnum);
		String realPath = session.getServletContext().getRealPath("resources/notice");
		File file = new File(realPath, fileDTO.getFname());
		file.delete();
		mv.setViewName("common/result");
		mv.addObject("result", result);
		return mv;
	}

}
