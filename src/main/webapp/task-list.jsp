<%@page import="java.util.ArrayList"%>
<%@page import="model.entity.TaskBean"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>タスク一覧</title>
</head>
<body>
<%
	List<TaskBean> taskList = (List<TaskBean>)session.getAttribute("taskList");
%>
<h1>商品一覧画面</h1>
<hr>
<form  method="POST">
	<table border = 1>
		<tr>
			<th>選択</th>
			<th>タスク名</th>
			<th>カテゴリ</th>
			<th>期限</th>
			<th>担当者</th>
			<th>ステータス</th>
			<th>メモ</th>	
		<tr>
	<%
		for(TaskBean bean : taskList){
	%>	
			<tr>
				<td><input type="radio" name="taskId" value="<%=bean.getTaskId()%>"></td>
				<td><%=bean.getTaskName()%></td>
				<td><%=bean.getCategoryName()%></td>
				<td><%=bean.getLimitDate()%></td>
				<td><%=bean.getUserName()%></td>
				<td><%=bean.getStatusName()%></td>
				<td><%=bean.getMemo()%></td>
			</tr>
	<%
		}
	%>
	</table>
	<br>
		<input type = "submit" value="タスク編集" formaction="task-edit-servlet">
		<input type = "submit" value="タスク削除" formaction="task-delete-servlet">
</form>
</body>
</html>