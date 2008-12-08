package com.inozen.app.common.seq.service;

import com.inozen.app.common.seq.dao.SequenceDao;
import com.inozen.app.common.seq.support.SequenceParams;
import com.inozen.app.model.Sequence;
import com.inozen.framework.service.impl.GenericServiceImpl;

public class SequenceServiceImpl extends GenericServiceImpl<Sequence, SequenceDao, SequenceParams> implements SequenceService {
	protected SequenceDao dao;
	protected Sequence entity;

	protected SequenceServiceImpl(Class<SequenceDao> persistentClass) {
		super(persistentClass);
		// TODO Auto-generated constructor stub
	}

	@Override
	public long getSequence(String kind, String type) {
		dao.getSequence(kind, type);
		return 0;
	}

	@Override
	public long insertSequence(String kind, String type, long retVal) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public long updateSequence(String kind, String type, long retVal) {
		// TODO Auto-generated method stub
		return 0;
	}

}
