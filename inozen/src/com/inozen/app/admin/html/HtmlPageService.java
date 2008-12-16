package com.inozen.app.admin.html;

import com.inozen.framework.service.GenericService;

import com.inozen.app.admin.html.support.HtmlPageParams;
import com.inozen.app.model.HtmlPage;

public interface HtmlPageService extends GenericService<HtmlPage, HtmlPageDao, HtmlPageParams>{
	HtmlPage getHtmlInfo(long htmlCode);
}
