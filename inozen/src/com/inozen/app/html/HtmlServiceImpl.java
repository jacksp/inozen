package com.inozen.app.html;

import com.inozen.framework.service.impl.GenericServiceImpl;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.inozen.app.html.support.HtmlPageParams;
import com.inozen.app.model.HtmlPage;

@Service
@Transactional
public class HtmlServiceImpl extends GenericServiceImpl<HtmlPage, HtmlPageDao, HtmlPageParams> implements HtmlPageService {

	public HtmlServiceImpl() {
		super(HtmlPageDao.class);
	}

	@Override
	public HtmlPage getHtmlInfo(long htmlCode) {
		return dao.get(htmlCode);
	}


}
