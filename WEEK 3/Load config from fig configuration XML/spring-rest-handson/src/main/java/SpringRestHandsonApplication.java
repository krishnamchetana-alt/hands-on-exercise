import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ImportResource;

@SpringBootApplication
@ImportResource("classpath:applicationContext.xml")
public class SpringRestHandsonApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringRestHandsonApplication.class, args);
    }
}
