package top.wfzzq.springbootmybatisbase.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;

import top.wfzzq.springbootmybatisbase.dao.TbPageInfoDAO;
import top.wfzzq.springbootmybatisbase.entity.TbPageInfo;
import top.wfzzq.springbootmybatisbase.model.PageInfoModel;
import top.wfzzq.springbootmybatisbase.service.PageInfoService;
import top.wfzzq.springbootmybatisbase.utils.JsonMessage;

/**
 * 页面服务逻辑实现
 * 
 * @author wanghui
 *
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class PageInfoServiceImpl implements PageInfoService {
    @Autowired
    private TbPageInfoDAO tbPageInfoDAO;

    @Override
    public JsonMessage queryAll(PageInfoModel model) throws Exception {
        JsonMessage message = JsonMessage.getSuccess("");
        // 通过页面提交参数设置分页查询信息
        PageHelper.startPage(model.getPage().getPageNumber(), model.getPage().getPageSize());
        // 分页查询
        Page<TbPageInfo> list = (Page<TbPageInfo>) tbPageInfoDAO.queryAll();
        // 更新分页信息

        model.getPage().setPageInfo(list);
        message.getDatas().put("page", model.getPage());
        message.getDatas().put("list", list);
        return message;
    }

    @Override
    public JsonMessage queryByKey(PageInfoModel model) throws Exception {
        JsonMessage message = JsonMessage.getSuccess("");
        message.getDatas().put("info", tbPageInfoDAO.queryByKey(model.getTbPageInfo()));
        return message;
    }

    @Override
    public JsonMessage add(PageInfoModel model)throws Exception{
        int result =tbPageInfoDAO.add(model.getTbPageInfo());
        return result==1?JsonMessage.getSuccess("添加成功"):JsonMessage.getFail("添加失败");
    }

    @Override
    public JsonMessage modify(PageInfoModel model) throws Exception{
        int result =tbPageInfoDAO.modify(model.getTbPageInfo());
        return result==1?JsonMessage.getSuccess("修改成功"):JsonMessage.getFail("修改失败");
    }

    @Override
    public JsonMessage delete(PageInfoModel model) throws Exception{
        int result =tbPageInfoDAO.delete(model.getTbPageInfo());
        return result==1?JsonMessage.getSuccess("删除成功"):JsonMessage.getFail("删除失败");
    }
}
