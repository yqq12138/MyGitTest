package com.board.servlet;

import com.board.dao.UserDao;
import com.board.model.User;
import com.board.utils.PasswordUtils;  // 假设有一个工具类用来处理密码加密

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import java.io.IOException;
import java.security.NoSuchAlgorithmException;
@WebServlet("/login")
public class LoginServlet extends HttpServlet {

    private UserDao userDao = new UserDao();

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String rememberMe = request.getParameter("rememberMe");

        try {
            // 从数据库获取用户信息
            User user = userDao.getUserByUsername(username);

            // 如果用户存在，且密码匹配
            if (user != null && PasswordUtils.verifyPassword(password, user.getPassword())) {
                HttpSession session = request.getSession();
                session.setAttribute("user", user);

                // 记住我功能，存储用户名的 Cookie
                if ("on".equals(rememberMe)) {
                    Cookie usernameCookie = new Cookie("username", username);
                    usernameCookie.setMaxAge(60 * 60 * 24 * 7); // 7天有效期
                    usernameCookie.setHttpOnly(true);  // 安全性更高
                    usernameCookie.setSecure(true);    // 在 HTTPS 下传输

                    response.addCookie(usernameCookie);
                }

                // 登录成功，重定向到主页面
                response.sendRedirect("main.jsp");
            } else {
                // 登录失败，提示错误信息
                request.setAttribute("errorMessage", "用户名或密码错误！");
                request.getRequestDispatcher("index.jsp").forward(request, response);
            }
        } catch (Exception e) {
            // 异常处理：记录日志并返回错误信息
            e.printStackTrace();
            request.setAttribute("errorMessage", "服务器发生错误，请稍后再试！");
            request.getRequestDispatcher("index.jsp").forward(request, response);
        }
    }
}
