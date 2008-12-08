package com.inozen.app.task;

import com.inozen.framework.web.GenericController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.inozen.app.model.Task;
import com.inozen.app.task.support.TaskParams;
import com.inozen.app.task.support.TaskRef;
import com.inozen.app.task.support.TaskValidator;

@Controller
@RequestMapping("/task/*.do")
public class TaskController extends GenericController<Task, TaskService, TaskRef, TaskValidator, TaskParams>{

	protected TaskController() {
		super(Task.class, TaskService.class, TaskRef.class, TaskValidator.class);
		this.order = "name asc";
	}
}
