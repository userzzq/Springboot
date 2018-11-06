package top.wfzzq.service.impl;

import java.text.SimpleDateFormat;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import top.wfzzq.dao.TbTokenDAO;
import top.wfzzq.dao.UtilsDAO;
import top.wfzzq.service.TaskService;

/**
 * 定时任务服务实现.service层是dao层和controller层的中间时间
 * Scheduled注解是将方法编注为定时启动，initalDelay表示第一次启动延时，fixedDelay表示执行间隔时间 cron表示指定时间点执行
 * 秒（0-59）分钟（0-59）时（0-23） 天（0-30） 月（0-11） 年（）
 * 
 * @author wanghui
 *
 */
@Service
public class TaskServiceImpl implements TaskService {

	private static final Logger log = LoggerFactory.getLogger(TaskServiceImpl.class);
	@Autowired
	private UtilsDAO utilsDAO;
	@Autowired
	private TbTokenDAO tbTokenDAO;
	 private static final SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MMM-dd HH:mm:ss");

	@Scheduled(initialDelay = 1000 * 5, fixedDelay = 10 * 1000)
	@Override
	public void showTime() {
		log.debug(String.format("数据库当前时间：%s", sdf.format(utilsDAO.queryTime())));
	}

	@Scheduled(cron = "0 20 9 * * ? ")
	@Override
	public void showTimeOnce() {
		log.debug(String.format("整点报时：%s", sdf.format(utilsDAO.queryTime())));
	}

	@Override
	@Scheduled(initialDelay = 3 * 1000, fixedDelay = 5 * 60 * 1000)
	public void deleteTokens() {

		log.debug("正在启动删除过期的token任务");
		int result;
		try {
			result = tbTokenDAO.deleteTokens();
		} catch (Exception e) {
			log.error("删除过期makeNewToKen任务发送错误", e);
			result = 0;
		}
		log.debug("删除过期token任务完成:" + result);
	}

	
}
