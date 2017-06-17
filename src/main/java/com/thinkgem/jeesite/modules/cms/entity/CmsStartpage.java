/**
 * Copyright &copy; 2017-2018 <a href="http://zhaopin.com">zhaopin.com</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.cms.entity;

import org.hibernate.validator.constraints.Length;
import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;

import com.thinkgem.jeesite.common.persistence.DataEntity;

/**
 * 启动页管理Entity
 * @author SYJ
 * @version 2017-06-13
 */
public class CmsStartpage extends DataEntity<CmsStartpage> {
	
	private static final long serialVersionUID = 1L;
	private String imgid;		// 图片ID
	private String url;		// 图片URL
	private String width;		// 图片宽度
	private String height;		// 图片高度
	private String isdefault;		// 是否使用默认启动图片
	private String zonecode;		// 区域
	private String platform;		// 平台
	private String androidcountdown;		// Android倒计时
	private String ioscountdown;		// IOS倒计时
	private String showtimer;		// 倒计时操作
	private String rate;		// 显示比率
	private String status;		// 状态
	private Date onlinestarttime;		// 上线时间
	private Date onlineendtime;		// 下线时间
	private String description;		// 描述
	private Date publishtime;		// 发布时间
	
	public CmsStartpage() {
		super();
	}

	public CmsStartpage(String id){
		super(id);
	}

	@Length(min=0, max=255, message="图片ID长度必须介于 0 和 255 之间")
	public String getImgid() {
		return imgid;
	}

	public void setImgid(String imgid) {
		this.imgid = imgid;
	}
	
	@Length(min=0, max=255, message="图片URL长度必须介于 0 和 255 之间")
	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}
	
	@Length(min=0, max=20, message="图片宽度长度必须介于 0 和 20 之间")
	public String getWidth() {
		return width;
	}

	public void setWidth(String width) {
		this.width = width;
	}
	
	@Length(min=0, max=20, message="图片高度长度必须介于 0 和 20 之间")
	public String getHeight() {
		return height;
	}

	public void setHeight(String height) {
		this.height = height;
	}
	
	@Length(min=0, max=20, message="是否使用默认启动图片长度必须介于 0 和 20 之间")
	public String getIsdefault() {
		return isdefault;
	}

	public void setIsdefault(String isdefault) {
		this.isdefault = isdefault;
	}
	
	@Length(min=0, max=255, message="区域长度必须介于 0 和 255 之间")
	public String getZonecode() {
		return zonecode;
	}

	public void setZonecode(String zonecode) {
		this.zonecode = zonecode;
	}
	
	@Length(min=0, max=20, message="平台长度必须介于 0 和 20 之间")
	public String getPlatform() {
		return platform;
	}

	public void setPlatform(String platform) {
		this.platform = platform;
	}
	
	@Length(min=0, max=20, message="Android倒计时长度必须介于 0 和 20 之间")
	public String getAndroidcountdown() {
		return androidcountdown;
	}

	public void setAndroidcountdown(String androidcountdown) {
		this.androidcountdown = androidcountdown;
	}
	
	@Length(min=0, max=20, message="IOS倒计时长度必须介于 0 和 20 之间")
	public String getIoscountdown() {
		return ioscountdown;
	}

	public void setIoscountdown(String ioscountdown) {
		this.ioscountdown = ioscountdown;
	}
	
	@Length(min=0, max=20, message="倒计时操作长度必须介于 0 和 20 之间")
	public String getShowtimer() {
		return showtimer;
	}

	public void setShowtimer(String showtimer) {
		this.showtimer = showtimer;
	}
	
	@Length(min=0, max=20, message="显示比率长度必须介于 0 和 20 之间")
	public String getRate() {
		return rate;
	}

	public void setRate(String rate) {
		this.rate = rate;
	}
	
	@Length(min=0, max=20, message="状态长度必须介于 0 和 20 之间")
	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
	
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	public Date getOnlinestarttime() {
		return onlinestarttime;
	}

	public void setOnlinestarttime(Date onlinestarttime) {
		this.onlinestarttime = onlinestarttime;
	}
	
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	public Date getOnlineendtime() {
		return onlineendtime;
	}

	public void setOnlineendtime(Date onlineendtime) {
		this.onlineendtime = onlineendtime;
	}
	
	@Length(min=0, max=255, message="描述长度必须介于 0 和 255 之间")
	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	public Date getPublishtime() {
		return publishtime;
	}

	public void setPublishtime(Date publishtime) {
		this.publishtime = publishtime;
	}
	
}