<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<html>
<head>
	<title>综合测试管理</title>
	<meta name="decorator" content="default"/>
	<script type="text/javascript">
		$(document).ready(function() {
			
		});
		function page(n,s){
			$("#pageNo").val(n);
			$("#pageSize").val(s);
			$("#searchForm").submit();
        	return false;
        }
	</script>
</head>
<body>
	<ul class="nav nav-tabs">
		<li class="active"><a href="${ctx}/cms/cmsCompTest/">综合测试列表</a></li>
		<shiro:hasPermission name="cms:cmsCompTest:edit"><li><a href="${ctx}/cms/cmsCompTest/form">综合测试添加</a></li></shiro:hasPermission>
	</ul>
	<form:form id="searchForm" modelAttribute="cmsCompTest" action="${ctx}/cms/cmsCompTest/" method="post" class="breadcrumb form-search">
		<input id="pageNo" name="pageNo" type="hidden" value="${page.pageNo}"/>
		<input id="pageSize" name="pageSize" type="hidden" value="${page.pageSize}"/>
		<ul class="ul-form">
			<li><label>主键：</label>
				<form:input path="id" htmlEscape="false" maxlength="255" class="input-medium"/>
			</li>
			<li><label>单行文本：</label>
				<form:input path="singletext" htmlEscape="false" maxlength="255" class="input-medium"/>
			</li>
			<li><label>多行文本：</label>
				<form:input path="multitext" htmlEscape="false" maxlength="255" class="input-medium"/>
			</li>
			<li><label>下拉选项：</label>
				<form:select path="dropdown" class="input-medium">
					<form:option value="" label=""/>
					<form:options items="${fns:getDictList('sys_area_type')}" itemLabel="label" itemValue="value" htmlEscape="false"/>
				</form:select>
			</li>
			<li><label>单选按钮：</label>
				<form:radiobuttons path="radiobtn" items="${fns:getDictList('oa_leave_type')}" itemLabel="label" itemValue="value" htmlEscape="false"/>
			</li>
			<li><label>复选框：</label>
				<form:checkboxes path="checkbox" items="${fns:getDictList('cms_posid')}" itemLabel="label" itemValue="value" htmlEscape="false"/>
			</li>
			<li><label>日期选择：</label>
				<input name="dateselection" type="text" readonly="readonly" maxlength="20" class="input-medium Wdate"
					value="<fmt:formatDate value="${cmsCompTest.dateselection}" pattern="yyyy-MM-dd HH:mm:ss"/>"
					onclick="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss',isShowClear:false});"/>
			</li>
			<li><label>人员选择：</label>
				<sys:treeselect id="personselection" name="personselection" value="${cmsCompTest.personselection}" labelName="" labelValue="${cmsCompTest.personselection}"
					title="用户" url="/sys/office/treeData?type=3" cssClass="input-small" allowClear="true" notAllowSelectParent="true"/>
			</li>
			<li><label>部门选择：</label>
				<sys:treeselect id="sectorselection" name="sectorselection" value="${cmsCompTest.sectorselection}" labelName="" labelValue="${cmsCompTest.sectorselection}"
					title="部门" url="/sys/office/treeData?type=2" cssClass="input-small" allowClear="true" notAllowSelectParent="true"/>
			</li>
			<li><label>区域选择：</label>
				<sys:treeselect id="regionalchoice" name="regionalchoice" value="${cmsCompTest.regionalchoice}" labelName="" labelValue="${cmsCompTest.regionalchoice}"
					title="区域" url="/sys/area/treeData" cssClass="input-small" allowClear="true" notAllowSelectParent="true"/>
			</li>
			<li><label>树选择控件：</label>
			</li>
			<li><label>文件上传选择：</label>
			</li>
			<li class="btns"><input id="btnSubmit" class="btn btn-primary" type="submit" value="查询"/></li>
			<li class="clearfix"></li>
		</ul>
	</form:form>
	<sys:message content="${message}"/>
	<table id="contentTable" class="table table-striped table-bordered table-condensed">
		<thead>
			<tr>
				<th>主键</th>
				<th>单行文本</th>
				<th>多行文本</th>
				<th>下拉选项</th>
				<th>单选按钮</th>
				<th>复选框</th>
				<th>日期选择</th>
				<th>人员选择</th>
				<th>部门选择</th>
				<th>区域选择</th>
				<th>树选择控件</th>
				<th>文件上传选择</th>
				<shiro:hasPermission name="cms:cmsCompTest:edit"><th>操作</th></shiro:hasPermission>
			</tr>
		</thead>
		<tbody>
		<c:forEach items="${page.list}" var="cmsCompTest">
			<tr>
				<td><a href="${ctx}/cms/cmsCompTest/form?id=${cmsCompTest.id}">
					${cmsCompTest.id}
				</a></td>
				<td>
					${cmsCompTest.singletext}
				</td>
				<td>
					${cmsCompTest.multitext}
				</td>
				<td>
					${fns:getDictLabel(cmsCompTest.dropdown, 'sys_area_type', '')}
				</td>
				<td>
					${fns:getDictLabel(cmsCompTest.radiobtn, 'oa_leave_type', '')}
				</td>
				<td>
					${fns:getDictLabel(cmsCompTest.checkbox, 'cms_posid', '')}
				</td>
				<td>
					<fmt:formatDate value="${cmsCompTest.dateselection}" pattern="yyyy-MM-dd HH:mm:ss"/>
				</td>
				<td>
					${cmsCompTest.personselection}
				</td>
				<td>
					${cmsCompTest.sectorselection}
				</td>
				<td>
					${cmsCompTest.regionalchoice}
				</td>
				<td>
					${cmsCompTest.treeselectioncontrol}
				</td>
				<td>
					${cmsCompTest.fileuploadselection}
				</td>
				<shiro:hasPermission name="cms:cmsCompTest:edit"><td>
    				<a href="${ctx}/cms/cmsCompTest/form?id=${cmsCompTest.id}">修改</a>
					<a href="${ctx}/cms/cmsCompTest/delete?id=${cmsCompTest.id}" onclick="return confirmx('确认要删除该综合测试吗？', this.href)">删除</a>
				</td></shiro:hasPermission>
			</tr>
		</c:forEach>
		</tbody>
	</table>
	<div class="pagination">${page}</div>
</body>
</html>