package com.inozen.app.board.service;

import com.inozen.framework.service.impl.GenericServiceImpl;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.inozen.app.board.dao.ContentDao;
import com.inozen.app.board.support.ContentParams;
import com.inozen.app.model.Content;

@Service
@Transactional
public class ContentServiceImpl extends GenericServiceImpl<Content, ContentDao, ContentParams> implements ContentService {

	public ContentServiceImpl() {
		super(ContentDao.class);
	}


}
