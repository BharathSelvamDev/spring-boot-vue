package io.api.model;

public class Task {

	private int taskId;
	private String task;
	private boolean active;
	private boolean removed;

	public Task() {
		super();
	}

	public Task(int taskId, String task, boolean active, boolean removed) {
		super();
		this.taskId = taskId;
		this.task = task;
		this.active = active;
		this.removed = removed;
	}

	public int getTaskId() {
		return taskId;
	}

	public void setTaskId(int taskId) {
		this.taskId = taskId;
	}

	public String getTask() {
		return task;
	}

	public void setTask(String task) {
		this.task = task;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	public boolean isRemoved() {
		return removed;
	}

	public void setRemoved(boolean removed) {
		this.removed = removed;
	}

}
