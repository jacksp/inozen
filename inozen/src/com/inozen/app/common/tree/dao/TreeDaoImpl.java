package com.inozen.app.common.tree.dao;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projections;

import com.inozen.framework.data.hibernate.CriteriaUtils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.inozen.app.common.tree.domain.Tree;
import com.inozen.app.model.Category;

@Repository
public class TreeDaoImpl implements TreeDao {
	@Autowired
	private SessionFactory sessionFactory;
	
	private static final int CATEGORY = 1;
	
	private String statusFieldName;
	private String pCodeFieldName;
	
	public Session getSession() {
		Session returnSession = sessionFactory.getCurrentSession();
		return returnSession;
	}
	
	private void initializedField(int type) {
		switch(type) {
			case CATEGORY :
				pCodeFieldName = "pCateCode";
				statusFieldName = "cateStatus";
				
			break;
			default :
				pCodeFieldName = "pCateCode";
				statusFieldName = "cateStatus";
			break;
		}
	}

	@Override
	public List<Tree> tree(int type, long code) {
		List<Tree> list = new ArrayList<Tree>();
		this.initializedField(type);
		int level = 0;
		getCategoryChildren(code, list, level);
		return list;
	}

	@Override
	public int getChildCount(long code) {
		Criteria c = getSession().createCriteria(Category.class);
		CriteriaUtils.conditionalEq(c, statusFieldName, "1");
		CriteriaUtils.conditionalEq(c, pCodeFieldName, code);

		int returnint = (Integer) (c.setProjection(Projections.rowCount()).uniqueResult());
		return returnint;
	}

	@Override
	public boolean isEmptyChild(long code) {
		boolean returnboolean = (getChildCount(code) > 0 ? false : true);
		return returnboolean;
	}

	@Override
	public List<Tree> getCategoryChildren(long code, List<Tree> list, int level) {
		Tree tree = null;
		int _count = getChildCount(code);
		long _code = -1;
		List<Category> _list = null;
		if(_count>0) {
			_list = getCategoryChildren(code);
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
				if(getChildCount(_code)>0 ) {
					tree.setLast(false);
				}
				tree.setLeaf(false);
				list.add(tree);
				if(getChildCount(_code)>0 ) {
					level++;
					getCategoryChildren(_code, list, level);
				}
			}
		}
		return list;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Category> getCategoryChildren(long code) {
		Criteria c = getSession().createCriteria(Category.class);
		CriteriaUtils.conditionalEq(c, "cateStatus", "1");
		CriteriaUtils.conditionalEq(c, "pCateCode", code);
		c.addOrder(Order.desc("cateOrder"));
		List<Category> returnList = c.list();
		return returnList;
	}
	
}
