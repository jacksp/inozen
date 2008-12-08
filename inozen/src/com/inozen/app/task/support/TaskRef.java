package com.inozen.app.task.support;

import org.springframework.stereotype.Component;

import com.inozen.app.model.enumeration.TaskType;

/**
 * 검색 및 뷰에서 참조할 데이터 집합을 정의합니다.
 * @author seokhoon
 */
@Component
public class TaskRef {

	public TaskType getTaskType(){
		return TaskType.getInstance();
	}
	
}
