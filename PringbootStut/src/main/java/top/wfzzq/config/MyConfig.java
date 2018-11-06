package top.wfzzq.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
/**
 * MyConfig自定义配置属性配置
 * @author wanghui
 *
 */
@Configuration
public class MyConfig {
  @Value("${app.name}")
  public String appName;
  @Value("${reload.interval}")
  public int reload;
}
