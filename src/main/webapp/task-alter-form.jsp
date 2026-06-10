<%@page import="model.entity.UserBean"%>
<%@page import="model.entity.StatusBean"%>
<%@page import="model.entity.CategoryBean"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>タスク編集画面</title>
</head>
<body>
	<%
		List<CategoryBean> categoryList = (List<CategoryBean>)session.getAttribute("categoryList");
		List<StatusBean> statusList = (List<StatusBean>)session.getAttribute("statusList");
		List<UserBean> userList = (List<UserBean>)session.getAttribute("userList");
	%>
	
	<h1>タスク編集フォーム</h1>
	
	
</body>
</html>