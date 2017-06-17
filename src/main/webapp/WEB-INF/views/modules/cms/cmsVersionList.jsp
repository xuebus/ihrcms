<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<html>
<head>
	<title>版本管理</title>
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
		<li class="active"><a href="${ctx}/cms/cmsVersion/">版本列表</a></li>
		<shiro:hasPermission name="cms:cmsVersion:edit"><li><a href="${ctx}/cms/cmsVersion/form">版本添加</a></li></shiro:hasPermission>
	</ul>
	<%-- <form:form id="searchForm" modelAttribute="cmsVersion" action="${ctx}/cms/cmsVersion/" method="post" class="breadcrumb form-search">
		<input id="pageNo" name="pageNo" type="hidden" value="${page.pageNo}"/>
		<input id="pageSize" name="pageSize" type="hidden" value="${page.pageSize}"/>
		<ul class="ul-form">
			<li><label>版本：</label>
				<form:input path="version" htmlEscape="false" maxlength="255" class="input-medium"/>
			</li>
			<li><label>标题：</label>
				<form:input path="title" htmlEscape="false" maxlength="255" class="input-medium"/>
			</li>
			<li><label>内容：</label>
				<form:input path="content" htmlEscape="false" maxlength="255" class="input-medium"/>
			</li>
			<li><label>Target：</label>
				<form:input path="target" htmlEscape="false" maxlength="255" class="input-medium"/>
			</li>
			<li><label>URL：</label>
				<form:input path="url" htmlEscape="false" maxlength="255" class="input-medium"/>
			</li>
			<li><label>APP：</label>
				<form:input path="app" htmlEscape="false" maxlength="255" class="input-medium"/>
			</li>
			<li><label>时间：</label>
				<input name="time" type="text" readonly="readonly" maxlength="20" class="input-medium Wdate"
					value="<fmt:formatDate value="${cmsVersion.time}" pattern="yyyy-MM-dd HH:mm:ss"/>"
					onclick="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss',isShowClear:false});"/>
			</li>
			<li class="btns"><input id="btnSubmit" class="btn btn-primary" type="submit" value="查询"/></li>
			<li class="clearfix"></li>
		</ul>
	</form:form> --%>
	<sys:message content="${message}"/>
	<table id="contentTable" class="table table-striped table-bordered table-condensed">
		<thead>
			<tr>
				<th>版本</th>
				<th>标题</th>
				<th>内容</th>
				<th>Target</th>
				<th>URL</th>
				<th>APP</th>
				<th>时间</th>
				<shiro:hasPermission name="cms:cmsVersion:edit"><th>操作</th></shiro:hasPermission>
			</tr>
		</thead>
		<tbody>
		<c:forEach items="${page.list}" var="cmsVersion">
			<tr>
				<td><a href="${ctx}/cms/cmsVersion/form?id=${cmsVersion.id}">
					${cmsVersion.version}
				</a></td>
				<td>
					${cmsVersion.title}
				</td>
				<td>
					${cmsVersion.content}
				</td>
				<td>
					${cmsVersion.target}
				</td>
				<td>
					${cmsVersion.url}
				</td>
				<td>
					${cmsVersion.app}
				</td>
				<td>
					<fmt:formatDate value="${cmsVersion.time}" pattern="yyyy-MM-dd HH:mm:ss"/>
				</td>
				<shiro:hasPermission name="cms:cmsVersion:edit"><td>
    				<a href="${ctx}/cms/cmsVersion/form?id=${cmsVersion.id}">修改</a>
					<a href="${ctx}/cms/cmsVersion/delete?id=${cmsVersion.id}" onclick="return confirmx('确认要删除该版本吗？', this.href)">删除</a>
				</td></shiro:hasPermission>
			</tr>
		</c:forEach>
		</tbody>
	</table>
	<div class="pagination">${page}</div>
</body>
</html>