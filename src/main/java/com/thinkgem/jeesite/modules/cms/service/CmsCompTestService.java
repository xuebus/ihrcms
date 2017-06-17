/**
 * Copyright &copy; 2017-2018 <a href="http://zhaopin.com">zhaopin.com</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.cms.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.thinkgem.jeesite.common.persistence.Page;
import com.thinkgem.jeesite.common.service.CrudService;
import com.thinkgem.jeesite.modules.cms.entity.CmsCompTest;
import com.thinkgem.jeesite.modules.cms.dao.CmsCompTestDao;

/**
 * 综合测试Service
 * @author SYJ
 * @version 2017-06-13
 */
@Service
@Transactional(readOnly = true)
public class CmsCompTestService extends CrudService<CmsCompTestDao, CmsCompTest> {

	public CmsCompTest get(String id) {
		return super.get(id);
	}
	
	public List<CmsCompTest> findList(CmsCompTest cmsCompTest) {
		return super.findList(cmsCompTest);
	}
	
	public Page<CmsCompTest> findPage(Page<CmsCompTest> page, CmsCompTest cmsCompTest) {
		return super.findPage(page, cmsCompTest);
	}
	
	@Transactional(readOnly = false)
	public void save(CmsCompTest cmsCompTest) {
		super.save(cmsCompTest);
	}
	
	@Transactional(readOnly = false)
	public void delete(CmsCompTest cmsCompTest) {
		super.delete(cmsCompTest);
	}
	
}