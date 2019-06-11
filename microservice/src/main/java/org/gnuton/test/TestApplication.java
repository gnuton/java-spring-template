package org.gnuton.test;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.actuate.autoconfigure.metrics.MetricsProperties;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

// Web apps are typically made of three layers:
// 1. web       - initial point of client communication - here we can find @Controller classes
// 2. org.gnuton.test.services  - acual logic - the place for @Services classes
// 3. DAO       - database connections/interactions - the place for @Repository classes
// @Components can live in any of the above packages

// This annotation initiate the scans of the components in the same page and below
@SpringBootApplication // same as@Configuration @EnableAutoConfiguration @ComponentScan
@EnableEurekaClient // not mandatory
public class TestApplication {

	@Deprecated // the future is webclient
	@Bean
	@LoadBalanced // Eureka: It does server discovery in load balance wy
	              // it says the URL is not real, but an eureka url to disoover
	public RestTemplate getRestTemplate() {
		return new RestTemplate();
	}

	@Bean // the reactive way to make web calls. Will replace RestTemplate.
	public WebClient.Builder getWebclientBuilder() {
		return WebClient.builder();
	}

	public static void main(String[] args) {
		System.setProperty("spring.devtools.restart.enabled", "true");
		SpringApplication.run(TestApplication.class, args);
	}

}
