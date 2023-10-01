package org.example.service;

import org.example.domain.Book;
import org.springframework.jdbc.core.RowMapper;

import javax.swing.tree.TreePath;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.UUID;

public class BookRowMapper implements RowMapper {
    @Override
    public Book mapRow(ResultSet rs, int rowNum) throws SQLException {
        UUID id = UUID.fromString(rs.getString("id"));
        String title = rs.getString("title");
        String author = rs.getString("author");
        int pages = rs.getInt("pages");
        return new Book(id, title, author, pages);
    }
}
