package com.inozen.app.board;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.inozen.framework.data.support.OrderPage;
import com.inozen.framework.web.GenericController;
import com.inozen.framework.web.support.CommonPages;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.ModelAndView;

import com.inozen.app.admin.board.support.BoardParams;
import com.inozen.app.admin.board.support.BoardRef;
import com.inozen.app.admin.board.support.BoardValidator;
import com.inozen.app.admin.category.CategoryService;
import com.inozen.app.common.seq.SeqConstants;
import com.inozen.app.common.seq.service.SequenceService;
import com.inozen.app.model.Board;
import com.inozen.app.model.Category;

@Controller
@RequestMapping("/admin/board/*.do")
public class AppBoardController extends GenericController<Board, AppBoardService, BoardRef, BoardValidator, BoardParams>{

	@Autowired
	CategoryService cateService;
	
	@Autowired
	SequenceService seqService;
	
	protected AppBoardController() {
		super(Board.class, AppBoardService.class, BoardRef.class, BoardValidator.class);
		this.order = "boardOrder asc";
	}
	
	@RequestMapping("/admin/board/main.do")
	public void main() {
	}
	
	@RequestMapping(method=RequestMethod.GET)
	public void boardList(HttpServletRequest req, ModelMap model, BoardParams params, OrderPage orderPage, @RequestParam(value="code", required=false) String code) {
		
		if (orderPage.getOrder() == null) {
			orderPage.setOrder(this.order);
		}
		
		String _message = "";
		
		if(code!=null)
			params.setCateCode(Long.parseLong(code));
		else params.setCateCode(-1);
		
		List<Board> list = service.search(params, orderPage);
		
		
		model.addAttribute("orderPage", orderPage);
		model.addAttribute("list", list);
		model.addAttribute("code", code);
		
		if(code==null&&list.size()==0) {
			_message="추가 버튼을 클릭하고 게시판을 생성하세요.";
		}
		model.addAttribute("req", req);	
		model.addAttribute("message", _message);
	}
	
	@RequestMapping(method=RequestMethod.GET)
	public void saveBoard(ModelMap model, @RequestParam("cateCode") String cateCode) {
		long _code = -1l;
		Board entity;
		Category categoryEntity;

		try {
			entity = this.domainClass.newInstance();
			categoryEntity = new Category();
		} catch (Exception e) {
			throw new RuntimeException(e);
		}

		if (!cateCode.equalsIgnoreCase("") && !cateCode.equalsIgnoreCase("null")) {
			_code = Long.parseLong(cateCode);
			categoryEntity = this.cateService.get(_code);
		}
		model.addAttribute("model", entity);
		model.addAttribute("category", categoryEntity);
		model = addReference(model);

	}
	
	@RequestMapping(method=RequestMethod.POST)
	public String saveBoard(@ModelAttribute(value="model") Board model, BindingResult result, @RequestParam("cateCode") long cateCode, @RequestParam("cateName") String cateName, SessionStatus status) {
		validator.validate(model, result);
		if(result.hasErrors())
			return this.urlbase + "/saveBoard";
		else{
			Category category = new Category();
			category.setCateCode(cateCode);
			
			model.setBoardCode(seqService.getSequence(SeqConstants.SEQ_BOARD_ID, SeqConstants.SEQ_BOARD_ID));
			model.setBoardOrder(service.countBoardByCateCode(cateCode));
			model.setBoardStatus("1");
			model.setCreatedDate(new Date());
			// NEWCODE userID, username을 security에서 받아와서 처리하는 것으로 수정
			model.setCreatedUserId("userid");
			model.setCreatedUserName("username");
			model.setModifiedDate(new Date());
			model.setModifiedUserId("userid");
			model.setModifiedUserName("username");
			model.setCategory(category);
			
			this.service.add(model);
			status.setComplete();
			String returnString = addview(CommonPages.CLOSE_RESEARCH_PARENT, model);

			return returnString;
		}
	}
	
}