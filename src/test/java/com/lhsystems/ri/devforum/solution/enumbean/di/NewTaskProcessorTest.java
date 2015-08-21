package com.lhsystems.ri.devforum.solution.enumbean.di;

import net.shakaihatsu.devforum.domain.Task;
import net.shakaihatsu.devforum.solution.enumbean.di.NewTaskProcessor;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class NewTaskProcessorTest {
	private NewTaskProcessor testSubject;
	
	@Before
	public void setUp() {
		testSubject = new NewTaskProcessor();
	}
	
	@Test
	public void shouldReturn1() {
		// GIVEN
		Task task = null;
		int expected = 1;
		
		// WHEN
		int actual = testSubject.processTask(task);
		
		// THEN
		Assert.assertEquals(expected, actual);
	}
}
