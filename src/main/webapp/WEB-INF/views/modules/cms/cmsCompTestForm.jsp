<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<html>
<head>
	<title>综合测试管理</title>
	<meta name="decorator" content="default"/>
	<script type="text/javascript">
		$(document).ready(function() {
			//$("#name").focus();
			$("#inputForm").validate({
				submitHandler: function(form){
					loading('正在提交，请稍等...');
					form.submit();
				},
				errorContainer: "#messageBox",
				errorPlacement: function(error, element) {
					$("#messageBox").text("输入有误，请先更正。");
					if (element.is(":checkbox")||element.is(":radio")||element.parent().is(".input-append")){
						error.appendTo(element.parent().parent());
					} else {
						error.insertAfter(element);
					}
				}
			});
		});
	</script>
</head>
<body>
	<ul class="nav nav-tabs">
		<li><a href="${ctx}/cms/cmsCompTest/">综合测试列表</a></li>
		<li class="active"><a href="${ctx}/cms/cmsCompTest/form?id=${cmsCompTest.id}">综合测试<shiro:hasPermission name="cms:cmsCompTest:edit">${not empty cmsCompTest.id?'修改':'添加'}</shiro:hasPermission><shiro:lacksPermission name="cms:cmsCompTest:edit">查看</shiro:lacksPermission></a></li>
	</ul><br/>
	<form:form id="inputForm" modelAttribute="cmsCompTest" action="${ctx}/cms/cmsCompTest/save" method="post" class="form-horizontal">
		<form:hidden path="id"/>
		<sys:message content="${message}"/>		
		<div class="control-group">
			<label class="control-label">单行文本：</label>
			<div class="controls">
				<form:input path="singletext" htmlEscape="false" maxlength="255" class="input-xlarge "/>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">多行文本：</label>
			<div class="controls">
				<form:textarea path="multitext" htmlEscape="false" rows="4" maxlength="255" class="input-xxlarge "/>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">下拉选项：</label>
			<div class="controls">
				<form:select path="dropdown" class="input-xlarge ">
					<form:option value="" label=""/>
					<form:options items="${fns:getDictList('sys_area_type')}" itemLabel="label" itemValue="value" htmlEscape="false"/>
				</form:select>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">单选按钮：</label>
			<div class="controls">
				<form:radiobuttons path="radiobtn" items="${fns:getDictList('oa_leave_type')}" itemLabel="label" itemValue="value" htmlEscape="false" class=""/>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">复选框：</label>
			<div class="controls">
				<form:checkboxes path="checkbox" items="${fns:getDictList('cms_posid')}" itemLabel="label" itemValue="value" htmlEscape="false" class=""/>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">日期选择：</label>
			<div class="controls">
				<input name="dateselection" type="text" readonly="readonly" maxlength="20" class="input-medium Wdate "
					value="<fmt:formatDate value="${cmsCompTest.dateselection}" pattern="yyyy-MM-dd HH:mm:ss"/>"
					onclick="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss',isShowClear:false});"/>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">人员选择：</label>
			<div class="controls">
				<sys:treeselect id="personselection" name="personselection" value="${cmsCompTest.personselection}" labelName="" labelValue="${cmsCompTest.personselection}"
					title="用户" url="/sys/office/treeData?type=3" cssClass="" allowClear="true" notAllowSelectParent="true"/>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">部门选择：</label>
			<div class="controls">
				<sys:treeselect id="sectorselection" name="sectorselection" value="${cmsCompTest.sectorselection}" labelName="" labelValue="${cmsCompTest.sectorselection}"
					title="部门" url="/sys/office/treeData?type=2" cssClass="" allowClear="true" notAllowSelectParent="true"/>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">区域选择：</label>
			<div class="controls">
				<sys:treeselect id="regionalchoice" name="regionalchoice" value="${cmsCompTest.regionalchoice}" labelName="" labelValue="${cmsCompTest.regionalchoice}"
					title="区域" url="/sys/area/treeData" cssClass="" allowClear="true" notAllowSelectParent="true"/>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">树选择控件：</label>
			<div class="controls">
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">文件上传选择：</label>
			<div class="controls">
				<form:hidden id="fileuploadselection" path="fileuploadselection" htmlEscape="false" maxlength="255" class="input-xlarge"/>
				<sys:ckfinder input="fileuploadselection" type="files" uploadPath="/cms/cmsCompTest" selectMultiple="true"/>
			</div>
		</div>
		<div class="form-actions">
			<shiro:hasPermission name="cms:cmsCompTest:edit"><input id="btnSubmit" class="btn btn-primary" type="submit" value="保 存"/>&nbsp;</shiro:hasPermission>
			<input id="btnCancel" class="btn" type="button" value="返 回" onclick="history.go(-1)"/>
		</div>
	</form:form>
</body>
</html>