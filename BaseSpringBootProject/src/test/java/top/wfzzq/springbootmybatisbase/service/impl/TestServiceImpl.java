package top.wfzzq.springbootmybatisbase.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import top.wfzzq.springbootmybatisbase.dao.TestDAO;
import top.wfzzq.springbootmybatisbase.model.TestModel;
import top.wfzzq.springbootmybatisbase.service.TestService;
import top.wfzzq.springbootmybatisbase.utils.JsonMessage;
/**
 * 
 * @author wanghui
 *
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class TestServiceImpl implements TestService{
    @Autowired
    private TestDAO testDAO;
    @Override
	public JsonMessage tranAdd(TestModel model) throws Exception{
    	//事务处理，只要一个失败都会失败，否则都成功
    	testDAO.addToken(model.getCtoken());
    	testDAO.addTokenInfo(model.getTokenInfo());
    	return JsonMessage.getSuccess("添加成功");
    }
}
