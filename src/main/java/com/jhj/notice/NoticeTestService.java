package com.jhj.notice;

import java.util.Random;

import javax.inject.Inject;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jhj.file.FileDAO;
import com.jhj.file.FileDTO;

@Service
public class NoticeTestService {
	@Inject
	private NoticeDAO noticeDAO;
	@Inject
	private FileDAO fileDAO;

	@Transactional
	public void insert(NoticeDTO noticeDTO, FileDTO fileDTO) throws Exception {
		noticeDAO.insert(noticeDTO);
		fileDAO.insert(fileDTO);
		
	}
}
