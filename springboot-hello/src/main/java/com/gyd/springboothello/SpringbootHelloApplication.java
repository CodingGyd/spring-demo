package com.gyd.springboothello;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude = DataSourceAutoConfiguration.class)
//@MapperScan("com.gyd.springboothello.mapper")
public class SpringbootHelloApplication  {
	public static void main(String[] args) {
		SpringApplication.run(SpringbootHelloApplication.class, args);
	}

}
