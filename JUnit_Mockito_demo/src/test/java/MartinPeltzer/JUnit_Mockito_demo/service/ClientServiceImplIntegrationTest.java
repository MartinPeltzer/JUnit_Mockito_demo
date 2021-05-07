package MartinPeltzer.JUnit_Mockito_demo.service;




import MartinPeltzer.JUnit_Mockito_demo.JUnitMockitoDemoApplication;
import MartinPeltzer.JUnit_Mockito_demo.model.Client;
import MartinPeltzer.JUnit_Mockito_demo.repository.ClientRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import org.mockito.Mock;
import org.mockito.Mockito;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;



@SpringBootTest()
@ContextConfiguration(classes={JUnitMockitoDemoApplication.class})
public class ClientServiceImplIntegrationTest {

    @Autowired
    private ClientService clientService;

    @MockBean
    private ClientRepository clientRepository;

    @Mock
    Client client;

    @BeforeEach
    public void setUp() {
    }

    @Test
    public void testGetCustomerByLastName() {
        client = new Client("Albert", "Einstein");

        Mockito
                .when(clientRepository.findByLastName(client.getLastName()))
                .thenReturn(client);

        String name = "Einstein";
        String expected = "Albert Einstein";

        Client found = clientService.getClientByLastName(name);

        assertEquals(expected, found.getFullName());
    }

    //Dit voorbeeld geeft een andere volgorde van werken. (02:10:08).Doet hetzelfde
    @Test
    public void testGetCustomerByLastName2() {
        client = new Client("Albert", "Einstein");

        Mockito
                .doReturn(client)
                .when(clientRepository)
                .findByLastName("Einstein");

        String name = "Einstein";
        String expected = "Albert Einstein";

        Client found = clientService.getClientByLastName(name);

        assertEquals(expected, found.getFullName());
    }

    @Test
    void testGetClientByLastNameNotFound() {
        String name = "EinsteinXXX";

        // Setup our mock repository
        Mockito
                .doReturn(null).when(clientRepository)
                .findByLastName(name);

        // Execute the service call
        Client found = clientService.getClientByLastName(name);

        // Assert the response
        assertNull(found, "Widget should not be found");
    }

}
