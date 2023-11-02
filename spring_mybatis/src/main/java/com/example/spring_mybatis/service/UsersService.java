package com.example.spring_mybatis.service;

import com.example.spring_mybatis.domain.Users;
import com.example.spring_mybatis.dto.UsersDTO;
import com.example.spring_mybatis.mapper.UsersMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UsersService {

    @Autowired
    private UsersMapper usersMapper;

    public List<UsersDTO> getUsersList() {
        List<Users> result = usersMapper.findAll();
        List<UsersDTO> users = new ArrayList<>();
        for(Users user : result) {
            users.add(UsersDTO.builder()
                    .id(user.getId())
                    .name(user.getName())
                    .address(user.getAddress())
                    .build());
        }
        return users;
    }

    public void insertUser(UsersDTO usersDTO) {
        Users user = Users.builder().name(usersDTO.getName()).address(usersDTO.getAddress()).build();
        usersMapper.insertUser(user);
    }
}
