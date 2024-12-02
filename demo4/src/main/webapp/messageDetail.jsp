<!DOCTYPE html>
<html lang="zh-CN">
<head>
    <%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>留言详情 - 留言板</title>
    <link rel="stylesheet" href="styles.css">
</head>
<body>
<div class="message-detail-container">
    <h2>留言详情</h2>

    <!-- 假设你通过某种方式将留言详情传递给 JSP -->
    <div class="message-detail">
        <h3>${message.title}</h3>
        <p><strong>留言人:</strong> ${message.username}</p>
        <p><strong>留言时间:</strong> ${message.timestamp}</p>
        <p><strong>内容:</strong></p>
        <p>${message.content}</p>
    </div>

    <a href="main.jsp" class="back-btn">返回主界面</a>
</div>
</body>
</html>
