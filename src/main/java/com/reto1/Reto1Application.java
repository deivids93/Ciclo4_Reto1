package com.reto1;

import com.reto1.Repository.UsersRepository;
import com.reto1.modelo.Usuario;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@SpringBootApplication
@ComponentScan(basePackages = {"com.reto1"})
public class Reto1Application {
    
         @Autowired
    private UsersRepository repoUsu;


	public static void main(String[] args) {
		SpringApplication.run(Reto1Application.class, args);
	}
        @Bean
    ApplicationRunner applicationRunner() {
        return args -> {
            System.out.println("APLICACION INICIADA!.");
            List<Usuario> cs = repoUsu.getAll();
            System.out.println("Usuario: " + cs.size());

        };
    }
    @Bean
    public WebMvcConfigurer corsConfigurer() {
        return new WebMvcConfigurer() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping("/**").allowedOrigins("*");
            }
        };
    }

}
