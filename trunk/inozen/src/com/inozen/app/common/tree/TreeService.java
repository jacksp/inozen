package com.inozen.app.common.tree;


import java.util.List;

import com.inozen.app.common.tree.domain.Tree;


public interface TreeService {
	List<Tree> tree(int type, long code);
	
	List<Tree> getCategoryChildren(long code, List<Tree> list, int level);
	
	void getBoardChildren(long code, List<Tree> list, int level);
	
	List<Tree> getCategoryAndBoard(long code, List<Tree> list, int level);
}
