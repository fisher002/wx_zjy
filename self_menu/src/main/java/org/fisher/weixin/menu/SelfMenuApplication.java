package org.fisher.weixin.menu;

import org.fisher.weixin.CommonsConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@EntityScan("org.fisher")
@ComponentScan("org.fisher")
public class SelfMenuApplication implements CommonsConfig {

	public static void main(String[] args) {
		SpringApplication.run(SelfMenuApplication.class, args);
	}
}
