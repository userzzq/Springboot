package top.wfzzq.springbootmybatisbase.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import top.wfzzq.springbootmybatisbase.model.UserModel;
import top.wfzzq.springbootmybatisbase.service.UserService;
import top.wfzzq.springbootmybatisbase.utils.JsonMessage;

/**
 * 用户信息控制器
 * 
 * @author wanghui
 *
 */
@RestController
@RequestMapping("/user")
public class UserController {
	@Autowired
	private UserService userService;
   /**
    * //127.0.0.1:22000/user/login?token=160572e7-0291-44f1-8417-3f8a733bdfa0&user.username=test&user.password=test-pwd
    * @param model
    * @return
    * @throws Exception
    */
	@RequestMapping("/login")
	public JsonMessage login(UserModel model) throws Exception {
		// /user/login {"user.username":"","user.password":"test-pwd"}
		return userService.login(model);
	}
   
	@RequestMapping("/logout")
	public JsonMessage logout(UserModel model) throws Exception {
		// /user/logout {}
		return userService.logout(model);
	}

	@RequestMapping("/getUserInfo")
	public JsonMessage getUserInfo(UserModel model) throws Exception {
		//user/getUserInfo{}    ?token=19e663b7-56e1-49d5-8327-0ead430ecdaa
		return userService.getUserInfo(model);
	}
}
