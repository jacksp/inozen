package com.inozen.app.common.seq.dao;

import java.util.List;

import com.inozen.app.common.seq.support.SequenceParams;
import com.inozen.app.model.Sequence;
import com.inozen.framework.data.hibernate.HibernateGenericDao;

public class SequenceDaoImpl extends HibernateGenericDao<Sequence, SequenceParams> implements SequenceDao{

	@SuppressWarnings("unchecked")
	@Override
	public long getSequence(String kind, String type) {
		long _seqNo = 0l;
		List<Long> _list =
		getSession().createQuery("select max(seq_no) from tbl_sequence where seq_kind=:seq_kind and seq_type=:seq_type")
		.setParameter("seq_kind", kind).setParameter("seq_type", type).list();
		
		if(null!=_list.get(0)) _seqNo = Long.parseLong(_list.get(0).toString());
		else _seqNo = 0l;
		return _seqNo;
	}
	
}
