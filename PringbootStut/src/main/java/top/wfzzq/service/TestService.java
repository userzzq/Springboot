package top.wfzzq.service;

import top.wfzzq.entity.JsonMessage;
import top.wfzzq.entity.PageBean;

/**
 * TestService-测试用服务
 * 
 * @author wanghui
 *
 */
public interface TestService {
	/**
	 * 分页查询
	 * 
	 * @param page
	 * @return
	 * @throws Exception
	 */
	JsonMessage queryTokens(PageBean page) throws Exception;

}
