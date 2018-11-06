package top.wfzzq.entity;
/**
 * 追踪表类
 * @author wanghui
 *
 */


import java.sql.Date;

public class TbToKenInfo extends BaseEntity {
	/**
	 * 
	 */
	private static final long serialVersionUID = -6206795809987335546L;
	private String token;
	private Integer uid;
	private Date lastupdate;

	public TbToKenInfo() {

	}

	public TbToKenInfo(String token, Integer uid, Date lastupdate) {
		this.token = token;
		this.uid = uid;
		this.lastupdate = lastupdate;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public Integer getUid() {
		return uid;
	}

	public void setUid(Integer uid) {
		this.uid = uid;
	}

	public Date getLastupdate() {
		return lastupdate;
	}

	public void setLastupdate(Date lastupdate) {
		this.lastupdate = lastupdate;
	}

	@Override
	public String toString() {
		return "TbToKenInfo [token=" + token + ", uid=" + uid + ", lastupdate=" + lastupdate + "]";
	}
}
