package admin_user;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class AdminLogin {

	public static void main(String[] args) {
		SpringApplication.run(AdminLogin.class, args);
		System.out.println("http://localhost:8080/");
		System.out.println("http://localhost:8080/registration");
	}

}
