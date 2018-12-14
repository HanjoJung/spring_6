package com.jhj.trans;

import org.springframework.stereotype.Component;

//target
@Component
public class Trip {

	//point cut
	public void go() {
		System.out.println("=============================");
		System.out.println("여행 가기");
		System.out.println("=============================");
	}
}
