package top.wfzzq.entity;
/**
 * 用户表类
 * @author wanghui
 *
 */

import java.sql.Date;
import com.alibaba.fastjson.annotation.JSONField;

public class TbUser extends BaseEntity{ 
	
	private static final long serialVersionUID = -7101496021543018801L;
	private Integer uid;
	private String username;
	private String password;
	private String nikename;
	private String isEnable;
	@JSONField(format="yyyy-MM-dd HH:mm:ss")
	private Date regDate;

	
	public TbUser() {
		
	}
    public TbUser(Integer uid,String username,String password,String nikename,String isEnable,Date regDate) {
    	this.uid = uid;
    	this.username = username;
    	this.password = password;
    	this.nikename = nikename;
    	this.isEnable = isEnable;
    	this.regDate = regDate;
	}
	public Integer getUid() {
		return uid;
	}

	public void setUid(Integer uid) {
		this.uid = uid;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getNikename() {
		return nikename;
	}

	public void setNikename(String nikename) {
		this.nikename = nikename;
	}

	public String getIsEnable() {
		return isEnable;
	}

	public void setIsEnable(String isEnable) {
		this.isEnable = isEnable;
	}

	public Date getRegDate() {
		return regDate;
	}

	public void setRegDate(Date regDate) {
		this.regDate = regDate;
	}

	
}
