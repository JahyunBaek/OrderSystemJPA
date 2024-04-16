package com.example.jpa.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.fasterxml.jackson.datatype.hibernate5.jakarta.Hibernate5JakartaModule;


@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}
	@Bean
    Hibernate5JakartaModule hibernate5Module() {
        return new Hibernate5JakartaModule();
    }

    // 강제 지연 로딩 설정을 하기 위해서는 이와 같이 추가해주면 된다.
    @Bean
    Hibernate5JakartaModule hibernate5JakartaModule() {
        Hibernate5JakartaModule hibernate5JakartaModule = new Hibernate5JakartaModule();
        hibernate5JakartaModule.configure(Hibernate5JakartaModule.Feature.FORCE_LAZY_LOADING, true);
        return hibernate5JakartaModule;
    }
}
