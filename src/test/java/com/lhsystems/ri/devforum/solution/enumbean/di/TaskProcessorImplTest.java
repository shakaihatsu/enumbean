package com.lhsystems.ri.devforum.solution.enumbean.di;

import java.util.Map;

import net.shakaihatsu.devforum.api.TaskProcessor;
import net.shakaihatsu.devforum.domain.Status;
import net.shakaihatsu.devforum.domain.Task;
import net.shakaihatsu.devforum.solution.enumbean.di.StatusExtender;
import net.shakaihatsu.devforum.solution.enumbean.di.TaskProcessorImpl;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import com.lhsystems.ri.devforum.solution.enumbean.EnumBeanTestUtil;

public class TaskProcessorImplTest {
	private TaskProcessorImpl testSubject;
	
	private Map<StatusExtender, TaskProcessor> statusExtenderToTaskProcessorBean;
	
	@Before
	public void setUp() {
		testSubject = new TaskProcessorImpl();
		
		statusExtenderToTaskProcessorBean = EnumBeanTestUtil.initBeanHolderEnumAndCreateEnumToMockMap(StatusExtender.class, TaskProcessor.class);
	}
	
	@Test
	public void shouldProcessTaskCallBeanWhenStatusIsCanceled() {
		// GIVEN
		Status status = Status.CANCELED;
		int partialResult = 10;
		int expected = 100;
		
		Task task = new Task(status);
		Mockito.when(statusExtenderToTaskProcessorBean.get(StatusExtender.valueOf(status)).processTask(task)).thenReturn(partialResult);
		
		// WHEN
		int actual = testSubject.processTask(task);
		
		// THEN
		Assert.assertEquals(expected, actual);
	}
	
	@Test
	public void shouldProcessTaskCallBean() {
		for (Status status : Status.values()) {
			// GIVEN
			int partialResult = 13;
			int expected = 169;
			
			Task task = new Task(status);
			Mockito.when(statusExtenderToTaskProcessorBean.get(StatusExtender.valueOf(status)).processTask(task)).thenReturn(partialResult);
			
			// WHEN
			int actual = testSubject.processTask(task);
			
			// THEN
			Assert.assertEquals(expected, actual);
		}	
	}
}
