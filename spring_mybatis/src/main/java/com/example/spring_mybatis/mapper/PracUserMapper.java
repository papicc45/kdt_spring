package com.example.spring_mybatis.mapper;

import com.example.spring_mybatis.domain.PracUser;
import org.apache.ibatis.annotations.*;

@Mapper
public interface PracUserMapper {

    @Delete("DELETE FROM pracuser WHERE id = #{id}")
    boolean deleteUser(Long id);
    @Update("UPDATE pracuser SET userId = #{userId}, password = #{password}, name = #{name} where id = #{id}")
    boolean updateInfo(PracUser pracUser);
    @Select("SELECT * FROM pracuser WHERE userId = #{userId} AND password = #{password}")
    PracUser login(String userId, String password);
    @Insert("INSERT INTO pracuser (userId, password, name) values (#{userId}, #{password}, #{name})")
    boolean register(PracUser pracUser);
}
