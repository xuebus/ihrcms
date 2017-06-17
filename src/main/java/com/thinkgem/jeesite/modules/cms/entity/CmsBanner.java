/**
 * Copyright &copy; 2017-2018 <a href="http://zhaopin.com">zhaopin.com</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.cms.entity;

import org.hibernate.validator.constraints.Length;
import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;

import com.thinkgem.jeesite.common.persistence.DataEntity;

/**
 * Banner管理Entity
 * @author SYJ
 * @version 2017-06-13
 */
public class CmsBanner extends DataEntity<CmsBanner> {
	
	private static final long serialVersionUID = 1L;
	private String bname;		// Banner名称
	private String bremark;		// 备注
	private String btype;		// 类型
	private String jumpurl;		// 跳转URL
	private String bparas;		// 参数
	private Date starttime;		// 上线时间
	private Date endtime;		// 下线时间
	private String citycode;		// 区域
	private String version;		// 版本
	private String sn;		// 排序
	private String status;		// 状态
	private String imgurl;		// 图片URL
	private Date createtime;		// 创建时间
	private String fileupload;		// 上传文件
	
	public CmsBanner() {
		super();
	}

	public CmsBanner(String id){
		super(id);
	}

	@Length(min=0, max=255, message="Banner名称长度必须介于 0 和 255 之间")
	public String getBname() {
		return bname;
	}

	public void setBname(String bname) {
		this.bname = bname;
	}
	
	@Length(min=0, max=255, message="备注长度必须介于 0 和 255 之间")
	public String getBremark() {
		return bremark;
	}

	public void setBremark(String bremark) {
		this.bremark = bremark;
	}
	
	@Length(min=0, max=20, message="类型长度必须介于 0 和 20 之间")
	public String getBtype() {
		return btype;
	}

	public void setBtype(String btype) {
		this.btype = btype;
	}
	
	@Length(min=0, max=255, message="跳转URL长度必须介于 0 和 255 之间")
	public String getJumpurl() {
		return jumpurl;
	}

	public void setJumpurl(String jumpurl) {
		this.jumpurl = jumpurl;
	}
	
	@Length(min=0, max=255, message="参数长度必须介于 0 和 255 之间")
	public String getBparas() {
		return bparas;
	}

	public void setBparas(String bparas) {
		this.bparas = bparas;
	}
	
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	public Date getStarttime() {
		return starttime;
	}

	public void setStarttime(Date starttime) {
		this.starttime = starttime;
	}
	
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	public Date getEndtime() {
		return endtime;
	}

	public void setEndtime(Date endtime) {
		this.endtime = endtime;
	}
	
	@Length(min=0, max=255, message="区域长度必须介于 0 和 255 之间")
	public String getCitycode() {
		return citycode;
	}

	public void setCitycode(String citycode) {
		this.citycode = citycode;
	}
	
	@Length(min=0, max=255, message="版本长度必须介于 0 和 255 之间")
	public String getVersion() {
		return version;
	}

	public void setVersion(String version) {
		this.version = version;
	}
	
	@Length(min=0, max=20, message="排序长度必须介于 0 和 20 之间")
	public String getSn() {
		return sn;
	}

	public void setSn(String sn) {
		this.sn = sn;
	}
	
	@Length(min=0, max=20, message="状态长度必须介于 0 和 20 之间")
	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
	
	@Length(min=0, max=255, message="图片URL长度必须介于 0 和 255 之间")
	public String getImgurl() {
		return imgurl;
	}

	public void setImgurl(String imgurl) {
		this.imgurl = imgurl;
	}
	
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	public Date getCreatetime() {
		return createtime;
	}

	public void setCreatetime(Date createtime) {
		this.createtime = createtime;
	}
	
	@Length(min=0, max=255, message="上传文件长度必须介于 0 和 255 之间")
	public String getFileupload() {
		return fileupload;
	}

	public void setFileupload(String fileupload) {
		this.fileupload = fileupload;
	}
	
}