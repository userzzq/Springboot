package top.wfzzq.springbootmybatisbase.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import top.wfzzq.springbootmybatisbase.model.IndexModel;
import top.wfzzq.springbootmybatisbase.service.IndexService;
import top.wfzzq.springbootmybatisbase.utils.JsonMessage;


/**
 * -首页
 * 
 * @author DarkKnight
 *
 */
@RestController
public class IndexController {
  @Autowired
  private IndexService indexService;

  @RequestMapping("")
  public JsonMessage index(IndexModel model) throws Exception {
    // http://127.0.0.1:20000?echo=abc-123&token=
	  //http://127.0.0.1:22000?echo
    return indexService.index(model);
  }
}
