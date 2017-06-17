/**
 * Copyright &copy; 2017-2018 <a href="http://zhaopin.com">zhaopin.com</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.cms.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.thinkgem.jeesite.common.persistence.Page;
import com.thinkgem.jeesite.common.service.CrudService;
import com.thinkgem.jeesite.modules.cms.entity.CmsSecretary;
import com.thinkgem.jeesite.modules.cms.dao.CmsSecretaryDao;

/**
 * 小秘管理Service
 * @author SYJ
 * @version 2017-06-13
 */
@Service
@Transactional(readOnly = true)
public class CmsSecretaryService extends CrudService<CmsSecretaryDao, CmsSecretary> {

	public CmsSecretary get(String id) {
		return super.get(id);
	}
	
	public List<CmsSecretary> findList(CmsSecretary cmsSecretary) {
		return super.findList(cmsSecretary);
	}
	
	public Page<CmsSecretary> findPage(Page<CmsSecretary> page, CmsSecretary cmsSecretary) {
		return super.findPage(page, cmsSecretary);
	}
	
	@Transactional(readOnly = false)
	public void save(CmsSecretary cmsSecretary) {
		super.save(cmsSecretary);
	}
	
	@Transactional(readOnly = false)
	public void delete(CmsSecretary cmsSecretary) {
		super.delete(cmsSecretary);
	}
	
}