package top.wfzzq.converter;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.regex.Pattern;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import top.wfzzq.utils.MyUtils;

/**
 * DateConverter-日期数据转换器 Converter<String, Date>
 * 
 * @author wanghui
 *
 */
@Component
public class DateConverter implements Converter<String, Date> {
	/**
	 * 短格式日期
	 */
	private static final SimpleDateFormat SDF_SHORT = new SimpleDateFormat("yyyy-MM-dd");
	/**
	 * 长格式日期
	 */
	private static final SimpleDateFormat SDF_LONG = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	/**
	 * 
	 */
	private static final Pattern PSHORT = Pattern.compile("^\\d{4}[-]\\d{2}[-]\\d{2}$");
	/*
	 * 
	 */
	private static final Pattern PLONG = Pattern.compile("^\\d{4}[-]\\d{2}[-]\\d{2} \\d{2}:\\d{2}:\\d{2}$");

	@Override
	public Date convert(String source) {
		if (MyUtils.isEmpty(source)) {
			return null;
		}
		source = MyUtils.trim(source);
		try {
			if (PLONG.matcher(source).matches()) {
				// 长日期格式
				return SDF_LONG.parse(source);
			} else if (PSHORT.matcher(source).matches()) {
				// 短日期格式
				return SDF_SHORT.parse(source);
			}
		} catch (Exception e) {
		}
		return null;
	}

	public static void main(String[] args) {
		// 正则表达试测试 \d是数字，{n,m}是量词,【指定的字符列表】 \d也可以是[0123456789]^是行开头，$是行结尾
		// 四位数-两位数-两位数
		// 如果校验座机电话：[0]\\d{2,3}[-]\\d{7,8}
//		Pattern pattern = Pattern.compile("^\\d{4}[-]\\d{2}[-]\\d{2} \\d{2}:\\d{2}:\\d{2}$");
//		String info = "44123-88-77";
//		System.out.println(pattern.matcher(info).matches());
//		info = "2234-88-77 12:23:69";
//		System.out.println(pattern.matcher(info).matches());
		// ??????????????????????????????????????????
//		System.out.println("1"+StringUtils.trimWhitespace(null));
	}

}
