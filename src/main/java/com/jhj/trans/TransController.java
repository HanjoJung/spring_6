package com.jhj.trans;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "/trans/**")
public class TransController {
	
	@Inject
	private Transport transport;

	@RequestMapping(value = "/go")
	public void start() {
		transport.bus();
		transport.subway();
	}

}
