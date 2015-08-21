package net.shakaihatsu.devforum.solution.enumbean.di;

import javax.inject.Named;

import net.shakaihatsu.devforum.api.TaskProcessor;
import net.shakaihatsu.devforum.domain.Task;
import net.shakaihatsu.devforum.solution.enumbean.AbstractEnumBean;

@Named
public class CanceledTaskProcessor extends AbstractEnumBean<TaskProcessor, StatusExtender> implements TaskProcessor {
	@Override
	public int processTask(Task task) {
		System.out.println("EnumBean: Deleting " + task);
		
		return 4;
	}

	@Override
	public StatusExtender getCorrespondingEnumElement() {
		return StatusExtender.CANCELED;
	}
}
