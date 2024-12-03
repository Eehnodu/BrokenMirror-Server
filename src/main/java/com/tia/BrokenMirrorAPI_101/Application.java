package com.tia.BrokenMirrorAPI_101;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
// 위▲ 어노테이션 안에 @ComponentScan나 Component, Configuration 어노테이션 有
// @ComponentScan = 빈으로 등록해야할 어노테이션을 찾아 전부 빈으로 등록해줌 (= @Component, @Service, @Repository, @Controller, @RestController 어노테이션을 찾아서 Bean으로 등록해줌)
@EnableJpaAuditing
// 엔티티 객체가 생성이 되거나 변경이 되었을 때 @EnableJpaAuditing 어노테이션을 활용해서 자동으로 값을 등록할 수 있음
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

}
