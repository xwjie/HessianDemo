package cn.xiaowenjie.hessianclient;

import java.util.Collection;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import cn.xiaowenjie.beans.Config;
import cn.xiaowenjie.beans.ResultBean;
import cn.xiaowenjie.services.IConfigService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class HessianclientApplicationTests {

	@Autowired
	IConfigService configService;

	@Test
	public void configTest() {
		ResultBean<Long> addResult = configService
				.addConfig(Config.builder().name("配置项名称").value("配置项值").build());
		System.out.println(addResult);

		ResultBean<Collection<Config>> all = configService.getAll();
		System.out.println(all);

		// 把刚刚新建的删除掉
		ResultBean<Boolean> deleteResult = configService.delete(addResult.getData());
		System.out.println(deleteResult);
	}

}
