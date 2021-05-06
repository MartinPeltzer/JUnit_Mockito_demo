package MartinPeltzer.JUnit_Mockito_demo.service;

//
//

import MartinPeltzer.JUnit_Mockito_demo.model.Client;
import MartinPeltzer.JUnit_Mockito_demo.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Optional;

@Service
public class ClientServiceImpl implements ClientService {

    @Autowired
    ClientRepository clientRepository;

    @Override
    public Optional<Client> getClient(long id) {
        return clientRepository.findById(id);
    }

    @Override
    public boolean userExists(long id) {
        return clientRepository.existsById(id);
    }

    @Override
    public long createClient(Client client) {
        Client newClient = clientRepository.save(client);
        return newClient.getId();
    }

    @Override
    public void deleteClient(long id) {
        clientRepository.deleteById(id);
    }

    @Override
    public void updateClient(long id, Client newClient) {
        Client client = clientRepository.findById(id).orElse(null);
        if (client != null) {
            client.setFirstName(newClient.getFirstName());
            client.setLastName(newClient.getLastName());
            client.setDateOfBirth(newClient.getDateOfBirth());
            clientRepository.save(client);
        }
    }

    @Override
    public Collection<Client> getAllClients() {
        return clientRepository.findAll();
    }
    @Override
    public Client getClientByLastName(String name) {
        return clientRepository.findByLastName(name);
    }
}
