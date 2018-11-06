package top.wfzzq.springbootmybatisbase.converter;

import org.springframework.core.convert.converter.Converter;

import top.wfzzq.springbootmybatisbase.utils.MyUtils;
/**
 * -字符转换器（去空）
 * @author wanghui
 *
 */
public class StringConverter implements Converter<String, String>{
     @Override
     public String convert(String source) {
    	 return MyUtils.trim(source);
     }
}
