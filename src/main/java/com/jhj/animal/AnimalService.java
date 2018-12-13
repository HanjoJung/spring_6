package com.jhj.animal;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

@Service
public class AnimalService {
	
	@Inject
	private AnimalDAO animalDAO;

	public List<AnimalDTO> list() throws Exception {
		return null;
	}
	public AnimalDTO select() throws Exception {
		return null;
	}
	public int write() throws Exception {
		return 0;
	}
	public int update() throws Exception {
		return 0;
	}
	public int delete() throws Exception {
		return 0;
	}	
}
