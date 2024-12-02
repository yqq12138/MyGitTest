<!DOCTYPE html>
<html lang="zh-CN">
<head>
    <%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>留言列表 - 留言板</title>
    <link rel="stylesheet" href="styles.css">
</head>
<body>
<div class="message-list-container">
    <h2>留言列表</h2>

    <!-- 假设你通过某种方式将留言列表传递给 JSP -->
    <ul class="message-list">
        <c:forEach var="message" items="${messages}">
            <li>
                <a href="messageDetail.jsp?id=${message.id}">${message.title}</a>
                <span>${message.timestamp}</span>
            </li>
        </c:forEach>
    </ul>

    <a href="main.jsp" class="back-btn">返回主界面</a>
</div>
</body>
</html>
