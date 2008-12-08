package com.inozen.app.common.tree.dao;

import java.util.List;

import com.inozen.app.common.tree.domain.Tree;

public interface TreeDao {

	List<Tree> tree(int type, String code);

	// count of child node
	int getChildCount(String code);
	
	// check have no child
	boolean isEmptyChild(String code);
	
	// get children
	List<Tree> getChildren(String code);
}
