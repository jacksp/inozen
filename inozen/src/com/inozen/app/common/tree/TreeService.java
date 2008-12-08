package com.inozen.app.common.tree;


import com.inozen.app.common.tree.domain.Tree;


public interface TreeService {
	Tree[] tree(int type, String code);
}
