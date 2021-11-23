package dao;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import repositories.CountryRepository;

@SpringBootTest
public class CountryTest {

    @Autowired
    private CountryRepository countryRepository;

    private Country country1;

    @BeforeEach
    void setUp() {
        country1 = new Country(1l,"Trinidad and Tobago");
        countryRepository.save(country1);
    }

    
}
