package top.wfzzq.springbootmybatisbase.service;

import top.wfzzq.springbootmybatisbase.model.TestModel;
import top.wfzzq.springbootmybatisbase.utils.JsonMessage;
/**
 * -测试服务
 * @author wanghui
 *
 */
public interface TestService {
   /**
    * -测试事务添加
    * @param model
    * @return
    * @throws Exception
    */
	JsonMessage tranAdd(TestModel model) throws Exception;

}
