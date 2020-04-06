package hecai.entity;
/**
 * 任务实体类
 * @author caihe
 * @date 2019年12月10日下午8:21:05
 */

import java.util.Date;

public class Task {
	
	private int taskId;
	private String taskTitle;
	//工期（天）
	private int taskTime;
	private String taskStartTime;
	private String taskEndTime;
	//任务人Id
	private int userId;
	private String taskPriority;
	private String taskDesc;
	
	
	public Task() {
	}
	public Task(String taskTitle, int taskTime, String taskStartTime, String taskEndTime, int userId,
			String taskPriority, String taskDesc) {
		this.taskTitle = taskTitle;
		this.taskTime = taskTime;
		this.taskStartTime = taskStartTime;
		this.taskEndTime = taskEndTime;
		this.userId = userId;
		this.taskPriority = taskPriority;
		this.taskDesc = taskDesc;
	}
	public Task(int taskId, String taskTitle, int taskTime, String taskStartTime, String taskEndTime, int userId,
			String taskPriority, String taskDesc) {
		this.taskId = taskId;
		this.taskTitle = taskTitle;
		this.taskTime = taskTime;
		this.taskStartTime = taskStartTime;
		this.taskEndTime = taskEndTime;
		this.userId = userId;
		this.taskPriority = taskPriority;
		this.taskDesc = taskDesc;
	}
	public int getTaskId() {
		return taskId;
	}
	public void setTaskId(int taskId) {
		this.taskId = taskId;
	}
	public String getTaskTitle() {
		return taskTitle;
	}
	public void setTaskTitle(String taskTitle) {
		this.taskTitle = taskTitle;
	}
	public int getTaskTime() {
		return taskTime;
	}
	public void setTaskTime(int taskTime) {
		this.taskTime = taskTime;
	}
	public String getTaskStartTime() {
		return taskStartTime;
	}
	public void setTaskStartTime(String taskStartTime) {
		this.taskStartTime = taskStartTime;
	}
	public String getTaskEndTime() {
		return taskEndTime;
	}
	public void setTaskEndTime(String taskEndTime) {
		this.taskEndTime = taskEndTime;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getTaskPriority() {
		return taskPriority;
	}
	public void setTaskPriority(String taskPriority) {
		this.taskPriority = taskPriority;
	}
	public String getTaskDesc() {
		return taskDesc;
	}
	public void setTaskDesc(String taskDesc) {
		this.taskDesc = taskDesc;
	}
	
	@Override
	public String toString() {
		return "Task [taskId=" + taskId + ", taskTitle=" + taskTitle + ", taskTime=" + taskTime + ", taskStartTime="
				+ taskStartTime + ", taskEndTime=" + taskEndTime + ", userId=" + userId + ", taskPriority="
				+ taskPriority + ", taskDesc=" + taskDesc + "]";
	}
	
}
