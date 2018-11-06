package top.wfzzq.springbootmybatisbase.controller;

import top.wfzzq.springbootmybatisbase.base.BaseEntity;
/**
 * -文件上传信息
 * 
 * @author wanghui
 *
 */
public class TestUploadInfo extends BaseEntity{

	private static final long serialVersionUID = 5079483697738234360L;
    
	private String mime;
	private String filename;
	private long filesize;
	private String url;
	
	public TestUploadInfo() {
		
	}

	public String getMime() {
		return mime;
	}

	public void setMime(String mime) {
		this.mime = mime;
	}

	public String getFilename() {
		return filename;
	}

	public void setFilename(String filename) {
		this.filename = filename;
	}

	public long getFilesize() {
		return filesize;
	}

	public void setFilesize(long filesize) {
		this.filesize = filesize;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}
	
}
