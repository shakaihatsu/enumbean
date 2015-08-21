package com.lhsystems.ri.devforum.solution.enumbean.di;

import net.shakaihatsu.devforum.domain.Task;
import net.shakaihatsu.devforum.solution.enumbean.di.FailedTaskProcessor;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class FailedTaskProcessorTest {
	private FailedTaskProcessor testSubject;
	
	@Before
	public void setUp() {
		testSubject = new FailedTaskProcessor();
	}
	
	@Test
	public void shouldReturn2() {
		// GIVEN
		Task task = null;
		int expected = 2;
		
		// WHEN
		int actual = testSubject.processTask(task);
		
		// THEN
		Assert.assertEquals(expected, actual);
	}
}
