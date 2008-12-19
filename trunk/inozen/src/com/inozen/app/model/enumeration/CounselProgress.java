package com.inozen.app.model.enumeration;

import java.util.Arrays;

import com.inozen.framework.enumeration.AbstractType;
import com.inozen.framework.enumeration.Pair;

public class CounselProgress extends AbstractType {
	public static final String REG = "00";
	public static final String DIRECT = "01";
	public static final String EXCLUSION = "02";
	public static final String EXAMINATION = "03";
	public static final String COMPLETION = "04";
	
	public CounselProgress() {
		super(Arrays.asList(
				new Pair(REG, "접수완료"), 
				new Pair(DIRECT, "검 토 중"),
				new Pair(EXCLUSION, "제 외"),
				new Pair(EXAMINATION, "검 토 중"),
				new Pair(COMPLETION, "답변완료")
			)
		);
	}
	
	private static CounselProgress counselProgress = new CounselProgress();

	public static CounselProgress getInstance() {
		return counselProgress;
	}

}
