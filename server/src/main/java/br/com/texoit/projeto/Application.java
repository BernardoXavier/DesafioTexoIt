package br.com.texoit.projeto;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 * Classe responsável por executar o springBoot.
 * 
 * @author Bernardo Xavier
 * 
 * 
 */
@EnableScheduling
@SpringBootApplication
public class Application {


    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);

    }

}
