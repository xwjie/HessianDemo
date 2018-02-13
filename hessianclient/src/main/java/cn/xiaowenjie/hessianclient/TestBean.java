package cn.xiaowenjie.hessianclient;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Component;

@Component
public class TestBean {

	@Cacheable()
	public int method1() {
		return 0;
	}
}
