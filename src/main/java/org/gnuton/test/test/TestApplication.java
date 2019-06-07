package org.gnuton.test.test;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
// Web apps are typically made of three layers:
// 1. web       - initial point of client communication - here we can find @Controller classes
// 2. business  - acual logic - the place for @Services classes
// 3. DAO       - database connections/interactions - the place for @Repository classes
// @Components can live in any of the above packages

// This annotation initiate the scans of the components
@SpringBootApplication
public class TestApplication {

	public static void main(String[] args) {
		SpringApplication.run(TestApplication.class, args);
	}

}
