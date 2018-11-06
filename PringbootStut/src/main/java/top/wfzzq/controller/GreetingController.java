package top.wfzzq.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import top.wfzzq.config.MyConfig;
import top.wfzzq.entity.Greeting;
import top.wfzzq.entity.JsonMessage;

@RestController
@ResponseBody
@RequestMapping("/greeting")
public class GreetingController {
	@Autowired
	private MyConfig myConfig;

	@RequestMapping(name="/index")
   public JsonMessage index() {
	   String m=String.format("欢迎使用springboot%s,%s",myConfig.appName,myConfig.reload);
       JsonMessage message=JsonMessage.getSuccess(m);
	return message;
   }

	@RequestMapping("/greeting")
	public JsonMessage greeting(Greeting greeting) {
		//http://127
		JsonMessage message=JsonMessage.getSuccess("");
		message.getDatas().put("greeting", greeting);
		return message;
	}
}
