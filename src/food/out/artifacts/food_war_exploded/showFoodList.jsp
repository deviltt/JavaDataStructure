<%@ page import="com.imooc.entity.Food" %>
<%@ page import="java.util.List" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<%--<base href="<%=basePath%>">--%>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>菜品信息展示</title>
<style type="text/css">

</style>
</head>
	<body>
		<%
			//将所有已添加的菜品信息都显示在表格中
			List<Food> list = (List<Food>) request.getServletContext().getAttribute("list");
		%>
		<center>
			<h1>菜品查询</h1>
			<table border="1px" cellspacing="0px" cellpadding="0px" width="800px">
				<thead>
					<tr>
						<th>菜品ID</th>
						<th>菜名</th>
						<th>口味</th>
						<th>菜品图片</th>
						<th>价格</th>
						<th>菜品描述</th>
					</tr>
				</thead>
				<%
					for(Food food : list){
						int index = food.getPath().lastIndexOf("\\");
						String fileName = food.getPath().substring(index + 1);
//						System.out.println(fileName);
				%>
				<tbody>
					<tr>
						<td><%=food.getFoodId()%></td>
						<td><%=food.getFoodName()%></td>
						<td><%=food.getTaste()%></td>
						<td><img src="./img/<%=fileName%>"></td>	<!--<img src="<%=food.getPath()%>" width="200" height="200">-->
						<td><%=food.getPrive()%></td>
						<td><%=food.getDesc()%></td>
					</tr>
				</tbody>
				<%
					}
				%>
			</table>
		</center>
	</body>
</html>