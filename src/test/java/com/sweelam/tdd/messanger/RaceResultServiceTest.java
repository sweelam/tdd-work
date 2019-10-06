package com.sweelam.tdd.messanger;

import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import org.junit.Before;
import org.junit.Test;

public class RaceResultServiceTest {
	private RaceResultService raceResult;
	Client clientA = mock(Client.class, "clientA");
	Client clientB = mock(Client.class, "clientB");
	Message message = mock(Message.class);

	@Before
	public void init() {
		raceResult = new RaceResultService();
	}

	@Test
	public void subscribedClientShouldReceiveMessage() {
		raceResult.addSubscriber(clientA);
		raceResult.send(message);

		verify(clientA).receiveMessage(message);
	}

	@Test
	public void messageShouldBeSentToAllSubscribedClients() {
		raceResult.addSubscriber(clientA);
		raceResult.addSubscriber(clientB);
		raceResult.send(message);

		verify(clientA).receiveMessage(message);
		verify(clientB).receiveMessage(message);
	}

	@Test
	public void notSubscibedClientShouldNotReceiveMessage() {
		raceResult.send(message);

		verify(clientA, never()).receiveMessage(message);
		verify(clientB, never()).receiveMessage(message);
	}
	
	@Test
	public void multiSubscribedClientsShouldReceiveOnlyOneMessage() {
		raceResult.addSubscriber(clientA);
		raceResult.addSubscriber(clientA);
		raceResult.send(message);

		verify(clientA, times(1)).receiveMessage(message);
	}
	
	@Test
	public void unsubscribedClientShouldBeRemoved() {
		raceResult.addSubscriber(clientA);
		boolean isRemoved = raceResult.removeSubscriber(clientA);
		assertTrue(isRemoved);
		raceResult.send(message);
		verify(clientA, never()).receiveMessage(message);
	}
}
