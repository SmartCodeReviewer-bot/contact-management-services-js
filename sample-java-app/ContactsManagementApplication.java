import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class ContactsManagementApplication {

    public static void main(String[] args) {
        SpringApplication.run(ContactsManagementApplication.class, args);
    }
}
