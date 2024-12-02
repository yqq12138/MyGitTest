package com.board.servlet;

import com.board.dao.MessageDao;
import com.board.model.Message;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import java.io.IOException;
import java.util.List;

public class MessageListServlet extends HttpServlet {

    private MessageDao messageDao = new MessageDao();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            List<Message> messages = messageDao.getAllMessages();
            request.setAttribute("messages", messages);
            request.getRequestDispatcher("messageList.jsp").forward(request, response);
        } catch (Exception e) {
            e.printStackTrace();
            response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "服务器内部错误");
        }
    }
}
