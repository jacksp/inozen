package com.inozen.app.admin.category;

import java.util.Date;
import java.util.List;

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
	public void saveCategory(ModelMap model, @RequestParam("pCateCode") String pCateCode) {
		long _code = -1l;
		Category entity;

		try {
			entity = this.domainClass.newInstance();
		} catch (Exception e) {
			throw new RuntimeException(e);
		}

		if (!pCateCode.equalsIgnoreCase("") && !pCateCode.equalsIgnoreCase("null")) {
			_code = Long.parseLong(pCateCode);
			entity = this.service.get(_code);
		}
		model.addAttribute("model", entity);
		model = addReference(model);
		

	}
	
	@RequestMapping(method=RequestMethod.POST)
	public String saveCategory(@ModelAttribute(value="model") Category model, BindingResult result, @RequestParam("pCateCode") long pCateCode, @RequestParam("pCateName") String pCateName, SessionStatus status) {
		validator.validate(model, result);
		if(result.hasErrors())
			return this.urlbase + "/saveCategory";
		else{
			model.setCateCode(seqService.getSequence(SeqConstants.SEQ_CATEGORY_ID, SeqConstants.SEQ_CATEGORY_ID));
			model.setCateOrder(service.countChildren(pCateCode));
			model.setCateStatus("1");
			model.setCreatedDate(new Date());
			// NEWCODE userID, username을 security에서 받아와서 처리하는 것으로 수정
			model.setCreatedUserId("userid");
			model.setCreatedUserName("username");
			model.setModifiedDate(new Date());
			model.setModifiedUserId("userid");
			model.setModifiedUserName("username");
			model.setPCateCode(pCateCode);
			model.setPCateName(pCateName);
			
			this.service.add(model);
			status.setComplete();
			String returnString = addview(CommonPages.CLOSE_RESEARCH_PARENT, model);

			return returnString;
		}
	}
	
	@RequestMapping(method=RequestMethod.GET)
	public void categoryList(ModelMap model, CategoryParams params, OrderPage orderPage, @RequestParam(value="code", required=false) String code) throws Exception {
		if (orderPage.getOrder() == null) {
			orderPage.setOrder(this.order);
			orderPage.setOrder("cateCode asc");
		}
		
		if(code!=null)
			params.setPCateCode(Long.parseLong(code));
		else params.setPCateCode(-1);
		List<Category> list = service.search(params, orderPage);
		String _message = "";
		
		model.addAttribute("orderPage", orderPage);
		model.addAttribute("list", list);
		model.addAttribute("code", code);
		
		if(code==null&&list.size()==0) {
			_message="생성된 루트 카테고리가 없습니다. 추가 버튼을 클릭하고 루트 카테고리를 생성하세요.";
		}
			
		model.addAttribute("message", _message);
	}
	
	@RequestMapping(method=RequestMethod.POST)
	public ModelAndView categoryList(ModelMap model, CategoryParams params, OrderPage orderPage) throws Exception {
		if (orderPage.getOrder() == null) {
			orderPage.setOrder(this.order);
		}
		model.addAttribute("orderPage", orderPage);
		model.addAttribute("list", service.search(params, orderPage));
		
		ModelAndView returnModelAndView = new ModelAndView(this.urlbase.substring(1) + "/categoryList", model);
		return returnModelAndView;
	}
	
	
}