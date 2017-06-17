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
import com.thinkgem.jeesite.modules.cms.entity.CmsSecretary;
import com.thinkgem.jeesite.modules.cms.service.CmsSecretaryService;

/**
 * 小秘管理Controller
 * @author SYJ
 * @version 2017-06-13
 */
@Controller
@RequestMapping(value = "${adminPath}/cms/cmsSecretary")
public class CmsSecretaryController extends BaseController {

	@Autowired
	private CmsSecretaryService cmsSecretaryService;
	
	@ModelAttribute
	public CmsSecretary get(@RequestParam(required=false) String id) {
		CmsSecretary entity = null;
		if (StringUtils.isNotBlank(id)){
			entity = cmsSecretaryService.get(id);
		}
		if (entity == null){
			entity = new CmsSecretary();
		}
		return entity;
	}
	
	@RequiresPermissions("cms:cmsSecretary:view")
	@RequestMapping(value = {"list", ""})
	public String list(CmsSecretary cmsSecretary, HttpServletRequest request, HttpServletResponse response, Model model) {
		Page<CmsSecretary> page = cmsSecretaryService.findPage(new Page<CmsSecretary>(request, response), cmsSecretary); 
		model.addAttribute("page", page);
		return "modules/cms/cmsSecretaryList";
	}

	@RequiresPermissions("cms:cmsSecretary:view")
	@RequestMapping(value = "form")
	public String form(CmsSecretary cmsSecretary, Model model) {
		model.addAttribute("cmsSecretary", cmsSecretary);
		return "modules/cms/cmsSecretaryForm";
	}

	@RequiresPermissions("cms:cmsSecretary:edit")
	@RequestMapping(value = "save")
	public String save(CmsSecretary cmsSecretary, Model model, RedirectAttributes redirectAttributes) {
		if (!beanValidator(model, cmsSecretary)){
			return form(cmsSecretary, model);
		}
		cmsSecretaryService.save(cmsSecretary);
		addMessage(redirectAttributes, "保存小秘成功");
		return "redirect:"+Global.getAdminPath()+"/cms/cmsSecretary/?repage";
	}
	
	@RequiresPermissions("cms:cmsSecretary:edit")
	@RequestMapping(value = "delete")
	public String delete(CmsSecretary cmsSecretary, RedirectAttributes redirectAttributes) {
		cmsSecretaryService.delete(cmsSecretary);
		addMessage(redirectAttributes, "删除小秘成功");
		return "redirect:"+Global.getAdminPath()+"/cms/cmsSecretary/?repage";
	}

}