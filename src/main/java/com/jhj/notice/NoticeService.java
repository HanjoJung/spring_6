package com.jhj.notice;

import java.io.File;
import java.util.Iterator;
import java.util.List;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.jhj.board.BoardDTO;
import com.jhj.file.FileDAO;
import com.jhj.file.FileDTO;
import com.jhj.util.FileSaver;
import com.jhj.util.Pager;

@Service
public class NoticeService {
	@Inject
	private NoticeDAO noticeDAO;
	@Inject
	private FileDAO fileDAO;

	public ModelAndView list(Pager pager) throws Exception {
		pager.makeRow();
		int totalCount = noticeDAO.totalCount(pager);
		pager.makePage(totalCount);
		ModelAndView mv = new ModelAndView();
		mv.setViewName("board/boardList");
		mv.addObject("list", noticeDAO.list(pager));
		mv.addObject("pager", pager);
		return mv;
	}

	public ModelAndView select(int num) throws Exception {
		ModelAndView mv = new ModelAndView();
		BoardDTO boardDTO = noticeDAO.select(num);

		if (boardDTO != null) {
			FileDTO fileDTO = new FileDTO();
			fileDTO.setNum(num);
			fileDTO.setKind("n");
			List<FileDTO> ar = fileDAO.list(fileDTO);
			mv.addObject("dto", boardDTO);
			mv.addObject("files", ar);
			mv.setViewName("board/boardSelect");
		} else {
			mv.addObject("msg", "해당 글은 없습니다.");
			mv.setViewName("redirect:./noticeList");
		}

		mv.addObject("board", "notice");
		return mv;
	}

	public ModelAndView insert(BoardDTO boardDTO, List<MultipartFile> f1, HttpSession session) throws Exception {
		// 1. sequence num 가져오기
		int num = noticeDAO.getNum();

		// 2. Notice Table에 insert
		boardDTO.setNum(num);
		int result = noticeDAO.insert(boardDTO);

		// transaction 처리
		if (result < 1) {
			throw new Exception();
		}

		// 3. HDD에 File Save
		FileSaver fs = new FileSaver();
		String realPath = session.getServletContext().getRealPath("resources/notice");

		for (MultipartFile mFile : f1) {
			if (mFile.isEmpty()) {
				continue;
			}
			// 4. Files table insert
			FileDTO fileDTO = new FileDTO();
			fileDTO.setOname(mFile.getOriginalFilename());
			fileDTO.setFname(fs.saveFile3(realPath, mFile));
			fileDTO.setKind("n");
			fileDTO.setNum(num);

			result = fileDAO.insert(fileDTO);

			if (result < 1) {
				throw new Exception();
			}
		}
		ModelAndView mv = new ModelAndView();
		mv.addObject("msg", "작성 성공");
		mv.setViewName("redirect:./noticeList");
		return mv;
	}

	public ModelAndView update(BoardDTO boardDTO, List<MultipartFile> f1, HttpSession session) throws Exception {
		ModelAndView mv = new ModelAndView();
		int result = noticeDAO.update(boardDTO);

		if (result < 1) {
			throw new Exception();
		}

		FileSaver fs = new FileSaver();
		String realPath = session.getServletContext().getRealPath("resources/notice");

		for (MultipartFile mFile : f1) {
			if (mFile.isEmpty()) {
				continue;
			}

			FileDTO fileDTO = new FileDTO();
			fileDTO.setOname(mFile.getOriginalFilename());
			fileDTO.setFname(fs.saveFile3(realPath, mFile));
			fileDTO.setNum(boardDTO.getNum());
			fileDTO.setKind("n");
			result = fileDAO.insert(fileDTO);

			if (result < 1) {
				throw new Exception();
			}
		}

		String msg = "수정 성공";
		mv.setViewName("redirect:./noticeSelect?num=" + boardDTO.getNum());
		mv.addObject("msg", msg);
		return mv;
	}

	public ModelAndView delete(int num, HttpSession session) throws Exception {
		ModelAndView mv = new ModelAndView();
		// 1. notice Delete
		int result = noticeDAO.delete(num);
		if (result < 1) {
			throw new Exception();
		}

		// 2. HDD Delete 준비
		FileDTO fileDTO = new FileDTO();
		fileDTO.setNum(num);
		fileDTO.setKind("n");
		List<FileDTO> ar = fileDAO.list(fileDTO);

		// 3. Files table Delete
		if (ar.size() != 0) {
			result = fileDAO.deleteAll(fileDTO);
			if (result < 1) {
				throw new Exception();
			}

			// 4. HDD Delete
			String realPath = session.getServletContext().getRealPath("resources/notice");
			for (FileDTO fileDTO2 : ar) {
				File file = new File(realPath, fileDTO2.getFname());
				file.delete();
			}
		}

		mv.setViewName("redirect:./noticeList");
		mv.addObject("msg", "삭제 성공");
		return mv;
	}

}
