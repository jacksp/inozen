package com.inozen.app.task;

import com.inozen.framework.service.impl.GenericServiceImpl;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.inozen.app.model.Task;
import com.inozen.app.task.support.TaskParams;

@Service
@Transactional
public class TaskServiceImpl extends GenericServiceImpl<Task, TaskDao, TaskParams> implements TaskService {

	public TaskServiceImpl() {
		super(TaskDao.class);
	}

}
