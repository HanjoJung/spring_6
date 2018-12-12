package com.jhj.s6;

import static org.junit.Assert.*;

import javax.inject.Inject;

import org.junit.Test;

import com.jhj.board.BoardDTO;
import com.jhj.file.FileDTO;
import com.jhj.notice.NoticeDAO;

public class NoticeTest extends AbstractTestCase{

	@Inject
	private NoticeDAO noticeDAO;
	
	@Test
	public void test() throws Exception {
		BoardDTO boardDTO = noticeDAO.select(156);
		System.out.println("======= start =======");
		System.out.println(boardDTO.getNum());
		for (FileDTO fileDTO : boardDTO.getFiles()) {
			System.out.println(fileDTO.getFnum());
			System.out.println(fileDTO.getFname());
			System.out.println(fileDTO.getOname());
		}
		System.out.println("=====================");
	}

}
