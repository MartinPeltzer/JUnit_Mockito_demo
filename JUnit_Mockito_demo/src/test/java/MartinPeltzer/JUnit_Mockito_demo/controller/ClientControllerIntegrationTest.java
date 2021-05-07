package MartinPeltzer.JUnit_Mockito_demo.controller;


import MartinPeltzer.JUnit_Mockito_demo.JUnitMockitoDemoApplication;
import MartinPeltzer.JUnit_Mockito_demo.model.Client;
import MartinPeltzer.JUnit_Mockito_demo.service.ClientService;
import org.junit.jupiter.api.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.is;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@WebMvcTest
@ContextConfiguration(classes={JUnitMockitoDemoApplication.class})
public class ClientControllerIntegrationTest {

    @Autowired
    private MockMvc mvc;

    @MockBean
    private ClientService service;

    @Test
    public void testEndpointClients() throws Exception {

        Client client = new Client("Albert", "Einstein");

        List<Client> allClients = Arrays.asList(client);

        given(service.getAllClients()).willReturn(allClients);

        mvc.perform(get("/clients")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(1)))
                .andExpect(jsonPath("$[0].lastName", is(client.getLastName())));
    }

}
