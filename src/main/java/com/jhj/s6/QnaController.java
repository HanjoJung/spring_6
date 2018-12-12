package com.jhj.s6;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.jhj.board.BoardDTO;
import com.jhj.qna.QnaDTO;
import com.jhj.qna.QnaService;
import com.jhj.util.Pager;

@Controller
@RequestMapping("/qna/**")
public class QnaController {
	
	@Inject
	private QnaService qnaService;
	
	//list
	@RequestMapping(value="qnaList")
	public String list(Model model, Pager pager) throws Exception {
		model.addAttribute("board", "qna");
		List<BoardDTO> ar = qnaService.list(pager);
		model.addAttribute("list", ar);
		model.addAttribute("pager", pager);
		return "board/boardList";
	}
	
	//select
	@RequestMapping(value="qnaSelect")
	public String select(Model model, int num, RedirectAttributes rd) throws Exception {
		model.addAttribute("board", "qna");
		BoardDTO boardDTO = qnaService.select(num);
		String path="";
		if(boardDTO != null) {
			path = "board/boardSelect";
			model.addAttribute("dto", boardDTO);
		}else {
			path ="redirect:./qnaList";
			rd.addFlashAttribute("msg", "해당글이 존재 하지 않습니다.");
		}
		
		return path;
	}
	
	//write Form
	@RequestMapping(value="qnaWrite", method=RequestMethod.GET)
	public String write(Model model) {
		model.addAttribute("board", "qna");
		return "board/boardWrite";
	}
	
	//write process
	@RequestMapping(value="qnaWrite", method=RequestMethod.POST)
	public String write(BoardDTO boardDTO, RedirectAttributes rd) throws Exception {
		int result=qnaService.insert(boardDTO);
		if(result<1) {
			rd.addFlashAttribute("msg", "Write Fail");
		}
		return "redirect:./qnaList";
	}
	
	//update Form
	@RequestMapping(value="qnaUpdate", method=RequestMethod.GET)
	public String update(Model model, int num) throws Exception {
		model.addAttribute("board", "qna");
		BoardDTO boardDTO = qnaService.select(num);
		model.addAttribute("dto", boardDTO);
		return "board/boardUpdate";
	}
	
	//update process
	@RequestMapping(value="qnaUpdate", method=RequestMethod.POST)
	public String update(BoardDTO boardDTO, RedirectAttributes rd) throws Exception {
		int result = qnaService.update(boardDTO);
		
		if(result<1) {
			rd.addFlashAttribute("msg", "Update Fail");
		}
		
		return "redirect:./qnaSelect?num="+boardDTO.getNum();
	}
	
	//delete process
	@RequestMapping(value="qnaDelete", method=RequestMethod.POST)
	public String delete(int num, RedirectAttributes rd) throws Exception {
		
		int result = qnaService.delete(num);
		
		if(result<1) {
			rd.addFlashAttribute("msg", "Delete Fail");
		}
		
		return "redirect:./qnaList";
	}
	
	//reply Form
	@RequestMapping(value="qnaReply", method=RequestMethod.GET)
	public String reply(Model model, int num) {
		model.addAttribute("board", "qna");
		model.addAttribute("num", num);
		return "board/boardReply";
	}
	//reply process
	@RequestMapping(value="qnaReply", method=RequestMethod.POST)
	public String reply(QnaDTO qnaDTO) throws Exception {
		qnaService.reply(qnaDTO);
		return "redirect:./qnaSelect?num="+qnaDTO.getNum();
	}

}
