package com.example.spring_mybatis.controller;

import com.example.spring_mybatis.domain.Users;
import com.example.spring_mybatis.dto.UsersDTO;
import com.example.spring_mybatis.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class UsersController {

    @Autowired
    private UsersService usersService;

    @GetMapping("/users")
    public String getUsers(Model model) {
        List<UsersDTO> userList = usersService.getUsersList();
        model.addAttribute("userList", userList);
        return "user";
    }

    @GetMapping("/insert")
    public String getInsertUser(@RequestParam String name, @RequestParam String address, Model model) {
        UsersDTO usersDTO = UsersDTO.builder().name(name).address(address).build();

        usersService.insertUser(usersDTO);

        return "user";
    }
}

/**
 * @Autowired - Spring 컨테이너가 자동으로 해당 타입의 Bean을 필드나 메서드에 주입
 * 1. 필드주입 : Spring이 자동으로 필드에 주입
 * 장점 : 코드가 간결,             단점 : 의존성 변경시키거나 테스트에 어려움
 *
 * 2. 생성자 주입 : Spring이 생성자의 파라미터 타입에 맞는 Bean을 찾아 주입
 * - 불변성을 보장
 *
 */
