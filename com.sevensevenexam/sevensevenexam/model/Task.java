package sevensevenexam.model;

import java.util.ArrayList;
import java.util.List;

public class Task {
	private String name;

	private int duration;

	private List<Task> dependencies;

	public Task(String name, int duration) {
		this.name = name;
		this.duration = duration;
		this.dependencies = new ArrayList<>();

	}

	public String getName() {
		return name;
	}

	public int getDuration() {
		return duration;
	}

	public List<Task> getDependencies() {
		return dependencies;
	}

	public void addDependency(Task task) {
		dependencies.add(task);
	}

}
