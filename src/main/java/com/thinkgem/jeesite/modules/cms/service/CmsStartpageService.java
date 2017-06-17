/**
 * Copyright &copy; 2017-2018 <a href="http://zhaopin.com">zhaopin.com</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.cms.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.thinkgem.jeesite.common.persistence.Page;
import com.thinkgem.jeesite.common.service.CrudService;
import com.thinkgem.jeesite.modules.cms.entity.CmsStartpage;
import com.thinkgem.jeesite.modules.cms.dao.CmsStartpageDao;

/**
 * 启动页管理Service
 * @author SYJ
 * @version 2017-06-13
 */
@Service
@Transactional(readOnly = true)
public class CmsStartpageService extends CrudService<CmsStartpageDao, CmsStartpage> {

	public CmsStartpage get(String id) {
		return super.get(id);
	}
	
	public List<CmsStartpage> findList(CmsStartpage cmsStartpage) {
		return super.findList(cmsStartpage);
	}
	
	public Page<CmsStartpage> findPage(Page<CmsStartpage> page, CmsStartpage cmsStartpage) {
		return super.findPage(page, cmsStartpage);
	}
	
	@Transactional(readOnly = false)
	public void save(CmsStartpage cmsStartpage) {
		super.save(cmsStartpage);
	}
	
	@Transactional(readOnly = false)
	public void delete(CmsStartpage cmsStartpage) {
		super.delete(cmsStartpage);
	}
	
}