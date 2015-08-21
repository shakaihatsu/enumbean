package net.shakaihatsu.devforum.solution.enumbean.simple;

import net.shakaihatsu.devforum.api.TaskProcessor;
import net.shakaihatsu.devforum.domain.Task;

public class SuccessfulTaskProcessor implements TaskProcessor {
	@Override
	public int processTask(Task task) {
		System.out.println("EnumBean: Archiving " + task);
		
		return 3;
	}
}
