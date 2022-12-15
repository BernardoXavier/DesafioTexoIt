package br.com.texoit.projeto.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

/**
 * Classe de configuração.

 * @author Bernardo Xavier
 * 

*/
@Configuration
@EnableJpaRepositories(basePackages = "br.com.texoit.projeto.repository")
public class DatabaseConfig {

}
