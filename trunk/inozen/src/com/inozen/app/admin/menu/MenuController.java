package com.inozen.app.admin.menu;

import java.util.Date;
import java.util.List;

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

import com.inozen.app.admin.menu.support.MenuParams;
import com.inozen.app.admin.menu.support.MenuRef;
import com.inozen.app.admin.menu.support.MenuValidator;
import com.inozen.app.common.seq.SeqConstants;
import com.inozen.app.common.seq.service.SequenceService;
import com.inozen.app.model.Menu;

@Controller
@RequestMapping("/admin/menu/*.do")
public class MenuController extends GenericController<Menu, MenuService, MenuRef, MenuValidator, MenuParams> {

	protected String refresh = CommonPages.CLOSE_AND_REFRESH;
	
	@Autowired
	protected SequenceService seqService;
	
	protected MenuController() {
		super(Menu.class, MenuService.class, MenuRef.class, MenuValidator.class);
		this.order = "menuOrder asc";
	}
	
	/**
	 * This method handels ${urlbase}/main.do GET method request.
	 */
	@RequestMapping("/admin/menu/main.do")
	public void main() {
	}
	
	@RequestMapping(method=RequestMethod.GET)
	public void saveMenu(ModelMap model, @RequestParam("pMenuCode") String pMenuCode) {
		long _code = -1l;
		Menu entity;

		try {
			entity = this.domainClass.newInstance();
		} catch (Exception e) {
			throw new RuntimeException(e);
		}

		if (!pMenuCode.equalsIgnoreCase("") && !pMenuCode.equalsIgnoreCase("null")) {
			_code = Long.parseLong(pMenuCode);
			entity = this.service.get(_code);
		}
		model.addAttribute("model", entity);
		model = addReference(model);
		

	}
	
	@RequestMapping(method=RequestMethod.POST)
	public String saveMenu(@ModelAttribute(value="model") Menu model, BindingResult result, @RequestParam("pMenuCode") long pMenuCode, @RequestParam("pMenuName") String pMenuName, SessionStatus status) {
		validator.validate(model, result);
		
		if(result.hasErrors())
			return this.urlbase + "/saveMenu";
		else{
			model.setMenuCode(seqService.getSequence(SeqConstants.SEQ_MENU_ID, SeqConstants.SEQ_MENU_ID));
			model.setCreatedDate(new Date());
			model.setModifiedDate(new Date());
			// NEWCODE 이후에 session에서 처리해아야 함.
			model.setCreatedUserID("user_id");
			model.setCreatedUserName("user_name");
			model.setModifiedUserID("user_id");
			model.setModifiedUserName("user_name");
			model.setMenuOrder(service.countChildren(model.getPMenuCode()));
			model.setMenuStatus("1");
			model.setPMenuCode(pMenuCode);
			model.setPMenuName(pMenuName);
			this.service.add(model);
			status.setComplete();
			String returnString = addview(this.urlbase+"/menuList", model);

			return returnString;
		}
	}
	
	@RequestMapping(method=RequestMethod.GET)
	public void menuList(ModelMap model, MenuParams params, OrderPage orderPage, @RequestParam(value="code", required=false) String code) throws Exception {
		if (orderPage.getOrder() == null) {
			orderPage.setOrder(this.order);
			orderPage.setOrder("menuCode asc");
		}
		
		String _message = "";
		
		if(code!=null)
			params.setPMenuCode(Long.parseLong(code));
		else params.setPMenuCode(-1);
		
		List<Menu> list = service.search(params, orderPage);
		
		if(code==null&&list.size()==0) {
			_message="생성된 루트 메뉴가 없습니다. 추가 버튼을 클릭하고 루트 메뉴를 생성하세요.";
		}
		
		model.addAttribute("orderPage", orderPage);
		model.addAttribute("list", list);
		model.addAttribute("code", code);
		model.addAttribute("message", _message);
	}
	
	@RequestMapping(method=RequestMethod.POST)
	public ModelAndView menuList(ModelMap model, MenuParams params, OrderPage orderPage) throws Exception {
		if (orderPage.getOrder() == null) {
			orderPage.setOrder(this.order);
		}
		model.addAttribute("orderPage", orderPage);
		model.addAttribute("list", service.search(params, orderPage));
		
		ModelAndView returnModelAndView = new ModelAndView(this.urlbase.substring(1) + "/menuList", model);
		return returnModelAndView;
	}
	
	
}