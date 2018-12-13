package com.jhj.animal;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;


@Repository
public class AnimalDAO {
	@Inject
	private SqlSession session;
	private String NAMESPACE = "animalMapper.";
	
	public List<AnimalDTO> list() throws Exception {
		return session.selectList(NAMESPACE+"list");
	}
	public AnimalDTO select(int num) throws Exception {
		return session.selectOne(NAMESPACE+"select", num);
	}
	public int insert(AnimalDTO animalDTO) throws Exception {
		return session.insert(NAMESPACE+"insert", animalDTO);
	}
	public int update() throws Exception {
		return 0;
	}
	public int delete() throws Exception {
		return 0;
	}
	
}
