package com.inozen.app.board.service;

import com.inozen.framework.service.GenericService;

import com.inozen.app.board.dao.ContentDao;
import com.inozen.app.board.support.ContentParams;
import com.inozen.app.model.Content;

public interface ContentService extends GenericService<Content, ContentDao, ContentParams>{
}
