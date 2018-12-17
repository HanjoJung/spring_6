package com.jhj.memo;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.jhj.util.Pager;

@Service
public class MemoService {

	@Inject
	private MemoDAO memoDAO;

	public List<MemoDTO> list(Pager pager) throws Exception {
		pager.makeRow();
		int totalCount = memoDAO.totalCount();
		pager.makePage(totalCount);
		List<MemoDTO> ar = memoDAO.list(pager);
		return ar;
	}

	@RequestMapping(value = "select")
	public MemoDTO select(int num) throws Exception {
		return memoDAO.select(num);
	}

}
