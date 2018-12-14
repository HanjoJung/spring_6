package com.jhj.s6;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.jhj.trans.Transport;
import com.jhj.trans.Trip;

@Controller
@RequestMapping(value = "/trans/**")
public class TransController {

	@Inject
	private Transport transport;
	@Inject
	private Trip trip;

	@RequestMapping(value = "trip")
	public void go() {
		trip.go();
	}
	
	@RequestMapping(value = "go")
	public void start() {
		transport.bus();
		System.out.println("====================");
		transport.subway();
	}

}
