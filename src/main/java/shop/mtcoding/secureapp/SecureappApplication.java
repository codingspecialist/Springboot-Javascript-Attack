package shop.mtcoding.secureapp;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import shop.mtcoding.secureapp.model.user.User;
import shop.mtcoding.secureapp.model.user.UserRepository;

@SpringBootApplication
public class SecureappApplication {

    @Bean
    CommandLineRunner init(UserRepository userRepository){
        return (args)->{
            User ssar = User.builder().username("ssar").password("1234").email("ssar@nate.com").build();
            User cos = User.builder().username("cos").password("1234").email("cos@nate.com").build();

            userRepository.save(ssar);
            userRepository.save(cos);
        };
    }

    public static void main(String[] args) {
        SpringApplication.run(SecureappApplication.class, args);
    }

}
