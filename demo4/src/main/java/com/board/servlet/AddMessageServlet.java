package com.board.servlet;

import com.board.dao.MessageDao;
import com.board.model.Message;
import com.board.model.User;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import java.io.IOException;
import java.util.Date;
@WebServlet("/addMessage")
public class AddMessageServlet extends HttpServlet {

    private MessageDao messageDao = new MessageDao();

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession(false);
        if (session == null || session.getAttribute("user") == null) {
            response.sendRedirect("index.jsp");
            return;
        }

        String title = request.getParameter("title");
        String content = request.getParameter("content");
        User user = (User) session.getAttribute("user");

        // 校验留言的标题和内容是否为空
        if (title != null && !title.isEmpty() && content != null && !content.isEmpty()) {
            // 创建留言对象
            Message message = new Message(0, user.getUsername(), title, content, new Date());

            try {
                // 将留言添加到数据库
                messageDao.addMessage(message);

                // 发布成功后重定向到留言列表页面
                response.sendRedirect("messageList.jsp");
            } catch (Exception e) {
                // 处理错误
                request.setAttribute("errorMessage", "留言发布失败，请稍后再试！");
                request.getRequestDispatcher("addMessage.jsp").forward(request, response);
            }
        } else {
            // 如果标题或内容为空，返回发布留言页面
            request.setAttribute("errorMessage", "标题和内容不能为空！");
            request.getRequestDispatcher("addMessage.jsp").forward(request, response);
        }
    }
}
