package com.inozen.app.web;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/*.do")
public class MainController {
	@RequestMapping
	public void main() {
		
	}
	
	@RequestMapping
	public void login() {
	}
	
	@RequestMapping
	public void logout() {
	}
	
	
}
