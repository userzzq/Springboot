package top.wfzzq.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;

import top.wfzzq.dao.TestDAO;
import top.wfzzq.entity.JsonMessage;
import top.wfzzq.entity.PageBean;
import top.wfzzq.entity.TbToKenInfo;
import top.wfzzq.service.TestService;

/**
 * 
 * @author wanghui
 *
 */
@Service
@Transactional(rollbackFor=Exception.class)
public class TestServiceImpl implements TestService{
  
	@Autowired
	private TestDAO testDAO;
	
	@Override
	public JsonMessage queryTokens(PageBean page) throws Exception{
		//查询前面设置的分页参数（第几页，每页记录数）
		PageHelper.startPage(page.getPageNumber(), page.getPageSize());
		//查询结果可以返回为page(带分页的List集合扩展，也就是Page<>和List<>可以互换)
		Page<TbToKenInfo> pages=(Page<TbToKenInfo>) testDAO.queryTokens();
		List<TbToKenInfo> list=testDAO.queryTokens();
		//获取到分页的信息
		JsonMessage json=JsonMessage.getSuccess("");
		Map<String, Object> datas=json.getDatas();
		//分页查询集
		page.setPageInfo(pages);
		datas.put("page", page);
		//原始查询集
		datas.put("list", pages);
		//总记录数
		//datas.put("total", pages.getTotal());
		return json;
	}
}
