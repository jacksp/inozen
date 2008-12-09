package com.inozen.app.admin.category;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.ModelAndView;

import com.inozen.app.admin.category.support.CategoryParams;
import com.inozen.app.admin.category.support.CategoryRef;
import com.inozen.app.admin.category.support.CategoryValidator;
import com.inozen.app.common.seq.SeqConstants;
import com.inozen.app.common.seq.service.SequenceService;
import com.inozen.app.model.Category;

@Controller
@RequestMapping("/admin/category/*.do")
public class CategoryController extends GenericController<Category, CategoryService, CategoryRef, CategoryValidator, CategoryParams> {

	protected String refresh = CommonPages.CLOSE_AND_REFRESH;
	
	@Autowired
	protected SequenceService seqService;
	
	protected CategoryController() {
		super(Category.class, CategoryService.class, CategoryRef.class, CategoryValidator.class);
		this.order = "cateOrder asc";
	}
	
	/**
	 * This method handels ${urlbase}/main.do GET method request.
	 */
	@RequestMapping("/admin/category/main.do")
	public void main() {
	}
	
	@RequestMapping(method=RequestMethod.GET)
	public void saveCategory(ModelMap model, @RequestParam("pCode") String pCode) {
		long _code = -1l;
		Category entity;
		
		if(!pCode.equalsIgnoreCase("")) {
			_code = Long.parseLong(pCode);
			entity = this.service.get(_code);
		}else{
			try {
			entity = this.domainClass.newInstance();
			}catch(Exception e) {
				throw new RuntimeException(e);
			}
		}
		model.addAttribute("model", entity);
		model = addReference(model);

	}
	
	@RequestMapping(method=RequestMethod.POST)
	public String saveCategory(@ModelAttribute("model") Category model, BindingResult result, SessionStatus status) {
		validator.validate(model, result);
		if(result.hasErrors())
			return this.urlbase + "/saveCategory";
		else{
			model.setCateCode(seqService.getSequence(SeqConstants.SEQ_CATEGORY_ID, SeqConstants.SEQ_CATEGORY_ID));
			model.setCateOrder(0);
			model.setCateStatus("1");
			model.setCreatedDate(new Date());
			// NEWCODE userID, username을 security에서 받아와서 처리하는 것으로 수정
			model.setCreatedUserId("userid");
			model.setCreatedUserName("username");
			model.setModifiedDate(new Date());
			model.setModifiedUserId("userid");
			model.setModifiedUserName("username");
			
			this.service.add(model);
			status.setComplete();
			String returnString = addview(refresh, model);

			return returnString;
		}
	}
	
	@RequestMapping(method=RequestMethod.GET)
	public ModelAndView categoryList(ModelMap model, CategoryParams params, OrderPage orderPage, @RequestParam(value="code", required=false) String code) throws Exception {
		if (orderPage.getOrder() == null) {
			orderPage.setOrder(this.order);
		}
		
		if(code!=null)
			params.setPCateCode(Long.parseLong(code));
		model.addAttribute("orderPage", orderPage);
		model.addAttribute("list", service.search(params, orderPage));
		
		ModelAndView returnModelAndView = new ModelAndView(this.urlbase.substring(1) + "/categoryList", model);
		return returnModelAndView;
	}
	
	@RequestMapping(method=RequestMethod.POST)
	public ModelAndView categoryList(HttpServletRequest req, HttpServletResponse res, ModelMap model, CategoryParams params, OrderPage orderPage) throws Exception {
		if (orderPage.getOrder() == null) {
			orderPage.setOrder(this.order);
		}
		model.addAttribute("orderPage", orderPage);
		model.addAttribute("list", service.search(params, orderPage));
		
		ModelAndView returnModelAndView = new ModelAndView(this.urlbase.substring(1) + "/categoryList", model);
		return returnModelAndView;
	}
	
	
}