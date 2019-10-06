package com.sweelam.tdd.car;

import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.Test;

public class FerrariTest {
	private Car myFerrari = mock(Car.class);

	@Test
	public void testStubbing() {
		when(myFerrari.needFuel()).thenReturn(true);

		assertTrue("The car needs Fuel", myFerrari.needFuel());
	}

	@Test
	public void driveToShouldSheckNeedFuel() {
		Car ferrari = mock(Ferrari.class);

		ferrari.driveTo("Helwan");
		verify(ferrari, times(1)).driveTo("Helwan");
	}
}
