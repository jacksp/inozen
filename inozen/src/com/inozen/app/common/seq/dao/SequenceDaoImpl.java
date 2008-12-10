package com.inozen.app.common.seq.dao;

import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.inozen.app.common.seq.support.SequenceParams;
import com.inozen.app.model.Sequence;
import com.inozen.framework.data.hibernate.HibernateGenericDao;

@Repository
public class SequenceDaoImpl extends HibernateGenericDao<Sequence, SequenceParams> implements SequenceDao{

	@SuppressWarnings("unchecked")
	@Override
	public long getSequence(String kind, String type) {
		long _seqNo = 0l;
		List<Long> _list =
		getSession().createQuery("select max(a.seqNo) from tbl_sequence a where a.seqKind=:seq_kind and a.seqType=:seq_type")
		.setParameter("seq_kind", kind).setParameter("seq_type", type).list();
		
		if(null!=_list.get(0)) _seqNo = Long.parseLong(_list.get(0).toString());
		else _seqNo = 0l;
		return _seqNo;
	}

	@Override
	public void updateSequence(String kind, String type, long seqNo) {
		StringBuffer sql = new StringBuffer();
		sql.append("update tbl_sequence ");
		sql.append("	set seq_no=:seq_no, ");
		sql.append("		created_date=:created_date ");
		sql.append("	where seq_kind=:seq_kind ");
		sql.append("		and seq_type=:seq_type ");
		getSession().createQuery(sql.toString())
		.setParameter("seq_no", seqNo)
		.setParameter("created_date", new Date())
		.setParameter("seq_kind", kind)
		.setParameter("seq_type", type).executeUpdate();
		
	}

}
