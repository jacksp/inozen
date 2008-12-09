package com.inozen.app.common.seq.service;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.inozen.app.common.seq.dao.SequenceDao;
import com.inozen.app.common.seq.support.SequenceParams;
import com.inozen.app.model.Sequence;
import com.inozen.framework.service.impl.GenericServiceImpl;

@Service
@Transactional
public class SequenceServiceImpl extends GenericServiceImpl<Sequence, SequenceDao, SequenceParams> implements SequenceService {
	@Autowired
	protected SequenceDao dao;
	protected Sequence entity;
	
	protected SequenceServiceImpl() {
		super(SequenceDao.class);
	}

	protected SequenceServiceImpl(Class<SequenceDao> persistentClass) {
		super(persistentClass);
	}

	@Override
	public long getSequence(String kind, String type) {
		long retVal = -1l;
		retVal = dao.getSequence(kind, type);
		if(retVal==0l) {
			retVal = 1l;
			this.insertSequence(kind, type, retVal);
		}else{
			retVal++;
			this.updateSequence(kind, type, retVal);
		}
		return retVal;
	}

	@Override
	public void insertSequence(String kind, String type, long retVal) {
		entity = new Sequence();
		entity.setCreatedDate(new Date());
		entity.setSeqKind(kind);
		entity.setSeqType(type);
		entity.setSeqNo(retVal);
	
		dao.save(entity);
	}

	@Override
	public void updateSequence(String kind, String type, long retVal) {
		dao.updateSequence(kind, type, retVal);
	}

}
