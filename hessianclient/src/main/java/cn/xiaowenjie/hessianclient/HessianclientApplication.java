package cn.xiaowenjie.hessianclient;

import org.springframework.boot.SpringApplication;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@EnableCaching
@SpringBootApplication
public class HessianclientApplication {

	public static void main(String[] args) {
		SpringApplication.run(HessianclientApplication.class, args);
	}
}
