package com.inozen.app.board;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.servlet.http.HttpServletRequest;

import com.inozen.framework.data.support.OrderPage;
import com.inozen.framework.web.GenericController;

import org.hibernate.annotations.ForeignKey;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.support.SessionStatus;

import com.inozen.app.board.service.BoardService;
import com.inozen.app.board.service.ContentService;
import com.inozen.app.board.support.ContentParams;
import com.inozen.app.board.support.ContentRef;
import com.inozen.app.board.support.ContentValidator;
import com.inozen.app.board.support.CouncelContentValidator;
import com.inozen.app.board.support.CounselWriteForm;
import com.inozen.app.common.seq.SeqConstants;
import com.inozen.app.common.seq.service.SequenceService;
import com.inozen.app.model.Board;
import com.inozen.app.model.Content;
import com.inozen.app.model.CouncelContent;
import com.inozen.app.model.enumeration.CounselProgress;

@Controller
@RequestMapping("/cyber/*.do")
public class ContentController extends GenericController<Content, ContentService, ContentRef, ContentValidator, ContentParams>{

	@Autowired
	BoardService bService;
	
	@Autowired
	SequenceService seqService;
	
		
	protected ContentController() {
		super(Content.class, ContentService.class, ContentRef.class, ContentValidator.class);
		this.order = "contentOrder asc";
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
	}
	
	@RequestMapping(value="/cyber/cyber02_vw.do")
	public void viewContent(@RequestParam(value="code", required=true) String code, ModelMap model) {
		Long id;
		if(StringUtils.hasLength(code)) {
			id = Long.parseLong(code);
			model.addAttribute("entity", service.get(id));
		}
		
		model = addReference(model);
	}
	
	@RequestMapping(value="/cyber/cyber02_wr.do", method=RequestMethod.GET)
	public void writeContent(ModelMap model, CounselWriteForm formEntity, @RequestParam(value="code", required=false) String code) {
		try {
			formEntity = new CounselWriteForm();
		} catch (Exception e) {
			throw new RuntimeException(e);
		}

		model.addAttribute("formEntity", formEntity);
		model.addAttribute("code", code);
		model = addReference(model);
	}
	
	@RequestMapping(value="/cyber/cyber02_wr.do", method=RequestMethod.POST)
	public String writeContent(@ModelAttribute(value="formEntity") CounselWriteForm formEntity,
			BindingResult result, SessionStatus status) {
		
		//validator.validate(formEntity, result);
		CouncelContentValidator councelValidator = new CouncelContentValidator();
		councelValidator.validate(formEntity, result);
		if(result.hasErrors()) {
			return this.urlbase + "/cyber02_wr";
		} else{
			Board board = new Board();
			// TODO 이후 form 값내 board code로 변경
			board.setBoardCode(1l);
			//board.setBoardCode(Long.parseLong(formEntity.getBoardCode()));
			
			CouncelContent councelContent = new CouncelContent();
			councelContent.setCelPhoneNumber(formEntity.getCelPhoneNumber1()+"-"+formEntity.getCelPhoneNumber2()+"-"+formEntity.getCelPhoneNumber3());
			councelContent.setEmail(formEntity.getEmail());
			councelContent.setPassword(formEntity.getPassword());
			councelContent.setSms(StringUtils.hasText(formEntity.getSms())?formEntity.getSms():"N" );
			councelContent.setSocialNumber(formEntity.getSocialNumber1()+"-"+formEntity.getSocialNumber2());
			councelContent.setProgressStatus(CounselProgress.REG);
			
			Content content = new Content();
			content.setBoard(board);
			content.setContent(formEntity.getContent());
			content.setContentCode(seqService.getSequence(SeqConstants.SEQ_CONTENT_ID, SeqConstants.SEQ_CONTENT_ID));
			// TODO 이후 일반 공통코드에서 가져오는 것으로 변경
			content.setContentStatus("1");
			content.setContentTitle(formEntity.getTitle());
			content.setCouncelContent(councelContent);
			content.setCreatedDate(new Date());
			content.setCreatedUserName(formEntity.getName());
			content.setModifiedDate(new Date());
			content.setModifiedUserName(formEntity.getName());
			content.setViewCnt(0);
			
			this.service.add(content);
			status.setComplete();
			//String returnString = addview(addview, content);
			//return returnString;
			return null;
		}
	}
	
}