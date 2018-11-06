package top.wfzzq.utils;
/**
 * 
 * @author wanghui
 *
 */
public class MyUtils {
/**
 * isEmpty-判断是否是null或者是全部都是空白字符
 * 
 * @param value
 * @return
 */
	public static boolean isEmpty(String value) {
		return value==null || "".equals(value.trim());
	}
	/**
	 * tirm-去掉头尾空白字符,null值也会返回成空白字符串
	 * 
	 * @param value
	 * @return
	 */
	public static String trim(String value) {
		if (isEmpty(value)) {
			return "";
		}
		return value.trim();
	}
}
