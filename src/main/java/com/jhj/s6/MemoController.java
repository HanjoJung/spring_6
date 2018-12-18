package com.jhj.s6;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jhj.memo.MemoDTO;
import com.jhj.memo.MemoService;
import com.jhj.util.Pager;

/*@RestController*/
@Controller
@RequestMapping(value = "/memo/**", produces="application/json;charset=UTF-8")
public class MemoController {

	@Inject
	private MemoService memoService;

	@RequestMapping(value = "memoList")
	public void memoList() throws Exception {
	}

	@RequestMapping(value = "jtest2")
	@ResponseBody
	public String jtest2() throws Exception {
		return "테스트3";
	}
	
	@RequestMapping(value = "jtest1")
	@ResponseBody
	public Map<String, MemoDTO> jtest1() throws Exception {
		Map<String, MemoDTO> map = new HashMap<String, MemoDTO>();
		for (int i = 1; i < 3; i++) {
			MemoDTO memoDTO = new MemoDTO();
			memoDTO.setNum(i);
			map.put("f"+i, memoDTO);
		}
		return map;
	}

	@RequestMapping(value = "list/{board}/")
	@ResponseBody
	public List<MemoDTO> list(@PathVariable String board) throws Exception {
		System.out.println(board);
		Pager pager = new Pager();
		return memoService.list(pager);
	}

	@RequestMapping(value = "select")
	@ResponseBody
	public MemoDTO select(int num) throws Exception {
		return memoService.select(num);
	}

}
