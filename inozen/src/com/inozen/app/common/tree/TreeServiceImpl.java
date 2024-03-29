package com.inozen.app.common.tree;


import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.inozen.app.common.tree.dao.TreeDao;
import com.inozen.app.common.tree.domain.Tree;
import com.inozen.app.model.Board;
import com.inozen.app.model.Category;
import com.inozen.app.model.Menu;

@Service
@Transactional
public class TreeServiceImpl implements TreeService {
	
	@Autowired
	private TreeDao dao;

	@Override
	public List<Tree> tree(int type, long code) {
		int level = 0;
		List<Tree> list = new ArrayList<Tree>();
		dao.setTree(type);
		
		switch(type) {
			case TreeConstants.CATEGORY :
				list = this.getCategoryChildren(code, list, level);
			break;
			case TreeConstants.BOARD :
				list = this.getCategoryAndBoard(code, list, level);
			break;
			case TreeConstants.MENU :
				list = this.getMenuChildren(code, list, level);
			break;
			default :
				list = this.getCategoryChildren(code, list, level);
			break;
		}
		
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
				_code = _list.get(i).getCateCode();
				tree = new Tree();
				tree.setName(_list.get(i).getCateName());
				tree.setNodeId(Long.toString(_code));
				tree.setParentId(Long.toString(code));
				tree.setHasChild(false);
				tree.setLast(true);
				tree.setLevel(level);
				if(dao.getChildCount(_code)>0 ) {
					tree.setLast(false);
					tree.setHasChild(true);
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
	public List<Tree> getMenuChildren(long code, List<Tree> list, int level) {
		Tree tree = null;
		int _count = dao.getChildCount(code);
		long _code = -1;
		List<Menu> _list = null;
		if(_count>0) {
			_list = dao.getChildren(code);
			for(int i=0; i<_list.size(); i++) {
				_code = _list.get(i).getMenuCode();
				tree = new Tree();
				tree.setName(_list.get(i).getMenuName());
				tree.setNodeId(Long.toString(_code));
				tree.setParentId(Long.toString(code));
				tree.setHasChild(false);
				tree.setLast(true);
				tree.setLevel(level);
				if(dao.getChildCount(_code)>0 ) {
					tree.setLast(false);
					tree.setHasChild(true);
				}
				tree.setLeaf(false);
				list.add(tree);
				if(dao.getChildCount(_code)>0 ) {
					int _level = level+1;
					getMenuChildren(_code, list, _level);
				}
			}
		}
		return list;
	}

	@Override
	public void getBoardChildren(long code, List<Tree> list, int level) {
		Tree tree = null;

		dao.setTree(TreeConstants.BOARD);
		int _count = dao.getChildCount(code);
		List<Board> _list = null;

		if(_count>0) {
			_list = dao.getChildren(code);
			for(int i=0; i<_list.size(); i++) {
				tree = new Tree();
				tree.setName(_list.get(i).getBoardName());
				tree.setNodeId(Long.toString(_list.get(i).getBoardCode()));
				tree.setHasChild(false);
				tree.setParentId(Long.toString(code));
				tree.setLast(true);
				tree.setLevel(level+1);
				tree.setLeaf(true);
				list.add(tree);
			}
		}
		dao.setTree(TreeConstants.CATEGORY);
	}

	@Override
	public List<Tree> getCategoryAndBoard(long code, List<Tree> list, int level) {
		dao.setTree(TreeConstants.CATEGORY);
		Tree tree = null;
		int _count = dao.getChildCount(code);
		long _code = -1;
		List<Category> _list = null;
		if(_count>0) {
			_list = dao.getChildren(code);
			for(int i=0; i<_list.size(); i++) {

				_code = _list.get(i).getCateCode();
				tree = new Tree();
				tree.setName(_list.get(i).getCateName());
				tree.setNodeId(Long.toString(_code));
				tree.setParentId(Long.toString(code));
				tree.setHasChild(false);
				tree.setLast(true);
				tree.setLevel(level);
				if(dao.getChildCount(_code)>0 ) {
					tree.setLast(false);
					tree.setHasChild(true);
				}
				tree.setLeaf(false);
				list.add(tree);
				
				this.getBoardChildren(_code, list, level);
				
				if(dao.getChildCount(_code)>0 ) {
					int _level = level+1;
					getCategoryAndBoard(_code, list, _level);
				}
			}
		}
		return list;
	}
	
	

}
