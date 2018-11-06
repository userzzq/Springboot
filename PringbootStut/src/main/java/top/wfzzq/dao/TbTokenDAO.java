package top.wfzzq.dao;

import org.apache.ibatis.annotations.Mapper;

import top.wfzzq.entity.TbToKenInfo;

/**
 * Token追踪 如果用客户端没有提供token,创建新的Token添加到数据库中，返回token给客户端
 * 如果客户端提供了token,就判断token是否在数据库中存在且没有过期（lastupdate）<br>
 * 不存在或者过期就回去到新建的流程,存在就更新过期时间（lastudate）<br>
 * 如果token对应的的客户端长期不向服务器发起数据，会造成数据库资源浪费 所以要开启定时任务检查token的lastupdate,超过一定时间就会自动清理
 * 
 * @author wanghui
 *
 */
@Mapper
public interface TbTokenDAO {
	/**
	 * 添加TbToken
	 * 
	 * @param toKenInfo
	 * @return
	 */
	int addToken(TbToKenInfo toKenInfo) throws Exception;

	/**
	 * 更新TbToken
	 * 
	 * @param toKenInfo
	 * @return
	 */
	int updateToken(TbToKenInfo toKenInfo) throws Exception;

	
	/**
	 * 删除token过期
	 * 
	 * @param toKenInfo
	 * @return
	 */
	int deleteTokens() throws Exception;

	/**
	 * 查询token是否存在
	 * 
	 * @param toKenInfo
	 * @return
	 */
	TbToKenInfo queryKenInfo(TbToKenInfo toKenInfo) throws Exception;

}
