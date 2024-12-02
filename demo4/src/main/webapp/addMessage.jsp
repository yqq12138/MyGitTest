<!DOCTYPE html>
<html lang="zh-CN">
<head>
  <%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>发布留言 - 留言板</title>
  <link rel="stylesheet" href="styles.css">
</head>
<body>
<div class="add-message-container">
  <h2>发布留言</h2>

  <form action="addMessage" method="post" class="add-message-form">
    <div class="form-group">
      <label for="title">标题</label>
      <input type="text" id="title" name="title" placeholder="请输入标题" required />
    </div>

    <div class="form-group">
      <label for="content">内容</label>
      <textarea id="content" name="content" placeholder="请输入留言内容" required></textarea>
    </div>

    <div class="form-group">
      <button type="submit" class="submit-btn">发布留言</button>
    </div>
  </form>

  <a href="main.jsp" class="back-btn">返回主界面</a>
</div>
</body>
</html>
