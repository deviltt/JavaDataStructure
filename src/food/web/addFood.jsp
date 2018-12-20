<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<%--<base href="<%=basePath%>">--%>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>添加菜品</title>
<style type="text/css">

</style>
</head>
<body>
	<center>
		<%
			String msg = null, msg1 = null;
			if(request.getAttribute("msg") != null){
			    msg = (String) request.getAttribute("msg");
		%>
				<h3 style="color:red"><%=msg%></h3>
		<%
			}else if(request.getAttribute("msg1") != null){
			    msg1 = (String)request.getAttribute("msg1");
		%>
				<h3 style="color:red"><%=msg1%></h3>
		<%
			}
		%>
		<h1>菜品添加</h1>
		<form action="/food/FoodAddServlet" method="post" enctype="multipart/form-data">
			<table border="1px" width="400px" cellspacing="0px" cellpadding="0px">
				<tr>
					<td>菜品&nbsp;ID</td>
					<td><input type="text" name="foodId"></td>
				</tr>
				<tr>
					<td>菜&nbsp;&nbsp;名</td>
					<td><input type="text" name="foodName"></td>
				</tr>
				<tr>
					<td>口&nbsp;&nbsp;味</td>
					<td>
						<input type="radio" name="taste" value="香辣">香辣
						<input type="radio" name="taste" value="微辣">微辣
						<input type="radio" name="taste" value="麻辣">麻辣
						<input type="radio" name="taste" value="不辣">不辣
					</td>
				</tr>
				<tr>
					<td>菜品图片</td>
					<td><input type="file" name="foodImage"></td>
				</tr>
				<tr>
					<td>价&nbsp;&nbsp;格</td>
					<td><input type="text" name="price"></td>
				</tr>
				<tr>
					<td>菜品描述</td>
					<td>
						<textarea name="desc"></textarea>
					</td>
				</tr>
				<tr   style="text-align:center;width:20px">
					<td colspan="2">
						<input type="submit" value="添加">
						<input type="reset" value="重置">
					</td>
				</tr>
			</table>
		</form>
	</center>
</body>
</html>