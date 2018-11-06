package top.wfzzq.springbootmybatisbase.service;

import top.wfzzq.springbootmybatisbase.model.UserModel;
import top.wfzzq.springbootmybatisbase.utils.JsonMessage;

/**
 * -User服务
 * 
 * @author wanghui
 *
 */
public interface UserService {
	/**
	 * -用户登录
	 * 
	 * @param model
	 * @return
	 * @throws Exception
	 */
	JsonMessage login(UserModel model) throws Exception;

	/**
	 * -用户注销
	 * 
	 * @param model
	 * @return
	 * @throws Exception
	 */
	JsonMessage logout(UserModel model) throws Exception;

	/**
	 * -查询登录用户信息
	 * @param model
	 * @return
	 * @throws Exception
	 */
	JsonMessage getUserInfo(UserModel model) throws Exception;

}
