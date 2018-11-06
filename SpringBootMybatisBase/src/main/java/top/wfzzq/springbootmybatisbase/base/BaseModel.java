package top.wfzzq.springbootmybatisbase.base;

import top.wfzzq.springbootmybatisbase.entity.TbToken;
import top.wfzzq.springbootmybatisbase.entity.TbTokenInfo;

/**
 * -model层基类
 * 
 * @author DarkKnight
 *
 */
public abstract class BaseModel extends BaseEntity {
	private static final long serialVersionUID = -7852662611922789479L;
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
	 * -获取token的委托方法
	 */
	public TbToken makeTbToken() {
		TbToken tbToken=new TbToken();
		tbToken.setToken(token);
		return tbToken;
	}
	/**
	 * -获取tokeninfo的委托方法
	 */
   public TbTokenInfo makeTbTokenInfo() {
	   TbTokenInfo tokenInfo=new TbTokenInfo();
	   tokenInfo.setToken(token);
	   return tokenInfo;
   }
}
