<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<%--<base href="<%=basePath%>">--%>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>菜名查询</title>
<style type="text/css">

</style>
</head>
<body>
	<%
		String msg = null;
		String updateName = null;
	%>
	<center>
		<h1>菜名查询</h1>
		<form action="/food/SelectServlet" method="post">
			<input type="hidden" name="type" value="2">
			<table width="400px" border="1px" cellspacing="0px" cellpadding="0px">
				<tr>
					<td>菜名</td>
					<%
						if(request.getAttribute("msg") != null){	//说明没有当前查找菜系
						    msg = (String)request.getAttribute("msg");
					%>
					<td style="color: red"><input type="text" name="foodName"><%=msg%>,请<a href="addFood.jsp" style="color: blue">添加</a></td>
					<%
						}else if(request.getSession().getAttribute("updateName") != null){
						    updateName = (String) request.getSession().getAttribute("updateName");
					%>
							<td><input type="text" name="foodName" value="<%=updateName%>">
					<%
						}else {
					%>
							<td><input type="text" name="foodName">
					<%
						}
					%>
				</tr>
				<tr>
					<td colspan="2" style="text-align:center"><input type="submit" value="查询"></td>
				</tr>
			</table>
		</form>
	</center>
</body>
</html>