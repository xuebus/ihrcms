/**
 * Copyright &copy; 2017-2018 <a href="http://zhaopin.com">zhaopin.com</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.cms.entity;

import org.hibernate.validator.constraints.Length;
import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;

import com.thinkgem.jeesite.common.persistence.DataEntity;

/**
 * 版本管理Entity
 * @author SYJ
 * @version 2017-06-13
 */
public class CmsVersion extends DataEntity<CmsVersion> {
	
	private static final long serialVersionUID = 1L;
	private String version;		// 版本
	private String title;		// 标题
	private String content;		// 内容
	private String target;		// Target
	private String url;		// URL
	private String app;		// APP
	private Date time;		// 时间
	
	public CmsVersion() {
		super();
	}

	public CmsVersion(String id){
		super(id);
	}

	@Length(min=0, max=255, message="版本长度必须介于 0 和 255 之间")
	public String getVersion() {
		return version;
	}

	public void setVersion(String version) {
		this.version = version;
	}
	
	@Length(min=0, max=255, message="标题长度必须介于 0 和 255 之间")
	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}
	
	@Length(min=0, max=255, message="内容长度必须介于 0 和 255 之间")
	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}
	
	@Length(min=0, max=255, message="Target长度必须介于 0 和 255 之间")
	public String getTarget() {
		return target;
	}

	public void setTarget(String target) {
		this.target = target;
	}
	
	@Length(min=0, max=255, message="URL长度必须介于 0 和 255 之间")
	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}
	
	@Length(min=0, max=255, message="APP长度必须介于 0 和 255 之间")
	public String getApp() {
		return app;
	}

	public void setApp(String app) {
		this.app = app;
	}
	
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	public Date getTime() {
		return time;
	}

	public void setTime(Date time) {
		this.time = time;
	}
	
}