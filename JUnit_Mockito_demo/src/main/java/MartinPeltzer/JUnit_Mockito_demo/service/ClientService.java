package MartinPeltzer.JUnit_Mockito_demo.service;
//


import MartinPeltzer.JUnit_Mockito_demo.model.Client;

import java.util.Collection;
import java.util.Optional;

public interface ClientService {
    Collection<Client> getAllClients();
    Optional<Client> getClient(long id);
    boolean userExists(long id);
    long createClient(Client client);
    void deleteClient(long id);
    void updateClient(long id, Client newClient);
    Client getClientByLastName(String name);
}
