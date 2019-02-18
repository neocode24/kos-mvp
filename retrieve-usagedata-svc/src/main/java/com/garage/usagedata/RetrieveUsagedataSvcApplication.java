package com.garage.usagedata;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

import java.time.Duration;

@Slf4j
@SpringBootApplication
public class RetrieveUsagedataSvcApplication {

	public static void main(String[] args) {
		SpringApplication.run(RetrieveUsagedataSvcApplication.class, args);
	}

	
	@Bean
	public RestTemplate getRestTemplate(RestTemplateBuilder restTemplateBuilder) {

		return restTemplateBuilder.setConnectTimeout(Duration.ofSeconds(3 * 1000))
				.setReadTimeout(Duration.ofSeconds(30 * 1000))
				.build();
	}
}

