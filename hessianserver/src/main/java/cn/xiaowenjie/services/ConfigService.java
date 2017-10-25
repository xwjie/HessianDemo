package cn.xiaowenjie.services;

import java.util.Collection;
import java.util.concurrent.ConcurrentSkipListMap;
import java.util.concurrent.atomic.AtomicLong;

import org.springframework.stereotype.Service;

import cn.xiaowenjie.beans.Config;
import cn.xiaowenjie.beans.ResultBean;

/**
 * 实现最简单的的config操作d
 * 
 * @author 晓风轻 https://github.com/xwjie/HessianDemo
 *
 */
@Service
public class ConfigService implements IConfigService {

	private final ConcurrentSkipListMap<Long, Config> configs = new ConcurrentSkipListMap<Long, Config>();

	private static final AtomicLong idSequence = new AtomicLong(1000L);

	@Override
	public ResultBean<Long> addConfig(Config config) {
		System.out.println("addConfig：" + config);
		
		long id = idSequence.incrementAndGet();

		config.setId(id);
		configs.put(id, config);

		return new ResultBean<>(id);
	}

	@Override
	public ResultBean<Collection<Config>> getAll() {
		System.out.println("GetAll：=======打印一个日志，后面会用到========");
		return new ResultBean<>(configs.values());
	}

	@Override
	public ResultBean<Boolean> delete(long id) {
		System.out.println("Delete：" + id);
		return new ResultBean<>(configs.remove(id) != null);
	}

}
