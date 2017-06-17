/**
 * Copyright &copy; 2017-2018 <a href="http://zhaopin.com">zhaopin.com</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.cms.entity;

import org.hibernate.validator.constraints.Length;
import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;

import com.thinkgem.jeesite.common.persistence.DataEntity;

/**
 * 名片管理Entity
 * @author SYJ
 * @version 2017-06-13
 */
public class CmsCard extends DataEntity<CmsCard> {
	
	private static final long serialVersionUID = 1L;
	private String cardnum;		// 名片编号
	private String resumenum;		// 简历编号
	private String cardurl;		// 名片URL
	private Date createtime;		// 创建时间
	private Date verifytime;		// 审核时间
	private String status;		// 状态
	
	public CmsCard() {
		super();
	}

	public CmsCard(String id){
		super(id);
	}

	@Length(min=0, max=20, message="名片编号长度必须介于 0 和 20 之间")
	public String getCardnum() {
		return cardnum;
	}

	public void setCardnum(String cardnum) {
		this.cardnum = cardnum;
	}
	
	@Length(min=0, max=255, message="简历编号长度必须介于 0 和 255 之间")
	public String getResumenum() {
		return resumenum;
	}

	public void setResumenum(String resumenum) {
		this.resumenum = resumenum;
	}
	
	@Length(min=0, max=255, message="名片URL长度必须介于 0 和 255 之间")
	public String getCardurl() {
		return cardurl;
	}

	public void setCardurl(String cardurl) {
		this.cardurl = cardurl;
	}
	
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	public Date getCreatetime() {
		return createtime;
	}

	public void setCreatetime(Date createtime) {
		this.createtime = createtime;
	}
	
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	public Date getVerifytime() {
		return verifytime;
	}

	public void setVerifytime(Date verifytime) {
		this.verifytime = verifytime;
	}
	
	@Length(min=0, max=20, message="状态长度必须介于 0 和 20 之间")
	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
	
}