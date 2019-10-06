package com.sweelam.tdd.messanger;

import java.util.LinkedList;
import java.util.List;

public class RaceResultService {
	private List<Client> clients = new LinkedList<Client>();

	public void addSubscriber(Client client) {
		if (!clients.contains(client))
			clients.add(client);
	}

	public void send(Message message) {
		for (Client client : clients)
			client.receiveMessage(message);
	}

	public boolean removeSubscriber(Client client) {
		return clients.remove(client);
	}

}
