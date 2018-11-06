package top.wfzzq.springbootmybatisbase.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import top.wfzzq.springbootmybatisbase.entity.TbTokenInfo;
import top.wfzzq.springbootmybatisbase.model.TestModel;
import top.wfzzq.springbootmybatisbase.service.TestService;
import top.wfzzq.springbootmybatisbase.service.UtilService;
import top.wfzzq.springbootmybatisbase.utils.JsonMessage;

/**
 * -其它测试控制器
 * 
 * @author wanghui
 *
 */
@RestController
@RequestMapping("/test")
public class TestOtherController {
	@Autowired
	private TestService testService;
	@Autowired
	private UtilService utilservice;

	/**
	 * -测试事务
	 * 
	 * @param model
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/tran")
	public JsonMessage tran(TestModel model) throws Exception {
		// http;//127.0.0.1:20000/test/tran?token=&ctoken.token=abbs&tokenInfo.infoKey=abc&tokeninfo.info=ddd
		model.getTokenInfo().setToken(model.getCtoken().getToken());
		return testService.tranAdd(model);
	}
   @RequestMapping("/imageCode")
	public JsonMessage imageCode(TestModel model) throws Exception {
	   //http:127.0.0.1:2000/test/imageCode?token=&imageCode=
		// 获取图片校验码
		TbTokenInfo info = model.getTokenInfo();
		info.setInfo(model.getImageCode());
		// 校验
		boolean check = utilservice.checkImageCode(info);
		if (check) {
			return JsonMessage.getSuccess("图片校验码正确");
		} else {
			return JsonMessage.getFail("图片校验失败");
		}
	}
}
