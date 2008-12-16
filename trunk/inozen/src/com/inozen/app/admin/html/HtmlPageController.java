package com.inozen.app.admin.html;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.inozen.framework.data.support.OrderPage;
import com.inozen.framework.web.GenericController;
import com.inozen.framework.web.support.CommonPages;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.ModelAndView;

import com.inozen.app.admin.html.support.HtmlPageParams;
import com.inozen.app.admin.html.support.HtmlPageRef;
import com.inozen.app.admin.html.support.HtmlPageValidator;
import com.inozen.app.common.seq.SeqConstants;
import com.inozen.app.common.seq.service.SequenceService;
import com.inozen.app.model.HtmlPage;

@Controller
@RequestMapping("/admin/page/*.do")
public class HtmlPageController extends GenericController<HtmlPage, HtmlPageService, HtmlPageRef, HtmlPageValidator, HtmlPageParams>{

	@Autowired
	SequenceService seqService;
	
	protected HtmlPageController() {
		super(HtmlPage.class, HtmlPageService.class, HtmlPageRef.class, HtmlPageValidator.class);
		this.order = "pageCode asc";
	}
	
	@RequestMapping("/admin/page/main.do")
	public ModelAndView main() {
		return new ModelAndView(this.urlbase.substring(1) + "/htmlList");
	}
	
	@RequestMapping(value={"htmlList.do", "popHtmlList.do"}, method=RequestMethod.GET)
	public void htmlList(HttpServletRequest req, ModelMap model, HtmlPageParams params, OrderPage orderPage) {
		
		if (orderPage.getOrder() == null) {
			orderPage.setOrder(this.order);
		}
		
		String _message = "";
		
		List<HtmlPage> list = service.search(params, orderPage);
		
		if(list.size()==0) _message = "등록된 페이지가 없습니다.";
		
		model.addAttribute("orderPage", orderPage);
		model.addAttribute("list", list);
		model.addAttribute("req", req);
		model.addAttribute("message", _message);
	}
	
	@RequestMapping(method=RequestMethod.GET)
	public void saveHtml(ModelMap model) {
		HtmlPage entity;

		try {
			entity = this.domainClass.newInstance();
		} catch (Exception e) {
			throw new RuntimeException(e);
		}

		model.addAttribute("model", entity);
		model = addReference(model);

	}
	
	@RequestMapping(method=RequestMethod.POST)
	public String saveHtml(@ModelAttribute(value="model") HtmlPage model, BindingResult result, SessionStatus status) {
		validator.validate(model, result);
		if(result.hasErrors())
			return this.urlbase + "/saveHtml";
		else{
			
			model.setPageCode(seqService.getSequence(SeqConstants.SEQ_PAGE_ID, SeqConstants.SEQ_PAGE_ID));
			model.setPageStatus("1");
			model.setCreatedDate(new Date());
			// NEWCODE userID, username을 security에서 받아와서 처리하는 것으로 수정
			model.setCreatedUserID("userid");
			model.setCreatedUserName("username");
			model.setModifiedDate(new Date());
			model.setModifiedUserID("userid");
			model.setModifiedUserName("username");
			
			this.service.add(model);
			status.setComplete();
			String returnString = addview(CommonPages.CLOSE_AND_REFRESH, model);

			return returnString;
		}
	}
	
}