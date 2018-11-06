package top.wfzzq.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import top.wfzzq.controller.test.TestEntity;
import top.wfzzq.controller.test.TestModel;
import top.wfzzq.entity.JsonMessage;
import top.wfzzq.entity.TbToKenInfo;
import top.wfzzq.exception.AppException;
import top.wfzzq.service.TestService;
import top.wfzzq.service.TokenService;

/**
 * 测试用的控制器
 * 
 * @author wanghui
 *
 */
@RestController
@ResponseBody
@RequestMapping("/test")
public class TextIndexController {
	private static final String OK="ok";
	private static final String ONE="one";
	private static final String TOW="tow";
	@Autowired
	private TokenService tokenService;

	@RequestMapping("/createToKen")
	public JsonMessage createToken(TbToKenInfo tokenInfo) throws Exception {
		return tokenService.createToKenInfo(tokenInfo);
	}
	//127.0.0.1:20001/test/createToKen
	@RequestMapping("/exception")
	public JsonMessage exception(String type) throws Exception {
		if (ONE.equals(type)) {
			throw AppException.getAppException(1000, "第一种异常");
		} else if (TOW.equals(type)) {
			throw AppException.getAppException(1001, "第二种异常");
		} else if (OK.equals(type)) {
			return JsonMessage.getSuccess("没有错误！");
		} else {
			throw new Exception("标准异常");
		}
	}

	@RequestMapping("/converter")
	public JsonMessage converter(TestEntity test) throws Exception {
		// http;//127.0.0.1:20001/test/converter?info=abc&tint=123&tdouble=290.99&tdec=345.8&tdate=1998-09-11
		// 12:13:14
		JsonMessage json = JsonMessage.getSuccess("");
		json.getDatas().put("entity", test);
		return json;
	}

	@RequestMapping("/model")
	public JsonMessage model(TestModel model) throws Exception {
		// http://127.0.0.1:20001/test/model
		// 控制器中定义的参数用于获取客户端的数据，请对象的字段直接对应客户端参数名
		// TestModel中的token字段,可以直接用？token=adfafaf传递
		// 如果字段是复杂对象，需要通过二级名称传递
		// TestModel中的entity字段是TestEntity对象,里面包含tint,tdec等等字段
		// 需要用?entit.tint=100&entity.tdec=12.43传递
		// 传递不同的数据组合：？token=aaaaaaaa&entity.tint=100&entity.tdec=12.34排名不分先后
		// post提交也是一样的规则{token:"adfaf",'entity.tint':12}

		// http://127.0.0.1:20001/test/model==>token和entity都没有数据
		// http://127.0.0.1:20001/test/model?token=abcdefg
		// ==>token为abcdefg,entity没有数据
		// http://127.0.0.1:20001/test/model?token=abcdefg
		// ==>token为entity没有数据
		// http://127.0.0.1:20001/test/model?token=abcdefg&entity.tint=123
		// ==>token为abcdefg,entity的tint字段为123

		// 注意！！！传递的参数名都可以对象的字段名称，而不是对象的类名称
		// model的字段名称是entity,类型是TestEntity
		JsonMessage json = JsonMessage.getSuccess("");
		json.getDatas().put("model", model);
		return json;
	}
	@Autowired
	private TestService testService;
	@RequestMapping("/page")
	//127.0.0.1:20001/test/page?page.pageSize=5&page.pageNumber=1
	public JsonMessage page(TestModel model) throws Exception{
		return testService.queryTokens(model.getPage());
	}
}
