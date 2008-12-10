package com.inozen.app.common.tree.dao;

import java.util.List;

import com.inozen.app.common.tree.domain.Tree;
import com.inozen.app.model.Category;

public interface TreeDao {

	void setTree(int type);

	// count of child node
	int getChildCount(long code);
	
	// check have no child
	boolean isEmptyChild(long code);
	
	@SuppressWarnings("unchecked")
	List getChildren(long code);
}
