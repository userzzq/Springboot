package top.wfzzq.springbootmybatisbase.dao;

import org.apache.ibatis.annotations.Mapper;

import top.wfzzq.springbootmybatisbase.entity.TbTokenInfo;
/**
 * TbTokenInfoDAO的dao
 * @author wanghui
 *
 */
@Mapper
public interface TbTokenInfoDAO {
	/**
	 * -删除所有过期的tokenInfo
	 * @return
	 * @throws Exception
	 */
  int deleteTokenInfos() throws Exception;
  /**
   * -添加图片校验码
   * @param tokenInfo
   * @return
   * @throws Exception
   */
  int addImageCode(TbTokenInfo tokenInfo)throws Exception;
  /**
   * -查询图片校验码
   * @param tokenInfo
   * @return
   * @throws Exception
   */
  TbTokenInfo queryImageCode(TbTokenInfo tokenInfo)throws Exception;
  /**
   * -修改图片校验码
   * @param tokenInfo
   * @return
   * @throws Exception
   */
  int updateImageCode(TbTokenInfo tokenInfo)throws Exception;
  /**
   * -删除图片校验码
   * @param tokenInfo
   * @return
   * @throws Exception
   */
  int deleteImageCode(TbTokenInfo tokenInfo)throws Exception;
  /**
   * 
   * @param tokenInfo
   * @return
   * @throws Exception
   */
  int addUser(TbTokenInfo tokenInfo)throws Exception;
  /**
   * -查询图片校验码
   * @param tokenInfo
   * @return
   * @throws Exception
   */
  TbTokenInfo queryUser(TbTokenInfo tokenInfo)throws Exception;
  /**
   * -修改图片校验码
   * @param tokenInfo
   * @return
   * @throws Exception
   */
  int updateUser(TbTokenInfo tokenInfo)throws Exception;
  /**
   * -删除图片校验码
   * @param tokenInfo
   * @return
   * @throws Exception
   */
  int deleteUser(TbTokenInfo tokenInfo)throws Exception;
  
  
}
