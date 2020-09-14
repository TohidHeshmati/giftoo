package com.project.giftoo;

import com.project.giftoo.config.GiftooProperties;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication
@EnableConfigurationProperties(GiftooProperties.class)
public class GiftooApplication {

	public static void main(String[] args) {
		SpringApplication.run(GiftooApplication.class, args);
	}

}
