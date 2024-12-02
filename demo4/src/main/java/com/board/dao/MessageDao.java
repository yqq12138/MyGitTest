package com.board.dao;

import com.board.model.Message;
import com.board.utils.DatabaseUtils;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MessageDao {

    // 获取所有留言
    public List<Message> getAllMessages() throws SQLException {
        List<Message> messages = new ArrayList<>();
        String sql = "SELECT * FROM messages ORDER BY timestamp DESC";
        try (Connection connection = DatabaseUtils.getConnection();
             Statement stmt = connection.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                messages.add(new Message(
                        rs.getInt("id"),
                        rs.getString("username"),
                        rs.getString("title"),
                        rs.getString("content"),
                        rs.getTimestamp("timestamp")
                ));
            }
        }
        return messages;
    }

    // 获取单条留言
    public Message getMessageById(int messageId) throws SQLException {
        String sql = "SELECT * FROM messages WHERE id = ?";
        try (Connection connection = DatabaseUtils.getConnection();
             PreparedStatement ps = connection.prepareStatement(sql)) {

            ps.setInt(1, messageId);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                return new Message(
                        rs.getInt("id"),
                        rs.getString("username"),
                        rs.getString("title"),
                        rs.getString("content"),
                        rs.getTimestamp("timestamp")
                );
            }
        }
        return null;
    }

    // 添加留言
    public void addMessage(Message message) throws SQLException {
        String sql = "INSERT INTO messages (username, title, content, timestamp) VALUES (?, ?, ?, ?)";
        try (Connection connection = DatabaseUtils.getConnection();
             PreparedStatement ps = connection.prepareStatement(sql)) {

            ps.setString(1, message.getUsername());
            ps.setString(2, message.getTitle());
            ps.setString(3, message.getContent());
            ps.setTimestamp(4, new Timestamp(message.getTimestamp().getTime()));
            ps.executeUpdate();//这是第一次
        }
    }
}
