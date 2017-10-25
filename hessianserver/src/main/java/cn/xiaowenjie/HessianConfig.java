package cn.xiaowenjie;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.remoting.caucho.HessianServiceExporter;

import cn.xiaowenjie.services.IConfigService;

/**
 * 发布Config的Hessian服务
 * 
 * @author 晓风轻 https://github.com/xwjie/HessianDemo
 *
 */
@Configuration
public class HessianConfig {
	@Autowired
	private IConfigService configService;

	@Bean(name = "/ConfigService")
	public HessianServiceExporter hessianServiceExporter() {
		HessianServiceExporter exporter = new HessianServiceExporter();

		exporter.setService(configService);
		exporter.setServiceInterface(IConfigService.class);

		return exporter;
	}
}