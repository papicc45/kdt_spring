package com.example.spring_jdbc.repository;

import com.example.spring_jdbc.dto.UserDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class UserRepository {
    @Autowired
    private JdbcTemplate jdbc;

    private static String INSERT_USER =
            """ 
            insert into users(id, name, address) values (?, ?, ?);
            """;
    private static String DELETE_USER =
            """
            delete from users where id = ?;
            """;
    public void  insert(UserDTO userDTO) {
        jdbc.update(INSERT_USER, userDTO.getId(), userDTO.getName(), userDTO.getAddress());
    }

    public void deleteById(Long id) {
        jdbc.update(DELETE_USER, id);
    }
}
