package com.ividata.BankAccountKata;


import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.ividata.BankAccountKata.Persistence.AccountDAO;

/**
 * @author Morad MELSAOUI
 *
 */

@SpringBootApplication
public class App 
{
    public static void main( String[] args )
    {
    	 SpringApplication.run(App.class, args);
    }
    @Bean
    public CommandLineRunner commandLineRunner(AccountDAO accountDAO) {
        return args -> {
        	// Avec le lancement de l'application, le compte bancaise sera créee pour simuler le test
        	accountDAO.Init();
            };
        };
    }
