package net.shakaihatsu.devforum.solution.case1;

public class TaskProcessorImpl implements TaskProcessor {
	public int processTask(Task task) {
		int result;
		
		int partialResult = task.getStatus().processTask(task);
		
		result = partialResult * partialResult;
		
		return result;
	}
}
