<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<%--<base href="<%=basePath%>">--%>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>菜品删除(根据ID删)</title>
<style type="text/css">

</style>
</head>
<body>
	<%
		String msg = null;
	%>
	<center>
		<h1>菜品删除(根据ID删除)</h1>
		<form action="/food/FoodDeleteServlet" method="post">
			<table width="400px" border="1px" cellspacing="0px" cellpadding="0px">
				<tr>
					<td>菜品ID</td>
					<%
						if(request.getAttribute("msg") != null && request.getAttribute("msg").equals("菜品不存在，不需要删除")){
						    msg = (String)request.getAttribute("msg");
					%>
							<td style="color: green"><input type="text" name="foodId"><%=msg%></td>
					<%
						}else if(request.getAttribute("msg") != null && request.getAttribute("msg").equals("成功删除！")){
							msg = (String)request.getAttribute("msg");
					%>
							<td style="color: green"><input type="text" name="foodId"><%=msg%>是否需要<a href="addFood.jsp">添加</a></td>
					<%
						}else if(request.getAttribute("msg") != null && request.getAttribute("msg").equals("菜品列表为空")){
							msg = (String)request.getAttribute("msg");
					%>
							<td style="color: green"><input type="text" name="foodId"><%=msg%>请添加<a href="addFood.jsp" style="color: blue">添加</a> </td>
					<%
						}else {
					%>
							<td><input type="text" name="foodId"></td>
					<%
						}
					%>
				</tr>
				<tr>
					<td colspan="2" style="text-align:center"><input type="submit" value="删除"></td>
				</tr>
			</table>
		</form>
	</center>
</body>
</html>