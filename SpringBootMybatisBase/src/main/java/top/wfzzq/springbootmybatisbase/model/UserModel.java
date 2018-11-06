package top.wfzzq.springbootmybatisbase.model;
/**
 * -user控制器的模型
 * @author wanghui
 *
 */

import top.wfzzq.springbootmybatisbase.base.BaseModel;
import top.wfzzq.springbootmybatisbase.entity.TbUser;

public class UserModel extends BaseModel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2475196985217649258L;

	private TbUser user = new TbUser();

	public UserModel() {

	}

	public TbUser getUser() {
		return user;
	}

	public void setUser(TbUser user) {
		this.user = user;
	}

}
