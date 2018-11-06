package top.wfzzq.dao;



import java.util.Date;

import org.apache.ibatis.annotations.Mapper;

/**
 * util-系统工具
 * 
 * @author wanghui
 *
 */
@Mapper
public interface UtilsDAO {
	/**
	 * 查询系统时间
	 * @return
	 */
  Date queryTime();
}
