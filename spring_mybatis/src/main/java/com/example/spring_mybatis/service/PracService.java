package com.example.spring_mybatis.service;

import com.example.spring_mybatis.domain.PracUser;
import com.example.spring_mybatis.dto.PracUserDTO;
import com.example.spring_mybatis.mapper.PracUserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PracService {

    @Autowired
    private PracUserMapper pracUserMapper;

    public boolean register(PracUserDTO pracUserDTO) {
        PracUser pracUser = PracUser.builder()
                .userId(pracUserDTO.getUserId())
                .password(pracUserDTO.getPassword())
                .name(pracUserDTO.getName())
                .build();

        boolean check = pracUserMapper.register(pracUser);

        return check;
    }

    public PracUserDTO login(PracUserDTO pracUserDTO) {
        PracUser user = pracUserMapper.login(pracUserDTO.getUserId(), pracUserDTO.getPassword());

        PracUserDTO pracUserDTO1 = PracUserDTO.builder()
                .id(user.getId())
                .userId(user.getUserId())
                .password(user.getPassword())
                .name(user.getName())
                .build();
        return pracUserDTO1;
    }

    public boolean updateInfo(PracUserDTO pracUserDTO) {
        PracUser pracUser = PracUser.builder()
                .id(pracUserDTO.getId())
                .userId(pracUserDTO.getUserId())
                .password(pracUserDTO.getPassword())
                .name(pracUserDTO.getName())
                .build();

        boolean check = pracUserMapper.updateInfo(pracUser);

        return check;
    }

    public boolean deleteInfo(Long id) {

        boolean check = pracUserMapper.deleteUser(id);

        return check;
    }
}
