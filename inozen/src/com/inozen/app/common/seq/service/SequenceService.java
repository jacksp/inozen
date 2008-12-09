package com.inozen.app.common.seq.service;

import com.inozen.app.common.seq.dao.SequenceDao;
import com.inozen.app.common.seq.support.SequenceParams;
import com.inozen.app.model.Sequence;
import com.inozen.framework.service.GenericService;

public interface SequenceService extends GenericService<Sequence, SequenceDao, SequenceParams>{
	long getSequence(String kind, String type);
	
	void insertSequence(String kind, String type, long retVal);
	
	void updateSequence(String kind, String type, long retVal);
}
