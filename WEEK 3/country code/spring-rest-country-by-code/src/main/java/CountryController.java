import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/api")
public class CountryController {

    private final List<Country> countries = Arrays.asList(
        new Country("IN", "India", "New Delhi"),
        new Country("US", "United States", "Washington D.C."),
        new Country("JP", "Japan", "Tokyo")
    );

    @GetMapping("/countries/{code}")
    public Country getCountryByCode(@PathVariable String code) {
        return countries.stream()
                .filter(c -> c.getCode().equalsIgnoreCase(code))
                .findFirst()
                .orElse(null); // Returns empty body if country code doesn't match
    }
}
