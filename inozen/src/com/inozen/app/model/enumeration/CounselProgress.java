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
				new Pair(REG, "�����Ϸ�"), 
				new Pair(DIRECT, "�� �� ��"),
				new Pair(EXCLUSION, "�� ��"),
				new Pair(EXAMINATION, "�� �� ��"),
				new Pair(COMPLETION, "�亯�Ϸ�")
			)
		);
	}
	
	private static CounselProgress counselProgress = new CounselProgress();

	public static CounselProgress getInstance() {
		return counselProgress;
	}

}
