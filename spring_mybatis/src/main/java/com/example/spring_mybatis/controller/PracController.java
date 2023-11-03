package com.example.spring_mybatis.controller;

import com.example.spring_mybatis.domain.PracUser;
import com.example.spring_mybatis.dto.PracUserDTO;
import com.example.spring_mybatis.service.PracService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class PracController {

    @Autowired
    private PracService pracService;

    @GetMapping("/prac")
    public String gotoPrac() {
        return "register";
    }
    @GetMapping("/login")
    public String gotoLogin() {
        return "login";
    }
    @GetMapping("/userInfo")
    public String gotoUserInfo() {
        return "userInfo";
    }
    @PostMapping("/register")
    @ResponseBody
    public boolean register(@RequestBody PracUserDTO pracUserDTO) {
        boolean register = pracService.register(pracUserDTO);

        return register;
    }

    @PostMapping("/login")
    @ResponseBody
    public PracUserDTO login(@RequestBody PracUserDTO pracUserDTO) {
        PracUserDTO user = pracService.login(pracUserDTO);

        return user;
    }

    @PatchMapping("/update")
    @ResponseBody
    public boolean updateInfo(@RequestBody PracUserDTO pracUserDTO) {
        System.out.println(pracUserDTO.toString());
        boolean update = pracService.updateInfo(pracUserDTO);

        return update;
    }

    @DeleteMapping("/delete")
    @ResponseBody
    public boolean deleteInfo( Long id) {
        System.out.println("id : " + id);
        boolean delete = pracService.deleteInfo(id);

        return delete;
    }
}
