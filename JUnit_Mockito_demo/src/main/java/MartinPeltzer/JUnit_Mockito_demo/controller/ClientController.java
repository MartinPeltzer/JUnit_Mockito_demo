package MartinPeltzer.JUnit_Mockito_demo.controller;

//
//
import MartinPeltzer.JUnit_Mockito_demo.model.Client;
import MartinPeltzer.JUnit_Mockito_demo.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/clients")
public class ClientController {

    @Autowired
    ClientService clientService;

    @GetMapping(value = "")
    public ResponseEntity<Object> getCustomers() {
        return ResponseEntity.ok().body(clientService.getAllClients());
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Object> getCustomer(@PathVariable long id) {
        return ResponseEntity.ok().body(clientService.getClient(id));
    }

    @PostMapping(value = "")
    public ResponseEntity<Object> createClient(@RequestBody Client client) {
        return ResponseEntity.ok().body(clientService.createClient(client));
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<Object> updateClient(@PathVariable long id, @RequestBody Client client) {
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Object> deleteClient(@PathVariable long id) {
        return ResponseEntity.noContent().build();
    }
}
//Nu