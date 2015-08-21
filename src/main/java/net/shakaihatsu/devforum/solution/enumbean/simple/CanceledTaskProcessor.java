package net.shakaihatsu.devforum.solution.enumbean.simple;

import net.shakaihatsu.devforum.api.TaskProcessor;
import net.shakaihatsu.devforum.domain.Task;

public class CanceledTaskProcessor implements TaskProcessor {
	@Override
	public int processTask(Task task) {
		System.out.println("EnumBean: Deleting " + task);
		
		return 4;
	}
}
