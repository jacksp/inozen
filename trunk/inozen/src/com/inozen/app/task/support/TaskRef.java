package com.inozen.app.task.support;

import org.springframework.stereotype.Component;

import com.inozen.app.model.enumeration.TaskType;

/**
 * �˻� �� �信�� ������ ������ ������ �����մϴ�.
 * @author seokhoon
 */
@Component
public class TaskRef {

	public TaskType getTaskType(){
		return TaskType.getInstance();
	}
	
}
