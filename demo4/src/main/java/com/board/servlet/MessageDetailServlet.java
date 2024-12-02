package com.board.servlet;

import com.board.dao.MessageDao;
import com.board.model.Message;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import java.io.IOException;

public class MessageDetailServlet extends HttpServlet {

    private MessageDao messageDao = new MessageDao();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            int messageId = Integer.parseInt(request.getParameter("id"));
            Message message = messageDao.getMessageById(messageId);

            if (message != null) {
                request.setAttribute("message", message);
                request.getRequestDispatcher("messageDetail.jsp").forward(request, response);
            } else {
                response.sendError(HttpServletResponse.SC_NOT_FOUND, "留言未找到");
            }
        } catch (Exception e) {
            e.printStackTrace();
            response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "服务器内部错误");
        }
    }
}
