package com.lhsystems.ri.devforum.solution.enumbean.di;

import net.shakaihatsu.devforum.domain.Task;
import net.shakaihatsu.devforum.solution.enumbean.di.SuccessfulTaskProcessor;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class SuccessfulTaskProcessorTest {
	private SuccessfulTaskProcessor testSubject;
	
	@Before
	public void setUp() {
		testSubject = new SuccessfulTaskProcessor();
	}
	
	@Test
	public void shouldReturn3() {
		// GIVEN
		Task task = null;
		int expected = 3;
		
		// WHEN
		int actual = testSubject.processTask(task);
		
		// THEN
		Assert.assertEquals(expected, actual);
	}
}
