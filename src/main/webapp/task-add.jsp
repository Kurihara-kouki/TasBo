<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>タスク登録</title>
</head>
<body>

<form action="task-add-servlet" method="post">

<h3>タスク登録</h3>

<table border="1">

    <tr>
        <th>タスク名</th>
        <td><input type="text" name="taskName" required></td>
    </tr>

    <tr>
        <th>カテゴリ情報</th>
        <td><select name="status">
                <option value="仕様書" selected>仕様書</option>
                <option value="コーディング">コーディング</option>
                <option value="その他">その他</option>
            </select></td>
    </tr>

    <tr>
        <th>期限</th>
        <td><input type="date" name="date"></td>
    </tr>

    <tr>
        <th>担当者</th>
        <td><input type="text" name="userName"></td>
    </tr>

    <tr>
        <th>ステータス情報</th>
        <td><select name="status">
                <option value="未着手" selected>未着手</option>
                <option value="着手中">着手中</option>
                <option value="完了">完了</option>
            </select></td>
    </tr>

    <tr>
        <th>メモ</th>
        <td><input type="text" name="memo"></td>
    </tr>

</table>

<br>

<input type="submit" value="登録">
<input type="reset" value="クリア">

</form>

<br><br>

<form action="menu.jsp" method="get">
    <input type="submit" value="メニュー画面へ">
</form>

</body>
</html>