package com.inozen.app.common.tree;


import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.inozen.app.common.tree.dao.TreeDao;
import com.inozen.app.common.tree.domain.Tree;

@Service
@Transactional
public class TreeServiceImpl implements TreeService {
	
	protected Log logger = LogFactory.getLog(this.getClass());
	
	@Autowired
	private TreeDao dao;

	@Override
	public List<Tree> tree(int type, long code) {
		List<Tree> list = dao.tree(type, code);
		return list;
	}

}
