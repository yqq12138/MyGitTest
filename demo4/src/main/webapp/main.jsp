<!DOCTYPE html>
<html lang="zh-CN">
<head>
    <%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>留言板 - 主界面</title>
    <link rel="stylesheet" href="styles.css">
</head>
<body>
<div class="main-container">
    <h2>欢迎来到留言板</h2>

    <div class="button-group">
        <a href="addMessage.jsp" class="button">发布留言</a>
        <a href="messageList.jsp" class="button">留言列表</a>
        <a href="messageDetail.jsp" class="button">留言详情</a>
    </div>

    <!-- 登出按钮 -->
    <form action="logout" method="post">
        <button type="submit" class="logout-btn">登出</button>
    </form>
</div>
</body>
</html>
