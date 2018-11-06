package top.wfzzq.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import top.wfzzq.controller.BaseModel;
import top.wfzzq.entity.JsonMessage;
import top.wfzzq.entity.TbToKenInfo;
import top.wfzzq.service.TokenService;

/**
 * 环绕切面（最完整的切面处理）
 * 
 * @author wanghui
 *
 */
@Aspect
@Component
public class ControllerToken {
	@Pointcut("execution(public * top.wfzzq.controller..*.*(..))")
	public void pointcut() {

	}

	private static final Logger log = LoggerFactory.getLogger(ControllerToken.class);

	/**
	 * Around表示环绕切面,带有被切面的方法返回值，切点信息和异常抛出
	 * 
	 * @param pjp
	 * @return
	 * @throws Exception
	 */
	@Around("pointcut()")
	public Object token(ProceedingJoinPoint pjp) throws Throwable {
		// 前置============================
		// getTarget获取被切面类型
		log.debug("被切面的类型" + pjp.getTarget().getClass().getName());
		log.debug("即将执行J:" + pjp.getSignature());
		StringBuilder sb = new StringBuilder();
		Object[] args = pjp.getArgs();
		if (args == null || args.length == 0) {
			log.debug("没有参数");
		} else {
			log.debug("参数列表：\r\n");
			for (Object arg : args) {
				sb.append(arg).append("\r\n");
			}
			log.debug(sb.toString());
		}

		// 进入控制器之前需要检查客户信息的token信息=======================

		// 尾置============================
		TbToKenInfo toKen = proceToKen(pjp);
		// 分界点，proceed方法表示切点方法并获取返回值
		Object result = pjp.proceed();
		// 前置============================
		log.debug(String.format("%s执行完毕", pjp.getSignature()));
		// 返回值============================
		log.debug(String.format("%s的返回值是", pjp.getSignature(), result));

		// 返回值需要加入token信息========================================
		if (result instanceof JsonMessage && toKen != null) {
			JsonMessage message = (JsonMessage) result;
			message.setToken(toKen.getToken());
		}
		return result;
	}

	/**
	 * -处理客户端传入的token信息
	 * 
	 * @param pjp
	 * @return
	 * @throws Exception
	 */
	private TbToKenInfo proceToKen(ProceedingJoinPoint pjp) throws Exception {
		TbToKenInfo token = null;
		BaseModel model = null;
		// 检查参数是否存在model
		Object[] args = pjp.getArgs();
		for (Object arg : args) {
			if (arg instanceof BaseModel) {
				model = (BaseModel) arg;
				break;
			}
		}//如果BaseModel存在就校验token信息
		if (model != null) {
			token = tokenService.checkTbToKenInfo(model.makeTbToKenInfo());
		}
		return token;
	}

	@Autowired
	private TokenService tokenService;
}
