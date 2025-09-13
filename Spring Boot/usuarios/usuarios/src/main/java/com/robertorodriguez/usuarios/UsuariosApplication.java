package com.robertorodriguez.usuarios;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class UsuariosApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(UsuariosApplication.class, args);
	}

    @Override
    public void run(String... args) throws Exception {
        System.out.println("API Funcionando...");
    }
}
