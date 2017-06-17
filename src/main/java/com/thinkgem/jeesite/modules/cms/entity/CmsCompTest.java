/**
 * Copyright &copy; 2017-2018 <a href="http://zhaopin.com">zhaopin.com</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.cms.entity;

import org.hibernate.validator.constraints.Length;
import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;

import com.thinkgem.jeesite.common.persistence.DataEntity;

/**
 * 综合测试Entity
 * @author SYJ
 * @version 2017-06-13
 */
public class CmsCompTest extends DataEntity<CmsCompTest> {
	
	private static final long serialVersionUID = 1L;
	private String singletext;		// 单行文本
	private String multitext;		// 多行文本
	private String dropdown;		// 下拉选项
	private String radiobtn;		// 单选按钮
	private String checkbox;		// 复选框
	private Date dateselection;		// 日期选择
	private String personselection;		// 人员选择
	private String sectorselection;		// 部门选择
	private String regionalchoice;		// 区域选择
	private String treeselectioncontrol;		// 树选择控件
	private String fileuploadselection;		// 文件上传选择
	
	public CmsCompTest() {
		super();
	}

	public CmsCompTest(String id){
		super(id);
	}

	@Length(min=0, max=255, message="单行文本长度必须介于 0 和 255 之间")
	public String getSingletext() {
		return singletext;
	}

	public void setSingletext(String singletext) {
		this.singletext = singletext;
	}
	
	@Length(min=0, max=255, message="多行文本长度必须介于 0 和 255 之间")
	public String getMultitext() {
		return multitext;
	}

	public void setMultitext(String multitext) {
		this.multitext = multitext;
	}
	
	@Length(min=0, max=20, message="下拉选项长度必须介于 0 和 20 之间")
	public String getDropdown() {
		return dropdown;
	}

	public void setDropdown(String dropdown) {
		this.dropdown = dropdown;
	}
	
	@Length(min=0, max=20, message="单选按钮长度必须介于 0 和 20 之间")
	public String getRadiobtn() {
		return radiobtn;
	}

	public void setRadiobtn(String radiobtn) {
		this.radiobtn = radiobtn;
	}
	
	@Length(min=0, max=255, message="复选框长度必须介于 0 和 255 之间")
	public String getCheckbox() {
		return checkbox;
	}

	public void setCheckbox(String checkbox) {
		this.checkbox = checkbox;
	}
	
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	public Date getDateselection() {
		return dateselection;
	}

	public void setDateselection(Date dateselection) {
		this.dateselection = dateselection;
	}
	
	@Length(min=0, max=255, message="人员选择长度必须介于 0 和 255 之间")
	public String getPersonselection() {
		return personselection;
	}

	public void setPersonselection(String personselection) {
		this.personselection = personselection;
	}
	
	@Length(min=0, max=255, message="部门选择长度必须介于 0 和 255 之间")
	public String getSectorselection() {
		return sectorselection;
	}

	public void setSectorselection(String sectorselection) {
		this.sectorselection = sectorselection;
	}
	
	@Length(min=0, max=255, message="区域选择长度必须介于 0 和 255 之间")
	public String getRegionalchoice() {
		return regionalchoice;
	}

	public void setRegionalchoice(String regionalchoice) {
		this.regionalchoice = regionalchoice;
	}
	
	@Length(min=0, max=255, message="树选择控件长度必须介于 0 和 255 之间")
	public String getTreeselectioncontrol() {
		return treeselectioncontrol;
	}

	public void setTreeselectioncontrol(String treeselectioncontrol) {
		this.treeselectioncontrol = treeselectioncontrol;
	}
	
	@Length(min=0, max=255, message="文件上传选择长度必须介于 0 和 255 之间")
	public String getFileuploadselection() {
		return fileuploadselection;
	}

	public void setFileuploadselection(String fileuploadselection) {
		this.fileuploadselection = fileuploadselection;
	}
	
}