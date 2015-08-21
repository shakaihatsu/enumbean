package net.shakaihatsu.devforum.api;

import net.shakaihatsu.devforum.domain.Task;

public interface TaskProcessor {
	int processTask(Task task);
}
