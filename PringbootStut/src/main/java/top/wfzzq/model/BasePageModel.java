package top.wfzzq.model;

import top.wfzzq.controller.BaseModel;
import top.wfzzq.entity.PageBean;

/**
 * -带分页的基础model
 * @author wanghui
 *
 */
public abstract class BasePageModel extends BaseModel{

	
	/**
	 * 
	 */
	private static final long serialVersionUID = -8333747701743429916L;
	private PageBean page=new PageBean();
	
	public BasePageModel() {
		
	}

	public PageBean getPage() {
		return page;
	}

	public void setPage(PageBean page) {
		this.page = page;
	}
	

}
