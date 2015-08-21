package net.shakaihatsu.devforum.solution.prelude;

import net.shakaihatsu.devforum.api.TaskProcessor;
import net.shakaihatsu.devforum.domain.Task;

public class TaskProcessorImpl implements TaskProcessor {
	@Override
	public int processTask(Task task) {
		int result;
		
		int partialResult;
		
		switch (task.getStatus()) {
		case NEW:
			partialResult = execute(task);
			break;
		case FAILED:
			partialResult = retry(task);
			break;
		case SUCCESSFUL:
			partialResult = archive(task);
			break;
		case CANCELED:
			partialResult = delete(task);
			break;
		default:
			partialResult = 0;
			break;
		}
		
		result = partialResult * partialResult;
		
		return result;
	}

	private int execute(Task task) {
		System.out.println("Prelude: Executing " + task);
		
		return 1;
	}

	private int retry(Task task) {
		System.out.println("Prelude: Retrying " + task);
		
		return 2;
	}

	private int archive(Task task) {
		System.out.println("Prelude: Archiving " + task);
		
		return 3;
	}

	private int delete(Task task) {
		System.out.println("Prelude: Deleting " + task);
		
		return 4;
	}
}
