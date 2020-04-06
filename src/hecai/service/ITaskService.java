package hecai.service;

import hecai.entity.Task;

public interface ITaskService {
	
	/**
	 * 添加任务
	 * @param task 
	 * @return 受影响的行数
	 */
	public int AddTask(String date);
	
}
