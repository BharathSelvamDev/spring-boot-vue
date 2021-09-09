package io.api.services;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Service;

import io.api.model.Task;

@Service
public class TaskService {

	ArrayList<Task> tasks = new ArrayList<Task>();

	public TaskService() {

		tasks.add(new Task(generateUniqueId(), "Buy Apples", true, false));
		tasks.add(new Task(generateUniqueId(), "Buy Oranges", true, false));
		tasks.add(new Task(generateUniqueId(), "Buy Tomatos", true, false));
		tasks.add(new Task(generateUniqueId(), "Buy Bananas", true, false));
		tasks.add(new Task(generateUniqueId(), "Buy Watermelon", true, false));

	}

	public List<Task> getAllPersons() { 
		return tasks;
	}

	public String AddTask(Task newTask) {
		try {
			System.out.println("Before" + tasks.size());
			tasks.add(newTask);
			System.out.println("Atfter" + tasks.size());
			return "Added";
		} catch (Exception e) {
			return "Not Added";
		}
	}

	public int generateUniqueId() {
		UUID idOne = UUID.randomUUID();
		String str = "" + idOne;
		int uid = str.hashCode();
		String filterStr = "" + uid;
		str = filterStr.replaceAll("-", "");
		return Integer.parseInt(str.substring(0, 6));
	}

	public String DeleteTask(int id) {
		for (Task task : tasks) {
			if(task.getTaskId() == id) {
				task.setRemoved(true);
			}
		}
		return "Removed";
	}

	public String CompleteTask(int id) {
		for (Task task : tasks) { 
			if(task.getTaskId() == id) {
				task.setActive(false);
			}
		}
		return "Marked as Completed";
	}
	public String InCompleteTask(int id) {
		for (Task task : tasks) { 
			if(task.getTaskId() == id) {
				task.setActive(true);
			}
		}
		return "Marked as InCompleted";
	}

	public String UpdateTask(int ids, String name) {
		for (Task task : tasks) {
			if(task.getTaskId() == ids) {
				task.setTask(name);
			}
		}
		return "Updated";
	}

}
