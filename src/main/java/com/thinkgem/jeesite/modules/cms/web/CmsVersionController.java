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
import com.thinkgem.jeesite.modules.cms.entity.CmsVersion;
import com.thinkgem.jeesite.modules.cms.service.CmsVersionService;

/**
 * 版本管理Controller
 * @author SYJ
 * @version 2017-06-13
 */
@Controller
@RequestMapping(value = "${adminPath}/cms/cmsVersion")
public class CmsVersionController extends BaseController {

	@Autowired
	private CmsVersionService cmsVersionService;
	
	@ModelAttribute
	public CmsVersion get(@RequestParam(required=false) String id) {
		CmsVersion entity = null;
		if (StringUtils.isNotBlank(id)){
			entity = cmsVersionService.get(id);
		}
		if (entity == null){
			entity = new CmsVersion();
		}
		return entity;
	}
	
	@RequiresPermissions("cms:cmsVersion:view")
	@RequestMapping(value = {"list", ""})
	public String list(CmsVersion cmsVersion, HttpServletRequest request, HttpServletResponse response, Model model) {
		Page<CmsVersion> page = cmsVersionService.findPage(new Page<CmsVersion>(request, response), cmsVersion); 
		model.addAttribute("page", page);
		return "modules/cms/cmsVersionList";
	}

	@RequiresPermissions("cms:cmsVersion:view")
	@RequestMapping(value = "form")
	public String form(CmsVersion cmsVersion, Model model) {
		model.addAttribute("cmsVersion", cmsVersion);
		return "modules/cms/cmsVersionForm";
	}

	@RequiresPermissions("cms:cmsVersion:edit")
	@RequestMapping(value = "save")
	public String save(CmsVersion cmsVersion, Model model, RedirectAttributes redirectAttributes) {
		if (!beanValidator(model, cmsVersion)){
			return form(cmsVersion, model);
		}
		cmsVersionService.save(cmsVersion);
		addMessage(redirectAttributes, "保存版本成功");
		return "redirect:"+Global.getAdminPath()+"/cms/cmsVersion/?repage";
	}
	
	@RequiresPermissions("cms:cmsVersion:edit")
	@RequestMapping(value = "delete")
	public String delete(CmsVersion cmsVersion, RedirectAttributes redirectAttributes) {
		cmsVersionService.delete(cmsVersion);
		addMessage(redirectAttributes, "删除版本成功");
		return "redirect:"+Global.getAdminPath()+"/cms/cmsVersion/?repage";
	}

}