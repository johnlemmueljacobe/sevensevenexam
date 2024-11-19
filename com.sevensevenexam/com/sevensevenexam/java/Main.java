package com.sevensevenexam.java;

import java.time.LocalDate;
import java.util.Map;

import sevensevenexam.model.Task;

public class Main {

	public static void main(String[] args) {
		Project project = new Project();
		Task taskA = new Task("Task A", 3);
		Task taskB = new Task("Task B", 2);
		Task taskC = new Task("Task C", 1);
		Task taskD = new Task("Task D", 4);


		taskB.addDependency(taskA);
		taskC.addDependency(taskA);
		taskD.addDependency(taskB);
		taskD.addDependency(taskC);

		project.addTask(taskA);
		project.addTask(taskB);
		project.addTask(taskC);
		project.addTask(taskD);

		Scheduler scheduler = new Scheduler();

		Map<Task, LocalDate[]> schedule = scheduler.calculateSchedule(project, LocalDate.now());
		for (Map.Entry<Task, LocalDate[]> entry : schedule.entrySet()) {
			Task task = entry.getKey();
			LocalDate[] dates = entry.getValue();
			System.out.println(task.getName() + ": Start Date = " + dates[0] + ", End Date = " + dates[1]);

		}
	}

}
