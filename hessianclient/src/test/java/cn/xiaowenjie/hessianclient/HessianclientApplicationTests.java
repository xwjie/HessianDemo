package cn.xiaowenjie.hessianclient;

import java.util.Collection;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.junit4.SpringRunner;

import cn.xiaowenjie.beans.Config;
import cn.xiaowenjie.beans.ResultBean;
import cn.xiaowenjie.services.IConfigService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class HessianclientApplicationTests {

	@Autowired
	IConfigService configService;

	@Autowired
	ApplicationContext context;

	@Test
	public void configTest() {
		Thread.dumpStack();
		
		// org.springframework.web.context.support.GenericWebApplicationContext
		// 重点看 AbstractApplicationContext
		System.out.println(context);

		
		Object bean1 = context.getBean("helloClient");
		// class com.sun.proxy.$Proxy54
		System.out.println(bean1.getClass());

		// 加了&得到了FactoryBean
		Object bean2 = context.getBean("&helloClient");
		// class org.springframework.remoting.caucho.HessianProxyFactoryBean
		System.out.println(bean2.getClass());
		
		Object bean3 = context.getBean("testBean");
		// class cn.xiaowenjie.hessianclient.TestBean$$EnhancerBySpringCGLIB$$a5718275
		System.out.println(bean3.getClass());

		// 异常： org.springframework.beans.factory.BeanIsNotAFactoryException: Bean named 'testBean' is expected to be of type 
		Object bean4 = context.getBean("&testBean");
		System.out.println(bean4.getClass());
		
		ResultBean<Long> addResult = configService.addConfig(Config.builder().name("配置项名称").value("配置项值").build());
		System.out.println(addResult);

		ResultBean<Collection<Config>> all = configService.getAll();
		System.out.println(all);

		// 把刚刚新建的删除掉
		ResultBean<Boolean> deleteResult = configService.delete(addResult.getData());
		System.out.println(deleteResult);
	}

}
