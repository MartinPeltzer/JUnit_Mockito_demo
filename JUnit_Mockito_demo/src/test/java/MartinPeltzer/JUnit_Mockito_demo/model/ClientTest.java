package MartinPeltzer.JUnit_Mockito_demo.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;

public class ClientTest {

    private Client client;

    @BeforeEach
    void setUp() {
        this.client = new Client("Suzanne", "Kruizes");
        this.client.setDateOfBirth(LocalDate.of( 1879, 3, 14));
    }

    @Test
    void testGetFullName() {
        String expectedFullName = "Suzanne Kruizes";
        String actualFullName = this.client.getFullName();
        assertEquals(expectedFullName, actualFullName);
    }

    @Test
    void testGetAge() {
        int expectedAge = 76;
        int actualAge = client.getAge(LocalDate.of(1955,4,18));
        assertEquals(expectedAge, actualAge);
    }

}
