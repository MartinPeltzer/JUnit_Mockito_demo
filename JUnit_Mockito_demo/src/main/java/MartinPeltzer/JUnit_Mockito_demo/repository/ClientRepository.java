package MartinPeltzer.JUnit_Mockito_demo.repository;

import MartinPeltzer.JUnit_Mockito_demo.model.Client;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepository extends JpaRepository<Client, Long> {

    public Client findByLastName(String name);

}
