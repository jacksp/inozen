package com.inozen.app.board.support;

import org.springframework.stereotype.Component;

import com.inozen.app.model.enumeration.CounselProgress;

/**
 * @author seokhoon
 */
@Component
public class ContentRef {
	public CounselProgress getCounselProgress() {
		return CounselProgress.getInstance();
	}
}
