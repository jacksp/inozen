package com.inozen.app.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.inozen.app.admin.html.HtmlPageService;
import com.inozen.app.admin.menu.MenuService;
import com.inozen.app.admin.menu.support.MenuParams;
import com.inozen.app.model.HtmlPage;
import com.inozen.app.model.Menu;

@Controller
@RequestMapping("/html/*.do")
public class HtmlController {
	@Autowired
	MenuService menuService;
	
	@Autowired
	HtmlPageService htmlService;
	
	@RequestMapping
	public void view(ModelMap model, @RequestParam(value="code", required=false) String code) throws Exception {
		Menu menu = null;
		HtmlPage html = null;
		Long _htmlCode = null;
		if(code!=null) {
			menu = new Menu();
			menu = menuService.get(Long.parseLong(code));
			_htmlCode = menu.getMenuRelatedCode();
			
			html = htmlService.get(_htmlCode);
		}
		
		model.addAttribute("page", html.getPageLocation());
		
	}

}
