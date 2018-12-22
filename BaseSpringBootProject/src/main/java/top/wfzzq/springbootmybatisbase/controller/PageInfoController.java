package top.wfzzq.springbootmybatisbase.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import top.wfzzq.springbootmybatisbase.model.PageInfoModel;
import top.wfzzq.springbootmybatisbase.service.PageInfoService;
import top.wfzzq.springbootmybatisbase.utils.JsonMessage;

/**
 * Tbpageinfo控制器
 * 
 * @author wanghui
 *
 */
@RestController
@RequestMapping("/pageinfo")
public class PageInfoController {
    @Autowired
    private PageInfoService pageInfoService;

    /**
     * 
     * @param model
     * @return
     * @throws Exception
     */
    @RequestMapping("/queryAll")
    public JsonMessage queryAll(PageInfoModel model) throws Exception {
        return pageInfoService.queryAll(model);
    }

    /**
     * 
     * @param model
     * @return
     * @throws Exception
     */
    @RequestMapping("/add")
    public JsonMessage add(PageInfoModel model) throws Exception {
        return pageInfoService.add(model);
    }

    /**
     * 
     * @param model
     * @return
     * @throws Exception
     */
    @RequestMapping("/queryByKey")
    public JsonMessage queryByKey(PageInfoModel model) throws Exception {
        return pageInfoService.queryByKey(model);
    }

    /**
     * 
     * @param model
     * @return
     * @throws Exception
     */
    @RequestMapping("/modify")
    public JsonMessage modify(PageInfoModel model) throws Exception {
        return pageInfoService.modify(model);
    }

    /**
     * 
     * @param model
     * @return
     * @throws Exception
     */
    @RequestMapping("/delete")
    public JsonMessage delete(PageInfoModel model) throws Exception {
        return pageInfoService.delete(model);
    }
}
