package dao;

import models.Client;

public interface ClientDao {
	public Client findById(Integer id);
	public Client findByEmail(String emailid);
	public void create(Client client);
}
