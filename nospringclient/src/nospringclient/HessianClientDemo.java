package nospringclient;

import java.net.MalformedURLException;
import java.util.Collection;

import com.caucho.hessian.client.HessianProxyFactory;
import com.caucho.hessian.io.HessianMethodSerializationException;

import cn.xiaowenjie.beans.Config;
import cn.xiaowenjie.beans.ResultBean;
import cn.xiaowenjie.services.IConfigService;

public class HessianClientDemo {

	private static final String url = "http://localhost:8080/nospringserver/api/config";

	public static void main(String[] args) throws MalformedURLException {

		HessianProxyFactory factory = new HessianProxyFactory();
		
		// 鉴权相关信息在factory上配置
		factory.setUser("username");
		factory.setPassword("password");

		IConfigService configService = (IConfigService) factory.create(IConfigService.class, url);

		ResultBean<Long> addResult = configService.addConfig(Config.builder().name("配置项名称").value("配置项值").build());
		System.out.println(addResult);

		ResultBean<Collection<Config>> all = configService.getAll();
		System.out.println(all);

		// 把刚刚新建的删除掉
		ResultBean<Boolean> deleteResult = configService.delete(addResult.getData());
		System.out.println(deleteResult);

	}
}
