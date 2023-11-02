package com.example.spring_mybatis.mapper;

import com.example.spring_mybatis.domain.Users;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface UsersMapper {
    // xml 참고하기
    List<Users> findAll();

    // 어노테이션 이용
    @Insert("INSERT INTO users (name, address) values (#{name}, #{address})")
    void insertUser(Users user);
}
