package top.wfzzq.springbootmybatisbase.model;

import top.wfzzq.springbootmybatisbase.base.BaseModel;
import top.wfzzq.springbootmybatisbase.entity.TbToken;
import top.wfzzq.springbootmybatisbase.entity.TbTokenInfo;

/**
 * -测试用model
 * 
 * @author wanghui
 * 
 *
 */
public class TestModel extends BaseModel {
	private static final long serialVersionUID = 2578619237136331081L;
	private TbToken ctoken = new TbToken();
	private TbTokenInfo tokenInfo = new TbTokenInfo();
	private String imageCode = "";

	public TestModel() {

	}

	public String getImageCode() {
		return imageCode;
	}

	public void setImageCode(String imageCode) {
		this.imageCode = imageCode;
	}

	public TbToken getCtoken() {
		return ctoken;
	}

	public void setCtoken(TbToken ctoken) {
		this.ctoken = ctoken;
	}

	public TbTokenInfo getTokenInfo() {
		return tokenInfo;
	}

	public void setTokenInfo(TbTokenInfo tokenInfo) {
		this.tokenInfo = tokenInfo;
	}

}
