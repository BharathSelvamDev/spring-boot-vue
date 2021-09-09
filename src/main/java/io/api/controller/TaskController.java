package io.api.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import io.api.model.Task;
import io.api.services.TaskService;


@CrossOrigin
@RestController
public class TaskController {

	@Autowired 
	TaskService taskService;

	@GetMapping("/gettasks")
	public List<Task> getAllTask() {
		List<Task> tasks = new ArrayList<Task>();
		List<Task> responseTasks = new ArrayList<Task>();
		tasks = taskService.getAllPersons();
		for (Task task : tasks) {
			if (task.isRemoved() == false) {
				responseTasks.add(task);
			}
		}
		return responseTasks;
	} 
	
	@PostMapping("/addtasks/{task}")
	public String AddTask(@PathVariable("task") String task) {
		System.out.println(task);
		Task newTask = new Task(taskService.generateUniqueId(), task , true , false);
		String response = taskService.AddTask(newTask);
		return response;
	}
	
	@PostMapping("/deletetasks/{id}")
	public String DeleteTask(@PathVariable("id") int id) {
		String response =taskService.DeleteTask(id);
		return response; 
	}
	@PostMapping("/updatetask/{ids}/{name}")
	public String UpdatePerson(@PathVariable("ids") int ids, @PathVariable("name") String name) {
		
		String response = taskService.UpdateTask(ids , name);
		return response;
	}
	 
	@PostMapping("/comtask/{id}")
	public String CompleteTask(@PathVariable("id") int id) {
		String response =taskService.CompleteTask(id);
		return response;
	}
	
	@PostMapping("/icomtask/{id}")
	public String ICompleteTask(@PathVariable("id") int id) {
		String response =taskService.InCompleteTask(id);
		return response;
	}
}
