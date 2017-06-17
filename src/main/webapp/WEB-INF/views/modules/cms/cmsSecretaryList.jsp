<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<html>
<head>
	<title>小秘管理</title>
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
		<li class="active"><a href="${ctx}/cms/cmsSecretary/">小秘列表</a></li>
		<shiro:hasPermission name="cms:cmsSecretary:edit"><li><a href="${ctx}/cms/cmsSecretary/form">小秘添加</a></li></shiro:hasPermission>
	</ul>
	<%-- <form:form id="searchForm" modelAttribute="cmsSecretary" action="${ctx}/cms/cmsSecretary/" method="post" class="breadcrumb form-search">
		<input id="pageNo" name="pageNo" type="hidden" value="${page.pageNo}"/>
		<input id="pageSize" name="pageSize" type="hidden" value="${page.pageSize}"/>
		<ul class="ul-form">
			<li><label>小秘名称：</label>
				<form:input path="name" htmlEscape="false" maxlength="255" class="input-medium"/>
			</li>
			<li><label>图片：</label>
				<form:input path="img" htmlEscape="false" maxlength="255" class="input-medium"/>
			</li>
			<li><label>开始时间：</label>
				<input name="starttime" type="text" readonly="readonly" maxlength="20" class="input-medium Wdate"
					value="<fmt:formatDate value="${cmsSecretary.starttime}" pattern="yyyy-MM-dd HH:mm:ss"/>"
					onclick="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss',isShowClear:false});"/>
			</li>
			<li><label>结束时间：</label>
				<input name="endtime" type="text" readonly="readonly" maxlength="20" class="input-medium Wdate"
					value="<fmt:formatDate value="${cmsSecretary.endtime}" pattern="yyyy-MM-dd HH:mm:ss"/>"
					onclick="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss',isShowClear:false});"/>
			</li>
			<li><label>类型：</label>
				<form:radiobuttons path="type" items="${fns:getDictList('cms_secretary_type')}" itemLabel="label" itemValue="value" htmlEscape="false"/>
			</li>
			<li><label>状态：</label>
				<form:radiobuttons path="status" items="${fns:getDictList('cms_secretary_status')}" itemLabel="label" itemValue="value" htmlEscape="false"/>
			</li>
			<li class="btns"><input id="btnSubmit" class="btn btn-primary" type="submit" value="查询"/></li>
			<li class="clearfix"></li>
		</ul>
	</form:form> --%>
	<sys:message content="${message}"/>
	<table id="contentTable" class="table table-striped table-bordered table-condensed">
		<thead>
			<tr>
				<th>小秘名称</th>
				<th>图片</th>
				<th>开始时间</th>
				<th>结束时间</th>
				<th>类型</th>
				<th>状态</th>
				<shiro:hasPermission name="cms:cmsSecretary:edit"><th>操作</th></shiro:hasPermission>
			</tr>
		</thead>
		<tbody>
		<c:forEach items="${page.list}" var="cmsSecretary">
			<tr>
				<td><a href="${ctx}/cms/cmsSecretary/form?id=${cmsSecretary.id}">
					${cmsSecretary.name}
				</a></td>
				<td>
					${cmsSecretary.img}
				</td>
				<td>
					<fmt:formatDate value="${cmsSecretary.starttime}" pattern="yyyy-MM-dd HH:mm:ss"/>
				</td>
				<td>
					<fmt:formatDate value="${cmsSecretary.endtime}" pattern="yyyy-MM-dd HH:mm:ss"/>
				</td>
				<td>
					${fns:getDictLabel(cmsSecretary.type, 'cms_secretary_type', '')}
				</td>
				<td>
					${fns:getDictLabel(cmsSecretary.status, 'cms_secretary_status', '')}
				</td>
				<shiro:hasPermission name="cms:cmsSecretary:edit"><td>
    				<a href="${ctx}/cms/cmsSecretary/form?id=${cmsSecretary.id}">修改</a>
					<a href="${ctx}/cms/cmsSecretary/delete?id=${cmsSecretary.id}" onclick="return confirmx('确认要删除该小秘吗？', this.href)">删除</a>
				</td></shiro:hasPermission>
			</tr>
		</c:forEach>
		</tbody>
	</table>
	<div class="pagination">${page}</div>
</body>
</html>