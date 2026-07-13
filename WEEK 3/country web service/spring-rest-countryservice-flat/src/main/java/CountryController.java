import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/api")
public class CountryController {

    @GetMapping("/countries")
    public List<Country> getAllCountries() {
        return Arrays.asList(
            new Country("India", "New Delhi"),
            new Country("United States", "Washington D.C."),
            new Country("Japan", "Tokyo")
        );
    }
}
