package top.wfzzq.springbootmybatisbase.dao;

import org.apache.ibatis.annotations.Mapper;

import top.wfzzq.springbootmybatisbase.entity.TbToken;
import top.wfzzq.springbootmybatisbase.entity.TbTokenInfo;

/**
 * 測試的dao
 * @author wanghui
 *
 */
@Mapper
public interface TestDAO {
	/**
	 * -添加tokeninfo
	 * @param tokenInfo
	 * @return
	 * @throws Exception
	 */
 int addTokenInfo(TbTokenInfo tokenInfo)throws Exception;
 /**
  * -添加token
  * @param token
  * @return
  * @throws Exception
  */
 int addToken(TbToken token)throws Exception;
}
