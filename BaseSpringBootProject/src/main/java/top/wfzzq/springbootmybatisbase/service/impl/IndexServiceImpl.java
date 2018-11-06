package top.wfzzq.springbootmybatisbase.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import top.wfzzq.springbootmybatisbase.dao.UtilsDAO;
import top.wfzzq.springbootmybatisbase.model.IndexModel;
import top.wfzzq.springbootmybatisbase.service.IndexService;
import top.wfzzq.springbootmybatisbase.utils.JsonMessage;

/**
 * 
 * @author DarkKnight
 *
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class IndexServiceImpl implements IndexService {
  @Autowired
  private UtilsDAO utilsDAO;

  @Override
  public JsonMessage index(IndexModel model) throws Exception {
    JsonMessage message = JsonMessage.getSuccess(model.getEcho());
    message.getDatas().put("now", utilsDAO.queryTime());
    return message;
  }
}
