package com.board.dao;

import com.board.model.User;
import com.board.utils.DatabaseUtils;

import java.sql.*;

public class UserDao {
    // 通过用户名获取用户信息
    public User getUserByUsername(String username) throws SQLException {
        // 定义SQL查询语句
        String sql = "SELECT * FROM users WHERE username = ?";

        // 通过try-with-resources确保资源的关闭
        try (Connection connection = DatabaseUtils.getConnection();
             PreparedStatement ps = connection.prepareStatement(sql)) {

            // 设置查询参数
            ps.setString(1, username);

            // 执行查询
            try (ResultSet rs = ps.executeQuery()) {
                // 检查查询结果
                if (rs.next()) {
                    String password = rs.getString("password");  // 获取密码
                    // 假设你有个 User 类构造函数接收用户名和密码
                    return new User(username, password);
                }
            }
        }
        return null;  // 如果没有找到用户，返回null
    }
}
