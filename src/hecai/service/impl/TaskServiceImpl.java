package hecai.service.impl;

import hecai.entity.Task;
import hecai.mapper.TaskMapper;
import hecai.service.ITaskService;

public class TaskServiceImpl implements ITaskService{

	private TaskMapper taskMapper;
	
	public TaskMapper getTaskMapper() {
		return taskMapper;
	}

	public void setTaskMapper(TaskMapper taskMapper) {
		this.taskMapper = taskMapper;
	}

	@Override
	public int AddTask(String date) {
		return taskMapper.addTask(date);
	}

}
