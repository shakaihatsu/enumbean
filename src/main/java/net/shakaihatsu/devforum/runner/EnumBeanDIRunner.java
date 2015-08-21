package net.shakaihatsu.devforum.runner;

import javax.inject.Inject;

import net.shakaihatsu.devforum.api.TaskProcessor;
import net.shakaihatsu.devforum.domain.Status;
import net.shakaihatsu.devforum.domain.Task;
import net.shakaihatsu.devforum.solution.enumbean.di.Main;

import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:META-INF/spring/applicationContext.xml")
public class EnumBeanDIRunner {
	@Inject
	@Main
	private TaskProcessor taskProcessor;
	
	@Test
	public void run() throws Exception {
		Task task = new Task(Status.CANCELED);
		
		int result = taskProcessor.processTask(task);
		
		System.out.println(result);
	}
	
	@Ignore
	@Test
	public void testTaskProcessor() throws Exception {
		// GIVEN
		Task task = new Task(Status.CANCELED);
		int expected = 16;
		
		// WHEN
		int actual = taskProcessor.processTask(task);
		
		// THEN
		Assert.assertEquals(expected, actual);
	}
}
