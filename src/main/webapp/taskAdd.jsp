<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<form action="item-add-servlet" method="POST">

    <table border="1">

        <tr>
            <th>タスク名</th>
            <td>
             <input type="text"name="taskName">
            </td>
        </tr>

        <tr>
            <th>カテゴリ情報</th>
            <td>
                <input type="text"name="categoryName">
            </td>
        </tr>

        <tr>
            <th>期限</th>
            <td>
                <input type="text" name="date" >
            </td>
        </tr>
        <tr>
            <th>担当者</th>
            <td>
                <input type="text" name="userName" >
            </td>
        </tr>
        
        <tr>
            <th>ステータス情報</th>
            <td>
                <input type="text" name="userName" >
            </td>
        </tr>
        
        <tr>
            <th>メモ</th>
            <td>
                <input type="text" name="memo" >
            </td>
        </tr>

    </table>

    <br>

    <input type="submit" value="登録実行">
    <input type="reset" value="クリア">

</form>

<br><br>

<form action="menu.jsp" method="POST">
    <input type="submit" value="メニュー画面へ">
</form>

</body>
</html>