<%@page import="java.util.ArrayList"%>
<%@page import="model.entity.TaskBean"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ログイン画面</title>
</head>
<body>
<%
	List<TaskBean> taskList = (ArrayList<TaskBean>)session.getAttribute("taskList");
%>
<h1>商品一覧画面</h1>
<hr>
<table border = 1>
	<tr>
		<th>タスク名</th>
		<th>カテゴリ</th>
		<th>期限</th>
		<th>担当者</th>
		<th>ステータス</th>
		<th>メモ</th>	
	<tr>
	</table>
	<br>
	<form action="menu.jsp" method="POST">
		<input type = "submit" value="メニュー画面へ">
	</form>
</body>
</html>