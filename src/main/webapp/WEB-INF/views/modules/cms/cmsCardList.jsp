<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<html>
<head>
	<title>名片管理</title>
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
		<li class="active"><a href="${ctx}/cms/cmsCard/">名片列表</a></li>
		<shiro:hasPermission name="cms:cmsCard:edit"><li><a href="${ctx}/cms/cmsCard/form">名片添加</a></li></shiro:hasPermission>
	</ul>
	<%-- <form:form id="searchForm" modelAttribute="cmsCard" action="${ctx}/cms/cmsCard/" method="post" class="breadcrumb form-search">
		<input id="pageNo" name="pageNo" type="hidden" value="${page.pageNo}"/>
		<input id="pageSize" name="pageSize" type="hidden" value="${page.pageSize}"/>
		<ul class="ul-form">
			<li><label>名片编号：</label>
				<form:input path="cardnum" htmlEscape="false" maxlength="20" class="input-medium"/>
			</li>
			<li><label>简历编号：</label>
				<form:input path="resumenum" htmlEscape="false" maxlength="255" class="input-medium"/>
			</li>
			<li><label>名片URL：</label>
				<form:input path="cardurl" htmlEscape="false" maxlength="255" class="input-medium"/>
			</li>
			<li><label>创建时间：</label>
				<input name="createtime" type="text" readonly="readonly" maxlength="20" class="input-medium Wdate"
					value="<fmt:formatDate value="${cmsCard.createtime}" pattern="yyyy-MM-dd HH:mm:ss"/>"
					onclick="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss',isShowClear:false});"/>
			</li>
			<li><label>审核时间：</label>
				<input name="verifytime" type="text" readonly="readonly" maxlength="20" class="input-medium Wdate"
					value="<fmt:formatDate value="${cmsCard.verifytime}" pattern="yyyy-MM-dd HH:mm:ss"/>"
					onclick="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss',isShowClear:false});"/>
			</li>
			<li><label>状态：</label>
				<form:radiobuttons path="status" items="${fns:getDictList('verify')}" itemLabel="label" itemValue="value" htmlEscape="false"/>
			</li>
			<li class="btns"><input id="btnSubmit" class="btn btn-primary" type="submit" value="查询"/></li>
			<li class="clearfix"></li>
		</ul>
	</form:form> --%>
	<sys:message content="${message}"/>
	<table id="contentTable" class="table table-striped table-bordered table-condensed">
		<thead>
			<tr>
				<th>名片编号</th>
				<th>简历编号</th>
				<th>名片URL</th>
				<th>创建时间</th>
				<th>审核时间</th>
				<th>状态</th>
				<shiro:hasPermission name="cms:cmsCard:edit"><th>操作</th></shiro:hasPermission>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${page.list}" var="cmsCard">
				<tr>
					<td><a href="${ctx}/cms/cmsCard/form?id=${cmsCard.id}">
						${cmsCard.cardnum}
					</a></td>
					<td>
						${cmsCard.resumenum}
					</td>
					<td>
						${cmsCard.cardurl}
					</td>
					<td>
						<fmt:formatDate value="${cmsCard.createtime}" pattern="yyyy-MM-dd HH:mm:ss"/>
					</td>
					<td>
						<fmt:formatDate value="${cmsCard.verifytime}" pattern="yyyy-MM-dd HH:mm:ss"/>
					</td>
					<td>
						${fns:getDictLabel(cmsCard.status, 'verify', '')}
					</td>
					<shiro:hasPermission name="cms:cmsCard:edit"><td>
	    				<a href="${ctx}/cms/cmsCard/form?id=${cmsCard.id}">修改</a>
						<a href="${ctx}/cms/cmsCard/delete?id=${cmsCard.id}" onclick="return confirmx('确认要删除该名片吗？', this.href)">删除</a>
					</td></shiro:hasPermission>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	<div class="pagination">${page}</div>
</body>
</html>