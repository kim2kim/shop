package com.shop.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="task_list")
public class Task {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="task_id")
	private int id;
	
	@Column(name="task_name")
	private String taskName;
	
	@Column(name="task_description")
	private String taskDescription;
	
	@Column(name="task_priority")
	private String taskPriority;
	
	@Column(name="task_status")
	private String taskStatus;
	
	@Column(name = "task_archived")
	private int taskArchived = 0;
	
	public int getTaskId(){
		return id;
	}
	
	public void setTaskId(int taskId){
		this.id = taskId;
	}

	public String getTaskName() {
		return taskName;
	}

	public void setTaskName(String taskName) {
		this.taskName = taskName;
	}

	public String getTaskDescription() {
		return taskDescription;
	}

	public void setTaskDescription(String taskDescription) {
		this.taskDescription = taskDescription;
	}

	public String getTaskPriority() {
		return taskPriority;
	}

	public void setTaskPriority(String taskPriority) {
		this.taskPriority = taskPriority;
	}

	public String getTaskStatus() {
		return taskStatus;
	}

	public void setTaskStatus(String taskStatus) {
		this.taskStatus = taskStatus;
	}

	public int getTaskArchived() {
		return taskArchived;
	}

	public void setTaskArchived(int taskArchived) {
		this.taskArchived = taskArchived;
	}
	
	@Override
	public String toString(){
		return "Task [id=" + id + ", taskName=" + taskName
				    + ", taskDescription=" + taskDescription + ", taskPriority="
				    + taskPriority + ",taskStatus=" + taskStatus + "]";
	}
	
}
