package com.inozen.app.common.tree;


import java.util.List;

import com.inozen.app.common.tree.domain.Tree;


public interface TreeService {
	List<Tree> tree(int type, long code);
}
