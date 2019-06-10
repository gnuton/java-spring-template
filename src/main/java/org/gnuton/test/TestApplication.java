package org.gnuton.test;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

// Web apps are typically made of three layers:
// 1. web       - initial point of client communication - here we can find @Controller classes
// 2. org.gnuton.test.services  - acual logic - the place for @Services classes
// 3. DAO       - database connections/interactions - the place for @Repository classes
// @Components can live in any of the above packages

// This annotation initiate the scans of the components in the same page and below
@SpringBootApplication // same as@Configuration @EnableAutoConfiguration @ComponentScan
public class TestApplication {

	@Deprecated // the future is webclient
	@Bean
	public RestTemplate getRestTemplate() {
		return new RestTemplate();
	}

	public static void main(String[] args) {
		System.setProperty("spring.devtools.restart.enabled", "true");
		SpringApplication.run(TestApplication.class, args);
	}

}
