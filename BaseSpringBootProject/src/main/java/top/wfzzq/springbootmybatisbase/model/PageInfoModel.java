package top.wfzzq.springbootmybatisbase.model;

import top.wfzzq.springbootmybatisbase.base.BasePageModel;
import top.wfzzq.springbootmybatisbase.entity.TbPageInfo;

public class PageInfoModel extends BasePageModel {

    /**
     * 
     */
    private static final long serialVersionUID = 5371537180271122875L;

    private TbPageInfo tbPageInfo = new TbPageInfo();

    public PageInfoModel() {
    }

    public TbPageInfo getTbPageInfo() {
        return tbPageInfo;
    }

    public void setTbPageInfo(TbPageInfo tbPageInfo) {
        this.tbPageInfo = tbPageInfo;
    }

  
   

}
