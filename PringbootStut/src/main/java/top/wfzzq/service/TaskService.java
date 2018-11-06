package top.wfzzq.service;

/**
 * 系统定时任务服务类
 * 
 * @author wanghui
 *
 */
public interface TaskService {
	/**
	 * 定时显示当前时间
	 */
	void showTime();
    /**
     * 显示演示一次时间
     */
	void showTimeOnce();
	/**
	 * 删除所有过期的token
	 * 
	 */
	void deleteTokens();
}
