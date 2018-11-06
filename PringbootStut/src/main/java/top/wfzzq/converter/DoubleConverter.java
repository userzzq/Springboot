package top.wfzzq.converter;


import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import top.wfzzq.utils.MyUtils;

/**
 * Double数值转换器
 * 
 * @author wanghui
 *
 */
@Component
public class DoubleConverter implements Converter<String, Double> {

	@Override
	public Double convert(String source) {
		if (MyUtils.isEmpty(source)) {
			return null;
		}
		source = MyUtils.trim(source);
		try {
			return Double.valueOf(source);
		} catch (Exception ex) {
		}
		return null;
	}

}
