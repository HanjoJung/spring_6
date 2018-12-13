package com.jhj.util;

import static org.junit.Assert.*;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import com.jhj.animal.AnimalService;
import com.jhj.s6.AbstractTestCase;

public class ConnectTest extends AbstractTestCase {
	
	@Inject
	private AnimalService animalService;

	@Test
	public void test() {
	}

}
