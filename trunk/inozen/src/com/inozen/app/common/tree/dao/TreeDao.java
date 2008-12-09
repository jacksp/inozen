package com.inozen.app.common.tree.dao;

import java.util.List;

import com.inozen.app.common.tree.domain.Tree;
import com.inozen.app.model.Category;

public interface TreeDao {

	List<Tree> tree(int type, long code);

	// count of child node
	int getChildCount(long code);
	
	// check have no child
	boolean isEmptyChild(long code);
	
	List<Category> getCategoryChildren(long code);
	List<Tree> getCategoryChildren(long code, List<Tree> list, int level);
}
