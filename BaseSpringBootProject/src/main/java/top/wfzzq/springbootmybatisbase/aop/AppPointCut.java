package top.wfzzq.springbootmybatisbase.aop;

import org.aspectj.lang.annotation.Pointcut;

/**
 * -应用程序切点定义
 * 
 * @author DarkKnight
 *
 */
public class AppPointCut {

  @Pointcut("execution(public * top.wfzzq.springbootmybatisbase.controller..*.*(..))")
  public void controller() {
  }

}
