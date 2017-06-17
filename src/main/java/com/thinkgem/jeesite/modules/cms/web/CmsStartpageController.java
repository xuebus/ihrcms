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
import com.thinkgem.jeesite.modules.cms.entity.CmsStartpage;
import com.thinkgem.jeesite.modules.cms.service.CmsStartpageService;

/**
 * 启动页管理Controller
 * @author SYJ
 * @version 2017-06-13
 */
@Controller
@RequestMapping(value = "${adminPath}/cms/cmsStartpage")
public class CmsStartpageController extends BaseController {

	@Autowired
	private CmsStartpageService cmsStartpageService;
	
	@ModelAttribute
	public CmsStartpage get(@RequestParam(required=false) String id) {
		CmsStartpage entity = null;
		if (StringUtils.isNotBlank(id)){
			entity = cmsStartpageService.get(id);
		}
		if (entity == null){
			entity = new CmsStartpage();
		}
		return entity;
	}
	
	@RequiresPermissions("cms:cmsStartpage:view")
	@RequestMapping(value = {"list", ""})
	public String list(CmsStartpage cmsStartpage, HttpServletRequest request, HttpServletResponse response, Model model) {
		Page<CmsStartpage> page = cmsStartpageService.findPage(new Page<CmsStartpage>(request, response), cmsStartpage); 
		model.addAttribute("page", page);
		return "modules/cms/cmsStartpageList";
	}

	@RequiresPermissions("cms:cmsStartpage:view")
	@RequestMapping(value = "form")
	public String form(CmsStartpage cmsStartpage, Model model) {
		model.addAttribute("cmsStartpage", cmsStartpage);
		return "modules/cms/cmsStartpageForm";
	}

	@RequiresPermissions("cms:cmsStartpage:edit")
	@RequestMapping(value = "save")
	public String save(CmsStartpage cmsStartpage, Model model, RedirectAttributes redirectAttributes) {
		if (!beanValidator(model, cmsStartpage)){
			return form(cmsStartpage, model);
		}
		cmsStartpageService.save(cmsStartpage);
		addMessage(redirectAttributes, "保存启动页成功");
		return "redirect:"+Global.getAdminPath()+"/cms/cmsStartpage/?repage";
	}
	
	@RequiresPermissions("cms:cmsStartpage:edit")
	@RequestMapping(value = "delete")
	public String delete(CmsStartpage cmsStartpage, RedirectAttributes redirectAttributes) {
		cmsStartpageService.delete(cmsStartpage);
		addMessage(redirectAttributes, "删除启动页成功");
		return "redirect:"+Global.getAdminPath()+"/cms/cmsStartpage/?repage";
	}

}