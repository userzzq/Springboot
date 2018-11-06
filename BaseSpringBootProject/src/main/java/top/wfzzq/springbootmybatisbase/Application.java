package top.wfzzq.springbootmybatisbase;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;
/**
 * SpringBoot启动类
 * @author wanghui
 *
 */
@SpringBootApplication
@EnableScheduling
public class Application {
   public static void main(String[] args) {
	SpringApplication.run(Application.class, args);
}
}
