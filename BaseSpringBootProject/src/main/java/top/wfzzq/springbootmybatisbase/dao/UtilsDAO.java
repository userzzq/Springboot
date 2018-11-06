package top.wfzzq.springbootmybatisbase.dao;

import java.util.Date;

import org.apache.ibatis.annotations.Mapper;
/**
 * 工具类dao
 * @author wanghui
 *
 */
@Mapper
public interface UtilsDAO {
	/**
	 * 查询数据库当前时间
	 * @return
	 * @throws Exception
	 */
     Date queryTime() throws Exception;
}
