package top.wfzzq.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.NoHandlerFoundException;

import top.wfzzq.entity.JsonMessage;
import top.wfzzq.exception.AppException;

/**
 * MyExeceptionHandler 全部错误处理器 ControllerAdvice注解表示是控制器层拦截处理（app-面向切面编程）<br>
 * ExceptionHandler注解表示方法为错误处理器，参数是错误类型
 * 
 * @author wanghui
 *
 */
@ControllerAdvice
@ResponseBody
public class MyExeceptionHandler {

	private static final Logger log = LoggerFactory.getLogger(MyExeceptionHandler.class);

	@ExceptionHandler(Exception.class)
	public JsonMessage handleException(Exception ex) {
		log.error("服务器发生错误：", ex);
		if (ex instanceof AppException) {
			AppException appException = (AppException) ex;
			return JsonMessage.getFail(appException.getCode(), appException.getMessage());
		}
		if (ex instanceof NoHandlerFoundException) {
			return JsonMessage.getFail("404,错误");
		}
		return JsonMessage.getFail("服务器忙，请稍后重试");
	}
}
