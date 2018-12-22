package top.wfzzq.springbootmybatisbase.service;
/**
 * 页面信息服务
 * @author wanghui
 *
 */

import top.wfzzq.springbootmybatisbase.model.PageInfoModel;
import top.wfzzq.springbootmybatisbase.utils.JsonMessage;

public interface PageInfoService {
   /**
    * 分页查询
    * @param model
    * @return
    * @throws Exception
    */
    JsonMessage queryAll(PageInfoModel model) throws Exception;
    /**
     * 主键查询
     * @param model
     * @return
     * @throws Exception
     */
    JsonMessage queryByKey(PageInfoModel model) throws Exception;
    /**
     * 添加信息
     * @param model
     * @return
     * @throws Exception
     */
    JsonMessage add(PageInfoModel model) throws Exception;
    /**
     * 删除信息
     * @param model
     * @return
     * @throws Exception
     */
    JsonMessage delete(PageInfoModel model) throws Exception;
    /**
     * 修改信息
     * @param model
     * @return
     * @throws Exception
     */
    JsonMessage modify(PageInfoModel model) throws Exception;
    
}
