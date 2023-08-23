import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class InsecureApiApplication {

    public static void main(String[] args) {
        SpringApplication.run(InsecureApiApplication.class, args);
    }

    @PostMapping("/create-user")
    public String createUser(@RequestBody User user) {
        // No validation for required fields
        String username = user.getUsername();
        String email = user.getEmail();
        String password = user.getPassword();

        UserRepository.createUser(username, email, password);

        return "User created successfully";
    }
}

class User {
    private String username;
    private String email;
    private String password;

}

class UserRepository {
    public static void createUser(String username, String email, String password) {
        
    }
}
