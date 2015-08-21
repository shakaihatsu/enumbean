package com.lhsystems.ri.devforum.solution.enumbean.di;

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
public class EnumBeanDIIT {
	@Inject
	@Main
	private TaskProcessor taskProcessor;
	
	@Test
	public void shouldProcessTaskReturn1WhenStatusIsNew() throws Exception {
		// GIVEN
		Task task = new Task(Status.NEW);
		int expected = 1;
		
		// WHEN
		int actual = taskProcessor.processTask(task);
		
		// THEN
		Assert.assertEquals(expected, actual);
	}
	
	@Test
	public void shouldProcessTaskReturn4WhenStatusIsFailed() throws Exception {
		// GIVEN
		Task task = new Task(Status.FAILED);
		int expected = 4;
		
		// WHEN
		int actual = taskProcessor.processTask(task);
		
		// THEN
		Assert.assertEquals(expected, actual);
	}
	
	@Test
	public void shouldProcessTaskReturn9WhenStatusIsSuccessful() throws Exception {
		// GIVEN
		Task task = new Task(Status.SUCCESSFUL);
		int expected = 9;
		
		// WHEN
		int actual = taskProcessor.processTask(task);
		
		// THEN
		Assert.assertEquals(expected, actual);
	}
	
	@Ignore // Ignored to test unit/integration test coverage difference
	@Test
	public void shouldProcessTaskReturn16WhenStatusIsCanceled() throws Exception {
		// GIVEN
		Task task = new Task(Status.CANCELED);
		int expected = 16;
		
		// WHEN
		int actual = taskProcessor.processTask(task);
		
		// THEN
		Assert.assertEquals(expected, actual);
	}
}
