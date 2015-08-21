package net.shakaihatsu.devforum.runner;

import net.shakaihatsu.devforum.api.TaskProcessor;
import net.shakaihatsu.devforum.domain.Status;
import net.shakaihatsu.devforum.domain.Task;
import net.shakaihatsu.devforum.solution.extendedenum.TaskProcessorImpl;

public class ExtendedEnumRunner {
	private static TaskProcessor taskProcessor = new TaskProcessorImpl();
	private static Task task = new Task(Status.CANCELED);
	
	public static void main(String[] args) {
		int result = taskProcessor.processTask(task);
		
		System.out.println(result);
	}
}
