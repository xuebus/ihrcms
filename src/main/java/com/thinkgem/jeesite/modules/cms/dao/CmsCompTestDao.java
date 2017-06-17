/**
 * Copyright &copy; 2017-2018 <a href="http://zhaopin.com">zhaopin.com</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.cms.dao;

import com.thinkgem.jeesite.common.persistence.CrudDao;
import com.thinkgem.jeesite.common.persistence.annotation.MyBatisDao;
import com.thinkgem.jeesite.modules.cms.entity.CmsCompTest;

/**
 * 综合测试DAO接口
 * @author SYJ
 * @version 2017-06-13
 */
@MyBatisDao
public interface CmsCompTestDao extends CrudDao<CmsCompTest> {
	
}