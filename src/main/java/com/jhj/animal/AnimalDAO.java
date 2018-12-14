package com.jhj.animal;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.jhj.util.Pager;

@Repository
public class AnimalDAO {
	@Inject
	private SqlSession session;
	private String NAMESPACE = "animalMapper.";

	public List<AnimalDTO> list(Pager pager) throws Exception {
		return session.selectList(NAMESPACE + "list", pager);
	}

	public int totalCount() throws Exception {
		return session.selectOne(NAMESPACE + "totalCount");
	}
	
	public AnimalDTO select(int num) throws Exception {
		return session.selectOne(NAMESPACE + "select", num);
	}

	public int insert(AnimalDTO animalDTO) throws Exception {
		return session.insert(NAMESPACE + "insert", animalDTO);
	}

	public int update(AnimalDTO animalDTO) throws Exception {
		return session.update(NAMESPACE + "update", animalDTO);
	}

	public int delete(int num) throws Exception {
		return session.delete(NAMESPACE + "delete", num);
	}

}
