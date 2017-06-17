/**
 * Copyright &copy; 2017-2018 <a href="http://zhaopin.com">zhaopin.com</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.cms.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.thinkgem.jeesite.common.config.Global;
import com.thinkgem.jeesite.common.persistence.Page;
import com.thinkgem.jeesite.common.web.BaseController;
import com.thinkgem.jeesite.common.utils.StringUtils;
import com.thinkgem.jeesite.modules.cms.entity.CmsCompTest;
import com.thinkgem.jeesite.modules.cms.service.CmsCompTestService;

/**
 * 综合测试Controller
 * @author SYJ
 * @version 2017-06-13
 */
@Controller
@RequestMapping(value = "${adminPath}/cms/cmsCompTest")
public class CmsCompTestController extends BaseController {

	@Autowired
	private CmsCompTestService cmsCompTestService;
	
	@ModelAttribute
	public CmsCompTest get(@RequestParam(required=false) String id) {
		CmsCompTest entity = null;
		if (StringUtils.isNotBlank(id)){
			entity = cmsCompTestService.get(id);
		}
		if (entity == null){
			entity = new CmsCompTest();
		}
		return entity;
	}
	
	@RequiresPermissions("cms:cmsCompTest:view")
	@RequestMapping(value = {"list", ""})
	public String list(CmsCompTest cmsCompTest, HttpServletRequest request, HttpServletResponse response, Model model) {
		Page<CmsCompTest> page = cmsCompTestService.findPage(new Page<CmsCompTest>(request, response), cmsCompTest); 
		model.addAttribute("page", page);
		return "modules/cms/cmsCompTestList";
	}

	@RequiresPermissions("cms:cmsCompTest:view")
	@RequestMapping(value = "form")
	public String form(CmsCompTest cmsCompTest, Model model) {
		model.addAttribute("cmsCompTest", cmsCompTest);
		return "modules/cms/cmsCompTestForm";
	}

	@RequiresPermissions("cms:cmsCompTest:edit")
	@RequestMapping(value = "save")
	public String save(CmsCompTest cmsCompTest, Model model, RedirectAttributes redirectAttributes) {
		if (!beanValidator(model, cmsCompTest)){
			return form(cmsCompTest, model);
		}
		cmsCompTestService.save(cmsCompTest);
		addMessage(redirectAttributes, "保存综合测试成功");
		return "redirect:"+Global.getAdminPath()+"/cms/cmsCompTest/?repage";
	}
	
	@RequiresPermissions("cms:cmsCompTest:edit")
	@RequestMapping(value = "delete")
	public String delete(CmsCompTest cmsCompTest, RedirectAttributes redirectAttributes) {
		cmsCompTestService.delete(cmsCompTest);
		addMessage(redirectAttributes, "删除综合测试成功");
		return "redirect:"+Global.getAdminPath()+"/cms/cmsCompTest/?repage";
	}

}