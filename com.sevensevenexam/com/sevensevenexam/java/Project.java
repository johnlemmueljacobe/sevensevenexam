package com.sevensevenexam.java;

import java.util.ArrayList;
import java.util.List;

import sevensevenexam.model.Task;

public class Project {
	private List<Task> tasks;

	public Project() {

		this.tasks = new ArrayList<>();

	}

	public void addTask(Task task) {

		tasks.add(task);

	}

	public List<Task> getTasks() {

		return tasks;

	}
}
