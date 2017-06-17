<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<html>
<head>
	<title>Banner管理</title>
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
		<li class="active"><a href="${ctx}/cms/cmsBanner/">Banner列表</a></li>
		<shiro:hasPermission name="cms:cmsBanner:edit"><li><a href="${ctx}/cms/cmsBanner/form">Banner添加</a></li></shiro:hasPermission>
	</ul>
	<%-- <form:form id="searchForm" modelAttribute="cmsBanner" action="${ctx}/cms/cmsBanner/" method="post" class="breadcrumb form-search">
		<input id="pageNo" name="pageNo" type="hidden" value="${page.pageNo}"/>
		<input id="pageSize" name="pageSize" type="hidden" value="${page.pageSize}"/>
		<ul class="ul-form">
			<li><label>Banner名称：</label>
				<form:input path="bname" htmlEscape="false" maxlength="255" class="input-medium"/>
			</li>
			<li><label>跳转URL：</label>
				<form:input path="jumpurl" htmlEscape="false" maxlength="255" class="input-medium"/>
			</li>
			<li><label>上线时间：</label>
				<input name="starttime" type="text" readonly="readonly" maxlength="20" class="input-medium Wdate"
					value="<fmt:formatDate value="${cmsBanner.starttime}" pattern="yyyy-MM-dd HH:mm:ss"/>"
					onclick="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss',isShowClear:false});"/>
			</li>
			<li><label>下线时间：</label>
				<input name="endtime" type="text" readonly="readonly" maxlength="20" class="input-medium Wdate"
					value="<fmt:formatDate value="${cmsBanner.endtime}" pattern="yyyy-MM-dd HH:mm:ss"/>"
					onclick="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss',isShowClear:false});"/>
			</li>
			<li><label>状态：</label>
				<form:radiobuttons path="status" items="${fns:getDictList('bannerstatus')}" itemLabel="label" itemValue="value" htmlEscape="false"/>
			</li>
			<li><label>图片URL：</label>
				<form:input path="imgurl" htmlEscape="false" maxlength="255" class="input-medium"/>
			</li>
			<li><label>创建时间：</label>
				<input name="createtime" type="text" readonly="readonly" maxlength="20" class="input-medium Wdate"
					value="<fmt:formatDate value="${cmsBanner.createtime}" pattern="yyyy-MM-dd HH:mm:ss"/>"
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
				<th>Banner名称</th>
				<th>跳转URL</th>
				<th>上线时间</th>
				<th>下线时间</th>
				<th>状态</th>
				<th>图片URL</th>
				<th>创建时间</th>
				<shiro:hasPermission name="cms:cmsBanner:edit"><th>操作</th></shiro:hasPermission>
			</tr>
		</thead>
		<tbody>
		<c:forEach items="${page.list}" var="cmsBanner">
			<tr>
				<td><a href="${ctx}/cms/cmsBanner/form?id=${cmsBanner.id}">
					${cmsBanner.bname}
				</a></td>
				<td>
					${cmsBanner.jumpurl}
				</td>
				<td>
					<fmt:formatDate value="${cmsBanner.starttime}" pattern="yyyy-MM-dd HH:mm:ss"/>
				</td>
				<td>
					<fmt:formatDate value="${cmsBanner.endtime}" pattern="yyyy-MM-dd HH:mm:ss"/>
				</td>
				<td>
					${fns:getDictLabel(cmsBanner.status, 'bannerstatus', '')}
				</td>
				<td>
					${cmsBanner.imgurl}
				</td>
				<td>
					<fmt:formatDate value="${cmsBanner.createtime}" pattern="yyyy-MM-dd HH:mm:ss"/>
				</td>
				<shiro:hasPermission name="cms:cmsBanner:edit"><td>
    				<a href="${ctx}/cms/cmsBanner/form?id=${cmsBanner.id}">修改</a>
					<a href="${ctx}/cms/cmsBanner/delete?id=${cmsBanner.id}" onclick="return confirmx('确认要删除该Banner吗？', this.href)">删除</a>
				</td></shiro:hasPermission>
			</tr>
		</c:forEach>
		</tbody>
	</table>
	<div class="pagination">${page}</div>
</body>
</html>