package com.jhj.s6;

import javax.inject.Inject;

import org.junit.Test;

import com.jhj.file.FileDTO;
import com.jhj.notice.NoticeDTO;
import com.jhj.notice.NoticeTestService;

public class NoticeServiceTest extends AbstractTestCase {
	@Inject
	private NoticeTestService ns;

	@Test
	public void test() throws Exception {
		NoticeDTO noticeDTO = new NoticeDTO();
		noticeDTO.setNum(6);
		noticeDTO.setTitle("t");
		noticeDTO.setWriter("t");
		noticeDTO.setContents("t");
		
		FileDTO fileDTO = new FileDTO();
		fileDTO.setNum(noticeDTO.getNum());
		fileDTO.setFname("t");
		fileDTO.setKind("n");
		ns.insert(noticeDTO, fileDTO);
	}

}
