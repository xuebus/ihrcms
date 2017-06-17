/**
 * Copyright &copy; 2017-2018 <a href="http://zhaopin.com">zhaopin.com</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.cms.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.thinkgem.jeesite.common.persistence.Page;
import com.thinkgem.jeesite.common.service.CrudService;
import com.thinkgem.jeesite.modules.cms.entity.CmsCard;
import com.thinkgem.jeesite.modules.cms.dao.CmsCardDao;

/**
 * 名片管理Service
 * @author SYJ
 * @version 2017-06-13
 */
@Service
@Transactional(readOnly = true)
public class CmsCardService extends CrudService<CmsCardDao, CmsCard> {

	public CmsCard get(String id) {
		return super.get(id);
	}
	
	public List<CmsCard> findList(CmsCard cmsCard) {
		return super.findList(cmsCard);
	}
	
	public Page<CmsCard> findPage(Page<CmsCard> page, CmsCard cmsCard) {
		return super.findPage(page, cmsCard);
	}
	
	@Transactional(readOnly = false)
	public void save(CmsCard cmsCard) {
		super.save(cmsCard);
	}
	
	@Transactional(readOnly = false)
	public void delete(CmsCard cmsCard) {
		super.delete(cmsCard);
	}
	
}