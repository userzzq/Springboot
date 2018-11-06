package top.wfzzq.converter;


import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;
/**
 * Integer数值转换器
 * @author wanghui
 *
 */
@Component
public class IntegerConverter implements Converter<String, Integer>{
  @Override
  public Integer convert(String source) {
	  if (source==null || "".equals(source)) {
		return null;
	}
	  try {
		return Integer.parseInt(source);
	} catch (Exception ex) {
		
	}
	  return null;
  }
   
}
