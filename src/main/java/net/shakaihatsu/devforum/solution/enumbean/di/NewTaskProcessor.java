package net.shakaihatsu.devforum.solution.enumbean.di;

import javax.annotation.PostConstruct;
import javax.inject.Named;

import net.shakaihatsu.devforum.api.TaskProcessor;
import net.shakaihatsu.devforum.domain.Task;
import net.shakaihatsu.devforum.solution.enumbean.EnumBean;

@Named
public class NewTaskProcessor implements TaskProcessor, EnumBean<TaskProcessor, StatusExtender>  {
	@PostConstruct
	public void init() {
        getCorrespondingEnumElement().setBean(this);
    }
	
	@Override
	public int processTask(Task task) {
		System.out.println("EnumBean: Executing " + task);
		
		return 1;
	}

	@Override
	public StatusExtender getCorrespondingEnumElement() {
		return StatusExtender.NEW;
	}
}
