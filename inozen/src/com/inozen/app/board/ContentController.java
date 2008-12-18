package com.inozen.app.board;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.inozen.framework.data.support.OrderPage;
import com.inozen.framework.web.GenericController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.inozen.app.board.service.ContentService;
import com.inozen.app.board.support.ContentParams;
import com.inozen.app.board.support.ContentRef;
import com.inozen.app.board.support.ContentValidator;
import com.inozen.app.category.CategoryService;
import com.inozen.app.common.seq.service.SequenceService;
import com.inozen.app.model.Content;

@Controller
@RequestMapping({"/board/*.do", "/cyber/*.do"})
public class ContentController extends GenericController<Content, ContentService, ContentRef, ContentValidator, ContentParams>{

	@Autowired
	CategoryService cateService;
	
	@Autowired
	SequenceService seqService;
	
	protected ContentController() {
		super(Content.class, ContentService.class, ContentRef.class, ContentValidator.class);
		this.order = "contentOrder asc";
	}
	
	@RequestMapping("/board/main.do")
	public void main() {
	}
	
	@RequestMapping(value="/cyber/cyber02.do", method=RequestMethod.GET)
	public void contentList(HttpServletRequest req, ModelMap model, ContentParams params, OrderPage orderPage, @RequestParam(value="code", required=false) String code) {
		
		if (orderPage.getOrder() == null) {
			orderPage.setOrder(this.order);
		}
		
		if(code!=null)
			params.setBoardCode(Long.parseLong(code));
		else params.setBoardCode(-1);
		
		List<Content> list = service.search(params, orderPage);
		
		
		model.addAttribute("orderPage", orderPage);
		model.addAttribute("list", list);
		model.addAttribute("code", code);
		
		model.addAttribute("req", req);	
	}
	
}