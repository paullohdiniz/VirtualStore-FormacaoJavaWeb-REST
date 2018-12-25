package br.com.virtualstore.virtualstoresecurity;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;

@SpringBootApplication
@EnableAuthorizationServer
public class VirtualStoreSecurityApplication {

	public static void main(String[] args) {
		SpringApplication.run(VirtualStoreSecurityApplication.class, args);
	}

}

