package top.wfzzq.springbootmybatisbase.service;

import top.wfzzq.springbootmybatisbase.model.IndexModel;
import top.wfzzq.springbootmybatisbase.utils.JsonMessage;

/**
 * -首页服务
 * 
 * @author DarkKnight
 *
 */
public interface IndexService {

  /**
   * -首页echo
   * 
   * @param model
   * @return
   * @throws Exception
   */
  JsonMessage index(IndexModel model) throws Exception;
}
