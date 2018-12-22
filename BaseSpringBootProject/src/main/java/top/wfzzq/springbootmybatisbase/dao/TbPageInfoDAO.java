package top.wfzzq.springbootmybatisbase.dao;



import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import top.wfzzq.springbootmybatisbase.entity.TbPageInfo;
/**
 * -页面信息dao
 * @author wanghui
 *
 */
@Mapper
public interface TbPageInfoDAO {
    /**
     * 查询所有
     * @return
     * @throws Exception
     */
  List<TbPageInfo> queryAll() throws Exception;
  /**
   * 主键查询
   * @param tbPageInfo
   * @return
   * @throws Exception
   */
  TbPageInfo queryByKey(TbPageInfo tbPageInfo) throws Exception;
  /**
   * 添加信息
   * @param tbPageInfo
   * @return
   * @throws Exception
   */
  int add(TbPageInfo tbPageInfo) throws Exception;
  /**
   * 修改信息
   * @param tbPageInfo
   * @return
   * @throws Exception
   */
  int modify(TbPageInfo tbPageInfo) throws Exception;
  /**
   * 删除信息
   * @param tbPageInfo
   * @return
   * @throws Exception
   */
  int delete(TbPageInfo tbPageInfo)throws Exception;
}
