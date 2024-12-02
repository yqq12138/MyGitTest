<!DOCTYPE html>
<html lang="zh-CN">
<head>
    <%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>登录 - 留言板</title>
    <link rel="stylesheet" href="styles.css">
</head>
<body>
<div class="login-container">
    <h2>欢迎登录</h2>
    <form action="login" method="post" class="login-form">
        <div class="form-group">
            <label for="username">用户名</label>
            <input type="text" id="username" name="username" placeholder="请输入用户名" required autofocus autocomplete="username" />
        </div>

        <div class="form-group">
            <label for="password">密码</label>
            <input type="password" id="password" name="password" placeholder="请输入密码" required autocomplete="current-password" />
        </div>

        <div class="form-group remember-me">
            <label>
                <input type="checkbox" name="rememberMe" /> 记住我
            </label>
        </div>

        <div class="form-group">
            <button type="submit" class="login-btn">登录</button>
        </div>

        <!-- 错误消息 -->
        <c:if test="${not empty errorMessage}">
            <div class="error-message">${errorMessage}</div>
        </c:if>
    </form>
</div>
</body>
</html>
