package com.inozen.app.common.tree;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.inozen.app.common.tree.domain.Tree;


@Controller
@RequestMapping("/common/tree/*.do")
public class TreeController {
	
	/** logger for subclasses */
	protected Log logger = LogFactory.getLog(this.getClass());
	
	@Autowired
	protected TreeService service;
	
	protected ApplicationContext applicationContext;
	
	protected TreeController(){}
	
	public TreeController(TreeService service) {
		this.service = service;
	}

	@RequestMapping
	public ModelAndView tree(HttpServletRequest req, HttpServletResponse res, ModelMap model, @RequestParam("type") int type, @RequestParam(value="code", required=false) String code) throws Exception {
		
		model.addAttribute("type", type);
		if(code==null) code = "";
		Tree[] tree = service.tree(type, code);
		model.addAttribute("list", tree);
		
		return new ModelAndView("/common/tree/tree", model);
	}
	
	

}
