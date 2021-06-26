package cinema.system;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class StarterKitJpaStarterApplication {

  public static void main(String[] args) {
    // Uncomment line below to use mysql database
    // you can modify properties for the connection in application-xxx.properties
    //		 System.setProperty("spring.profiles.active", "xxx");

    SpringApplication.run(StarterKitJpaStarterApplication.class, args);
  }
}
