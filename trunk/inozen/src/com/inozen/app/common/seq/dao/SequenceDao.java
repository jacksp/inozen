package com.inozen.app.common.seq.dao;

import com.inozen.app.common.seq.support.SequenceParams;
import com.inozen.app.model.Sequence;
import com.inozen.framework.data.hibernate.HibernateDao;

public interface SequenceDao extends HibernateDao<Sequence, SequenceParams>{
	long getSequence(String kind, String type);
}
