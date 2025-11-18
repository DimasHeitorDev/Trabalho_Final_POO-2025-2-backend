package poo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class Application {
	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

    @GetMapping("/cliente")
    public String cliente() {
        return "este é o cliente";
    }

    @GetMapping("/admin")
    public String admin() {
        return "este é o admin";
    }
}
