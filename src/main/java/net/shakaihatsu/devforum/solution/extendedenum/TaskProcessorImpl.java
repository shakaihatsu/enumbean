package net.shakaihatsu.devforum.solution.extendedenum;

import net.shakaihatsu.devforum.api.TaskProcessor;
import net.shakaihatsu.devforum.domain.Task;

public class TaskProcessorImpl implements TaskProcessor {
	@Override
	public int processTask(Task task) {
		int result;
		
		int partialResult = StatusExtender.valueOf(task.getStatus()).processTask(task);
		
		result = partialResult * partialResult;
		
		return result;
	}

}
