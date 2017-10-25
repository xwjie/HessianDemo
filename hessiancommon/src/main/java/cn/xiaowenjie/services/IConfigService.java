package cn.xiaowenjie.services;

import java.util.Collection;

import cn.xiaowenjie.beans.Config;
import cn.xiaowenjie.beans.ResultBean;

/**
 * 定义config的操作接口
 * 
 * @author 晓风轻 https://github.com/xwjie/HessianDemo
 *
 */
public interface IConfigService {

	ResultBean<Long> addConfig(Config config);

	ResultBean<Collection<Config>> getAll();

	ResultBean<Boolean> delete(long id);
}
