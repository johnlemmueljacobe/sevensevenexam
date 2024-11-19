package com.sevensevenexam.java;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

import sevensevenexam.model.Task;

public class Scheduler {

	public Map<Task, LocalDate[]> calculateSchedule(Project project, LocalDate startDate) {

		Map<Task, LocalDate[]> schedule = new HashMap<>();
		Map<Task, Integer> inDegree = new HashMap<>();
		Map<Task, List<Task>> graph = new HashMap<>();

		for (Task task : project.getTasks()) {
			inDegree.put(task, 0);
			graph.put(task, new ArrayList<>());

		}
		for (Task task : project.getTasks()) {
			for (Task dependency : task.getDependencies()) {
				graph.get(dependency).add(task);
				inDegree.put(task, inDegree.get(task) + 1);

			}

		}
		Queue<Task> queue = new LinkedList<>();
		for (Task task : project.getTasks()) {
			if (inDegree.get(task) == 0) {
				queue.add(task);
			}
		}
		LocalDate currentStartDate = startDate;
		while (!queue.isEmpty()) {
			Task currentTask = queue.poll();
			LocalDate endDate = currentStartDate.plusDays(currentTask.getDuration());
			schedule.put(currentTask, new LocalDate[] { currentStartDate, endDate });
			for (Task dependent : graph.get(currentTask)) {
				inDegree.put(dependent, inDegree.get(dependent) - 1);
				if (inDegree.get(dependent) == 0) {
					currentStartDate = endDate;
					queue.add(dependent);
				}

			}

		}
		return schedule;
	}
}
