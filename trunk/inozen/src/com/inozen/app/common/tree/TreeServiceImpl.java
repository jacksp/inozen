package com.inozen.app.common.tree;


import java.util.ArrayList;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.inozen.app.common.tree.dao.TreeDao;
import com.inozen.app.common.tree.domain.Tree;
import com.inozen.app.model.Board;
import com.inozen.app.model.Category;

@Service
@Transactional
public class TreeServiceImpl implements TreeService {
	
	private static final int CATEGORY = 1;
	private static final int BOARD = 2;
	
	@Autowired
	private TreeDao dao;

	@Override
	public List<Tree> tree(int type, long code) {
		int level = 0;
		List<Tree> list = new ArrayList<Tree>();
		dao.setTree(type);
		list = getCategoryChildren(code, list, level);
		return list;
	}
	
	@Override
	public List<Tree> getCategoryChildren(long code, List<Tree> list, int level) {
		Tree tree = null;
		int _count = dao.getChildCount(code);
		long _code = -1;
		List<Category> _list = null;
		if(_count>0) {
			_list = dao.getChildren(code);
			for(int i=0; i<_list.size(); i++) {
				boolean haschild = false;
				_code = _list.get(i).getCateCode();
				tree = new Tree();
				tree.setName(_list.get(i).getCateName());
				tree.setNodeId(Long.toString(_code));
				tree.setHasChild(haschild);
				tree.setParentId(Long.toString(code));
				tree.setLast(true);
				tree.setLevel(level);
				if(dao.getChildCount(_code)>0 ) {
					tree.setLast(false);
				}
				tree.setLeaf(false);
				list.add(tree);
				if(dao.getChildCount(_code)>0 ) {
					int _level = level+1;
					getCategoryChildren(_code, list, _level);
				}
			}
		}
		return list;
	}

	@Override
	public List<Tree> getBoardChildren(long code, List<Tree> list, int level) {
		dao.setTree(CATEGORY);
		Tree tree = null;
		int _count = dao.getChildCount(code);
		long _code = -1;
		List<Category> _list = null;
		if(_count>0) {
			_list = dao.getChildren(code);
			for(int i=0; i<_list.size(); i++) {
				boolean haschild = false;
				_code = _list.get(i).getCateCode();
				tree = new Tree();
				tree.setName(_list.get(i).getCateName());
				tree.setNodeId(Long.toString(_code));
				tree.setHasChild(haschild);
				tree.setParentId(Long.toString(code));
				tree.setLast(true);
				tree.setLevel(level);
				if(dao.getChildCount(_code)>0 ) {
					tree.setLast(false);
				}
				tree.setLeaf(false);
				list.add(tree);
				if(dao.getChildCount(_code)>0 ) {
					int _level = level+1;
					getCategoryChildren(_code, list, _level);
				}
			}
		}
		return null;
	}
	
	

}
