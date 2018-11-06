package top.wfzzq.controller.test;

import java.math.BigDecimal;
import java.util.Date;

import com.alibaba.fastjson.annotation.JSONField;

import top.wfzzq.entity.BaseEntity;
/**
 * converter测试实体类
 * @author wanghui
 *
 */
public class TestEntity extends BaseEntity{

	private static final long serialVersionUID = 1558945534534423992L;
    
	private Integer tint;
	private Double tdouble;
	@JSONField(format="yyyy-MM-dd HH:mm:ss")
	private Date tdate;
	private BigDecimal tdec;
	private String info;
	
	public TestEntity() {
		
	}

	public Integer getTint() {
		return tint;
	}

	public void setTint(Integer tint) {
		this.tint = tint;
	}

	public Double getTdouble() {
		return tdouble;
	}

	public void setTdouble(Double tdouble) {
		this.tdouble = tdouble;
	}

	
	public Date getTdate() {
		return tdate;
	}

	public void setTdate(Date tdate) {
		this.tdate = tdate;
	}

	public BigDecimal getTdec() {
		return tdec;
	}

	public void setTdec(BigDecimal tdec) {
		this.tdec = tdec;
	}

	public String getInfo() {
		return info;
	}

	public void setInfo(String info) {
		this.info = info;
	}

}
