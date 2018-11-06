package top.wfzzq.dao;

import org.apache.ibatis.annotations.Mapper;

import top.wfzzq.entity.TbUser;
/**
 * TbUser的Dao
 * @author wanghui
 *
 */
@Mapper
public interface TbUserDAO {
	/**
	 * login.用户登录信息校验
	 * 
	 * @param user
	 * @return
	 * @throws Exception
	 */
 TbUser login(TbUser user) throws Exception;
}
