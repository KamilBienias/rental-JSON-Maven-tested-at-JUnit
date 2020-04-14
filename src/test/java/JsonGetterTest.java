import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;

import java.time.LocalDateTime;
import java.util.ArrayList;

import static org.junit.Assert.*;

public class JsonGetterTest {

    @Test
    public void whenSerializingUsingJsonGetterThenCorrect() throws JsonProcessingException {

        //given
        Database database = new Database();
        //creates customers
        Customer jan = new Customer("Jan", "Kowalski", "85031476856", LocalDateTime.of(1985,3,14,12,00));
        Customer henryk = new Customer("Henryk", "Nowak", "67082545867", LocalDateTime.of(1967,8,25,12,00));
        database.getCustomers().add(jan);
        database.getCustomers().add(henryk);
        //creates products
        Product spadochron = new Product("spadochron", 2005, 69, new ArrayList<>(database.getCustomers()));//jan and henryk borrowed spadochron
        Product latarka = new Product("latarka", 2014, 5, new ArrayList<>());
        database.getProducts().add(spadochron);
        database.getProducts().add(latarka);

        //when
        ObjectMapper objectMapper = new ObjectMapper();
        String result = objectMapper.writeValueAsString(database);
        System.out.println(result);

        //then
        assertEquals("{\"customers\":[{\"firstName\":\"Henryk\",\"lastName\":\"Nowak\",\"pesel\":\"67082545867\",\"dateOfBirth\":\"25.08.1967\"},{\"firstName\":\"Jan\",\"lastName\":\"Kowalski\",\"pesel\":\"85031476856\",\"dateOfBirth\":\"14.03.1985\"}],\"products\":[{\"productName\":\"spadochron\",\"yearOfProduction\":2005,\"price\":69,\"borrowers\":[{\"firstName\":\"Henryk\",\"lastName\":\"Nowak\",\"pesel\":\"67082545867\",\"dateOfBirth\":\"25.08.1967\"},{\"firstName\":\"Jan\",\"lastName\":\"Kowalski\",\"pesel\":\"85031476856\",\"dateOfBirth\":\"14.03.1985\"}]},{\"productName\":\"latarka\",\"yearOfProduction\":2014,\"price\":5,\"borrowers\":[]}]}", result);
    }
}
