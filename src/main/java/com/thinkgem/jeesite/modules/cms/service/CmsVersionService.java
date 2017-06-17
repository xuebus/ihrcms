/**
 * Copyright &copy; 2017-2018 <a href="http://zhaopin.com">zhaopin.com</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.cms.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.thinkgem.jeesite.common.persistence.Page;
import com.thinkgem.jeesite.common.service.CrudService;
import com.thinkgem.jeesite.modules.cms.entity.CmsVersion;
import com.thinkgem.jeesite.modules.cms.dao.CmsVersionDao;

/**
 * 版本管理Service
 * @author SYJ
 * @version 2017-06-13
 */
@Service
@Transactional(readOnly = true)
public class CmsVersionService extends CrudService<CmsVersionDao, CmsVersion> {

	public CmsVersion get(String id) {
		return super.get(id);
	}
	
	public List<CmsVersion> findList(CmsVersion cmsVersion) {
		return super.findList(cmsVersion);
	}
	
	public Page<CmsVersion> findPage(Page<CmsVersion> page, CmsVersion cmsVersion) {
		return super.findPage(page, cmsVersion);
	}
	
	@Transactional(readOnly = false)
	public void save(CmsVersion cmsVersion) {
		super.save(cmsVersion);
	}
	
	@Transactional(readOnly = false)
	public void delete(CmsVersion cmsVersion) {
		super.delete(cmsVersion);
	}
	
}