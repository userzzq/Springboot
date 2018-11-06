package top.wfzzq.springbootmybatisbase.dao;

import org.apache.ibatis.annotations.Mapper;
/**
 * TbUser的dao
 * @author wanghui
 *
 */

import top.wfzzq.springbootmybatisbase.entity.TbToken;
import top.wfzzq.springbootmybatisbase.entity.TbUser;

@Mapper
public interface TbUserDAO {
	/**
	 * -按照用户名查询用户信息
	 * 
	 * @param user
	 * @return
	 * @throws Exception
	 */
	TbUser queryByName(TbUser user) throws Exception;

	/**
	 * -查询token用户信息
	 * 
	 * @param token
	 * @return
	 * @throws Exception
	 */
	TbUser queryByToken(TbToken token) throws Exception;
}
