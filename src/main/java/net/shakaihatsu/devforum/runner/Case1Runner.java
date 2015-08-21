package net.shakaihatsu.devforum.runner;

import net.shakaihatsu.devforum.solution.case1.Status;
import net.shakaihatsu.devforum.solution.case1.Task;
import net.shakaihatsu.devforum.solution.case1.TaskProcessor;
import net.shakaihatsu.devforum.solution.case1.TaskProcessorImpl;


public class Case1Runner {
	private static TaskProcessor taskProcessor = new TaskProcessorImpl();
	private static Task task = new Task(Status.CANCELED);
	
	public static void main(String[] args) {
		int result = taskProcessor.processTask(task);
		
		System.out.println(result);
	}
}
