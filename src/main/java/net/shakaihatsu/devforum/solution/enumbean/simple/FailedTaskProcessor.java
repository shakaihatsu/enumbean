package net.shakaihatsu.devforum.solution.enumbean.simple;

import net.shakaihatsu.devforum.api.TaskProcessor;
import net.shakaihatsu.devforum.domain.Task;

public class FailedTaskProcessor implements TaskProcessor {
	@Override
	public int processTask(Task task) {
		System.out.println("EnumBean: Retrying " + task);
		
		return 2;
	}
}
