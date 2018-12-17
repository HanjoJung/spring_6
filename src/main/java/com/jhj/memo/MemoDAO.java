package com.jhj.memo;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.jhj.util.Pager;

@Repository
public class MemoDAO {

	@Inject
	private SqlSession session;
	private final String NAMESPACE = "mamoMapper.";

	public int totalCount() throws Exception {
		return session.selectOne(NAMESPACE + "totalCount");
	}

	public List<MemoDTO> list(Pager pager) throws Exception {
		return session.selectList(NAMESPACE + "list", pager);
	}

	public MemoDTO select(int num) throws Exception {
		return session.selectOne(NAMESPACE + "select", num);
	}

}
