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
import com.thinkgem.jeesite.modules.cms.entity.CmsCard;
import com.thinkgem.jeesite.modules.cms.service.CmsCardService;

/**
 * 名片管理Controller
 * @author SYJ
 * @version 2017-06-13
 */
@Controller
@RequestMapping(value = "${adminPath}/cms/cmsCard")
public class CmsCardController extends BaseController {

	@Autowired
	private CmsCardService cmsCardService;
	
	@ModelAttribute
	public CmsCard get(@RequestParam(required=false) String id) {
		CmsCard entity = null;
		if (StringUtils.isNotBlank(id)){
			entity = cmsCardService.get(id);
		}
		if (entity == null){
			entity = new CmsCard();
		}
		return entity;
	}
	
	@RequiresPermissions("cms:cmsCard:view")
	@RequestMapping(value = {"list", ""})
	public String list(CmsCard cmsCard, HttpServletRequest request, HttpServletResponse response, Model model) {
		Page<CmsCard> page = cmsCardService.findPage(new Page<CmsCard>(request, response), cmsCard); 
		model.addAttribute("page", page);
		return "modules/cms/cmsCardList";
	}

	@RequiresPermissions("cms:cmsCard:view")
	@RequestMapping(value = "form")
	public String form(CmsCard cmsCard, Model model) {
		model.addAttribute("cmsCard", cmsCard);
		return "modules/cms/cmsCardForm";
	}

	@RequiresPermissions("cms:cmsCard:edit")
	@RequestMapping(value = "save")
	public String save(CmsCard cmsCard, Model model, RedirectAttributes redirectAttributes) {
		if (!beanValidator(model, cmsCard)){
			return form(cmsCard, model);
		}
		cmsCardService.save(cmsCard);
		addMessage(redirectAttributes, "保存名片成功");
		return "redirect:"+Global.getAdminPath()+"/cms/cmsCard/?repage";
	}
	
	@RequiresPermissions("cms:cmsCard:edit")
	@RequestMapping(value = "delete")
	public String delete(CmsCard cmsCard, RedirectAttributes redirectAttributes) {
		cmsCardService.delete(cmsCard);
		addMessage(redirectAttributes, "删除名片成功");
		return "redirect:"+Global.getAdminPath()+"/cms/cmsCard/?repage";
	}

}