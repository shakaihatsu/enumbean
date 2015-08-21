package com.lhsystems.ri.devforum.solution.enumbean.di;

import net.shakaihatsu.devforum.domain.Task;
import net.shakaihatsu.devforum.solution.enumbean.di.CanceledTaskProcessor;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class CanceledTaskProcessorTest {
	private CanceledTaskProcessor testSubject;
	
	@Before
	public void setUp() {
		testSubject = new CanceledTaskProcessor();
	}
	
	@Test
	public void shouldReturn4() {
		// GIVEN
		Task task = null;
		int expected = 4;
		
		// WHEN
		int actual = testSubject.processTask(task);
		
		// THEN
		Assert.assertEquals(expected, actual);
	}
}
