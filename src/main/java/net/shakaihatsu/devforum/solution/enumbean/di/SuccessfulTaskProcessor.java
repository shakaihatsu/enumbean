package net.shakaihatsu.devforum.solution.enumbean.di;

import javax.inject.Named;

import net.shakaihatsu.devforum.api.TaskProcessor;
import net.shakaihatsu.devforum.domain.Task;
import net.shakaihatsu.devforum.solution.enumbean.AbstractEnumBean;

@Named
public class SuccessfulTaskProcessor extends AbstractEnumBean<TaskProcessor, StatusExtender> implements TaskProcessor {
	@Override
	public int processTask(Task task) {
		System.out.println("EnumBean: Archiving " + task);
		
		return 3;
	}

	@Override
	public StatusExtender getCorrespondingEnumElement() {
		return StatusExtender.SUCCESSFUL;
	}
}
