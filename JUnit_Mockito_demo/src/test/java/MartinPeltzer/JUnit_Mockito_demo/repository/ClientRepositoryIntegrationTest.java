package MartinPeltzer.JUnit_Mockito_demo.repository;


import MartinPeltzer.JUnit_Mockito_demo.JUnitMockitoDemoApplication;
import MartinPeltzer.JUnit_Mockito_demo.model.Client;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.ContextConfiguration;

@DataJpaTest
@ContextConfiguration(classes={JUnitMockitoDemoApplication.class}) //Die test je!
public class ClientRepositoryIntegrationTest {

    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private ClientRepository clientRepository;

    @Test
    void testFindByLastLast() {
        // given
        Client customer = new Client("Suzanne", "Kruizens");
        entityManager.persist(customer);
        entityManager.flush();

        // when
        Client found = clientRepository.findByLastName(customer.getLastName());

        // then
        String expected = "Suzanne Kruizens";
        String actual = found.getFullName();
        assertEquals(expected, actual);
    }
}
