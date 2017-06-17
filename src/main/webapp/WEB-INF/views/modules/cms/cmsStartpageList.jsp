<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<html>
<head>
	<title>启动页管理</title>
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
		<li class="active"><a href="${ctx}/cms/cmsStartpage/">启动页列表</a></li>
		<shiro:hasPermission name="cms:cmsStartpage:edit"><li><a href="${ctx}/cms/cmsStartpage/form">启动页添加</a></li></shiro:hasPermission>
	</ul>
	<%-- <form:form id="searchForm" modelAttribute="cmsStartpage" action="${ctx}/cms/cmsStartpage/" method="post" class="breadcrumb form-search">
		<input id="pageNo" name="pageNo" type="hidden" value="${page.pageNo}"/>
		<input id="pageSize" name="pageSize" type="hidden" value="${page.pageSize}"/>
		<ul class="ul-form">
			<li><label>图片ID：</label>
				<form:input path="imgid" htmlEscape="false" maxlength="255" class="input-medium"/>
			</li>
			<li><label>图片URL：</label>
				<form:input path="url" htmlEscape="false" maxlength="255" class="input-medium"/>
			</li>
			<li><label>图片宽度：</label>
				<form:input path="width" htmlEscape="false" maxlength="20" class="input-medium"/>
			</li>
			<li><label>图片高度：</label>
				<form:input path="height" htmlEscape="false" maxlength="20" class="input-medium"/>
			</li>
			<li><label>显示比率：</label>
				<form:input path="rate" htmlEscape="false" maxlength="20" class="input-medium"/>
			</li>
			<li><label>状态：</label>
				<form:radiobuttons path="status" items="${fns:getDictList('cms_startpage_status')}" itemLabel="label" itemValue="value" htmlEscape="false"/>
			</li>
			<li><label>上线时间：</label>
				<input name="onlinestarttime" type="text" readonly="readonly" maxlength="20" class="input-medium Wdate"
					value="<fmt:formatDate value="${cmsStartpage.onlinestarttime}" pattern="yyyy-MM-dd HH:mm:ss"/>"
					onclick="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss',isShowClear:false});"/>
			</li>
			<li><label>下线时间：</label>
				<input name="onlineendtime" type="text" readonly="readonly" maxlength="20" class="input-medium Wdate"
					value="<fmt:formatDate value="${cmsStartpage.onlineendtime}" pattern="yyyy-MM-dd HH:mm:ss"/>"
					onclick="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss',isShowClear:false});"/>
			</li>
			<li><label>发布时间：</label>
				<input name="publishtime" type="text" readonly="readonly" maxlength="20" class="input-medium Wdate"
					value="<fmt:formatDate value="${cmsStartpage.publishtime}" pattern="yyyy-MM-dd HH:mm:ss"/>"
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
				<th>图片ID</th>
				<th>图片URL</th>
				<th>图片宽度</th>
				<th>图片高度</th>
				<th>显示比率</th>
				<th>状态</th>
				<th>上线时间</th>
				<th>下线时间</th>
				<th>发布时间</th>
				<shiro:hasPermission name="cms:cmsStartpage:edit"><th>操作</th></shiro:hasPermission>
			</tr>
		</thead>
		<tbody>
		<c:forEach items="${page.list}" var="cmsStartpage">
			<tr>
				<td><a href="${ctx}/cms/cmsStartpage/form?id=${cmsStartpage.id}">
					${cmsStartpage.imgid}
				</a></td>
				<td>
					${cmsStartpage.url}
				</td>
				<td>
					${cmsStartpage.width}
				</td>
				<td>
					${cmsStartpage.height}
				</td>
				<td>
					${cmsStartpage.rate}
				</td>
				<td>
					${fns:getDictLabel(cmsStartpage.status, 'cms_startpage_status', '')}
				</td>
				<td>
					<fmt:formatDate value="${cmsStartpage.onlinestarttime}" pattern="yyyy-MM-dd HH:mm:ss"/>
				</td>
				<td>
					<fmt:formatDate value="${cmsStartpage.onlineendtime}" pattern="yyyy-MM-dd HH:mm:ss"/>
				</td>
				<td>
					<fmt:formatDate value="${cmsStartpage.publishtime}" pattern="yyyy-MM-dd HH:mm:ss"/>
				</td>
				<shiro:hasPermission name="cms:cmsStartpage:edit"><td>
    				<a href="${ctx}/cms/cmsStartpage/form?id=${cmsStartpage.id}">修改</a>
					<a href="${ctx}/cms/cmsStartpage/delete?id=${cmsStartpage.id}" onclick="return confirmx('确认要删除该启动页吗？', this.href)">删除</a>
				</td></shiro:hasPermission>
			</tr>
		</c:forEach>
		</tbody>
	</table>
	<div class="pagination">${page}</div>
</body>
</html>