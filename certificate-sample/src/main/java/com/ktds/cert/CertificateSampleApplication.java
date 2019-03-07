package com.ktds.cert;

import java.time.Duration;
import java.util.Arrays;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@Slf4j
@SpringBootApplication
public class CertificateSampleApplication {


	public static void main(String[] args) {
		SpringApplication.run(CertificateSampleApplication.class, args);
	}
	
	@Bean
	public RestTemplate getRestTemplate(RestTemplateBuilder restTemplateBuilder) {

		return restTemplateBuilder.setConnectTimeout(Duration.ofSeconds(3 * 1000))
				.setReadTimeout(Duration.ofSeconds(30 * 1000))
				.build();
	}

	@Bean
    public CommandLineRunner commandLineRunner(ApplicationContext ctx) {

		String javaOpts = System.getProperty("JAVA_OPTS");
		log.debug("java options:" + javaOpts);

		return args -> {
			/* logger.debug("Let's inspect the beans provided by Spring Boot:"); */

			String[] beanNames = ctx.getBeanDefinitionNames();
			Arrays.sort(beanNames);

			//      for (String beanName : beanNames) {
			//        logger.debug(beanName);
			//      }};
		};


	}
}
