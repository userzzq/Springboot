package top.wfzzq.controller;

import top.wfzzq.entity.BaseEntity;
import top.wfzzq.entity.TbToKenInfo;

public class BaseModel extends BaseEntity {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6297919321150662650L;
	private String token;

	public BaseModel() {

	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	/**
	 * getToken的委托方法，将客户端获取的token信息传递给TbToKen对象
	 * 
	 * @return
	 */
	public TbToKenInfo makeTbToKenInfo() {
		TbToKenInfo tbToKenInfo = new TbToKenInfo();
		tbToKenInfo.setToken(token);
		return tbToKenInfo;
	}
}
