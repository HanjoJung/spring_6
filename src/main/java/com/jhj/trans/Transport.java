package com.jhj.trans;

import org.springframework.stereotype.Component;

//target
@Component
public class Transport {
	//join points

	//point cut
	public void bus() {
		System.out.println("게임하기");
		System.out.println("잠자기");
	}

	public void subway() {
		System.out.println("음악듣기");
		System.out.println("카톡");
	}

}
