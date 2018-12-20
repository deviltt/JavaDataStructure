<%@ page import="com.imooc.entity.Food" %><%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/12/20 0020
  Time: 下午 5:01
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>菜品查询结果</title>
</head>
<%
    Food food = (Food) request.getAttribute("food");
    int index = food.getPath().lastIndexOf("\\");
    String fileName = food.getPath().substring(index + 1);
//    System.out.println(fileName);
%>

<body>
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
        </table>
    </center>
</body>
</html>
