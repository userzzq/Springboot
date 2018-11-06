package top.wfzzq.springbootmybatisbase.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import top.wfzzq.springbootmybatisbase.base.NeedLogin;
import top.wfzzq.springbootmybatisbase.entity.TbUser;
import top.wfzzq.springbootmybatisbase.model.TestModel;
import top.wfzzq.springbootmybatisbase.utils.JsonMessage;

/**
 * -测试控制器
 * 
 * @author wanghui
 *
 */
@RestController
@RequestMapping("/test")
public class TestController implements NeedLogin {

	
	private TbUser user;

	@Override
	public void setUser(TbUser user) {
		this.user = user;
	}

	/**
	 * -测试NeedlLogin
	 * 
	 * @param model
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/index")
	public JsonMessage index(TestModel model) throws Exception {
		// http://127.0.0.1:20000/test/index?token=5ajkksdfkajskfjklsajf
		JsonMessage message = JsonMessage.getSuccess("测试NeedLogin接口");
		// 可以直接拿到登录的user信息
		message.getDatas().put("user", user);
		return message;
	}

}
