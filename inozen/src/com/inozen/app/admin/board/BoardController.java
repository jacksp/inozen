package com.inozen.app.admin.board;

import com.inozen.framework.web.GenericController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.inozen.app.admin.board.support.BoardParams;
import com.inozen.app.admin.board.support.BoardRef;
import com.inozen.app.admin.board.support.BoardValidator;
import com.inozen.app.model.Board;

@Controller
@RequestMapping("/admin/board/*.do")
public class BoardController extends GenericController<Board, BoardService, BoardRef, BoardValidator, BoardParams>{

	protected BoardController() {
		super(Board.class, BoardService.class, BoardRef.class, BoardValidator.class);
		this.order = "boardOrder asc";
	}
	
}