package com.jhj.s6;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.jhj.file.FileService;
import com.jhj.file.PhotoDTO;

@Controller
@RequestMapping(value = "/file/**")
public class FileController {

	@Inject
	private FileService fileService;

	@RequestMapping(value = "delete")
	public ModelAndView delete(int fnum, HttpSession session) throws Exception {
		return fileService.delete(fnum, session);
	}

	@RequestMapping(value = "photoUpload", method = RequestMethod.POST)
	public String se2(PhotoDTO photoDTO, HttpSession session) throws Exception {
		return fileService.se2(photoDTO, session);
	}
}
