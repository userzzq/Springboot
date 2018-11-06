package top.wfzzq.springbootmybatisbase.service;

import top.wfzzq.springbootmybatisbase.entity.TbTokenInfo;
import top.wfzzq.springbootmybatisbase.model.UtilModel;

/**
 * -工具类服务
 * @author wanghui
 *
 */
public interface UtilService {

	
  /**
   * 生产图片
   * @param model
   * @return
   * @throws Exception
   */
	String makeImageCode(UtilModel model) throws Exception;
   /**
    * -校验图片校验是否正确，服务器端的图片校验码只能使用一次
    * @param tbTokenInfo
    * @return
    * @throws Exception
    */
   boolean checkImageCode(TbTokenInfo tbTokenInfo) throws Exception;
	

}
