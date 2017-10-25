package cn.xiaowenjie.hessianclient;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.remoting.caucho.HessianProxyFactoryBean;

import cn.xiaowenjie.services.IConfigService;

@Configuration
public class HessianConfig {

	@Bean
	public HessianProxyFactoryBean helloClient() {
		HessianProxyFactoryBean factory = new HessianProxyFactoryBean();

		factory.setServiceUrl("http://localhost:8080/ConfigService");
		factory.setServiceInterface(IConfigService.class);

		return factory;
	}
}