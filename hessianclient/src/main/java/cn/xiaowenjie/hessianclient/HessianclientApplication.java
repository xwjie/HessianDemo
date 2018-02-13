package cn.xiaowenjie.hessianclient;

import org.springframework.boot.SpringApplication;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.condition.ConditionalOnCloudPlatform;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

@EnableCaching
@SpringBootApplication
@Configuration
public class HessianclientApplication {

	public static void main(String[] args) {
		SpringApplication.run(HessianclientApplication.class, args);
	}

	@Primary
	@Bean(name = "A", initMethod = "init",destroyMethod="close" )
	public TestBean bean1() {
		return new TestBean();
	}

	@Bean(name = "B")
	public TestBean bean2() {
		return new TestBean();
	}
}
