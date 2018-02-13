package cn.xiaowenjie.hessianclient;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

//@Component
public class TestBean {

	public void init() {
		System.out.println("TestBean.init() @Bean(name = \"A\", initMethod = \"init\",destroyMethod=\"close\" )");
	}
	
	public void close() {
		System.out.println("TestBean.init() @Bean(name = \"A\", initMethod = \"init\",destroyMethod=\"close\" )");
	}

	@Cacheable()
	public int method1() {
		return 0;
	}
}
