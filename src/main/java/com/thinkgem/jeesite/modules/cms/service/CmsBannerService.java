/**
 * Copyright &copy; 2017-2018 <a href="http://zhaopin.com">zhaopin.com</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.cms.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.thinkgem.jeesite.common.persistence.Page;
import com.thinkgem.jeesite.common.service.CrudService;
import com.thinkgem.jeesite.modules.cms.entity.CmsBanner;
import com.thinkgem.jeesite.modules.cms.dao.CmsBannerDao;

/**
 * Banner管理Service
 * @author SYJ
 * @version 2017-06-13
 */
@Service
@Transactional(readOnly = true)
public class CmsBannerService extends CrudService<CmsBannerDao, CmsBanner> {

	public CmsBanner get(String id) {
		return super.get(id);
	}
	
	public List<CmsBanner> findList(CmsBanner cmsBanner) {
		return super.findList(cmsBanner);
	}
	
	public Page<CmsBanner> findPage(Page<CmsBanner> page, CmsBanner cmsBanner) {
		return super.findPage(page, cmsBanner);
	}
	
	@Transactional(readOnly = false)
	public void save(CmsBanner cmsBanner) {
		super.save(cmsBanner);
	}
	
	@Transactional(readOnly = false)
	public void delete(CmsBanner cmsBanner) {
		super.delete(cmsBanner);
	}
	
}