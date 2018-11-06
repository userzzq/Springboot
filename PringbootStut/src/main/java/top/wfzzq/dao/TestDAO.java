package top.wfzzq.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
/**
 * TestDAO-测试用的mapper
 * @author wanghui
 *
 */

import top.wfzzq.entity.TbToKenInfo;
@Mapper
public interface TestDAO {
	/**
	 * Tbtoken
	 * @return
	 * @throws Exception
	 */
  List<TbToKenInfo> queryTokens() throws Exception;
}
