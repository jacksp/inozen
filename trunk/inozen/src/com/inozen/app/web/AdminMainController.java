package com.inozen.app.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin/*.do")
public class AdminMainController {
	@RequestMapping("/admin/main.do")
	public void adminMain() {
		
	}

}
