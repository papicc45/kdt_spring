package com.example.kdt8.controller;

import com.example.kdt8.dto.UserDTO;
import com.example.kdt8.vo.UserVO;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class MainController {
    //    @GetMapping("/request")
//    public ResponseEntity<String> main() {
//        return ResponseEntity.ok("request");
//    }
    @GetMapping("/request")
    public String main() {
        return "request";
    }
    @GetMapping("/prac")
    public String pracMain() {
        return "prac2";
    }

    @GetMapping("/get/response1")
    public String etResponse1(@RequestParam(value = "name") String name, Model model) {
        model.addAttribute("name", name);
        return "response";
    }

    @GetMapping("/get/response2")
    public String etResponse2(@RequestParam(value = "name", required = false) String name, Model model) {
        model.addAttribute("name", name);
        return "response";
    }

    @GetMapping({"/get/response3/{name}/{age}", "/get/response3/{name}"})
    public String getResponse3(@PathVariable("name") String n,
                               @PathVariable(required = false) String age,
                               Model model) {
        model.addAttribute("name", n);
        model.addAttribute("age", age);
        return "response";
    }

    @PostMapping("/post/response1")
    public String postResponse1(@RequestParam String name, Model model) {
        // RequestBody : 클라이언트가 전달한 json 형태의 내용을 JSON Object로 변환해준다.
        // RequestParam : required가 true일 경우, 빈 값이여도 받아와야 함
        model.addAttribute("name", name);
        return "response";
    }

    @PostMapping("/post/response2")
    public String postResponse2(@RequestParam(required = false) String name, Model model) {
        model.addAttribute("name", name);
        return "response";
    }

    // ResponseBody : template 호출하지 않고 값을 전달
    @PostMapping("/post/response3")
    @ResponseBody
    public String postResponse3(@RequestParam(required = true) String name, Model model) {
        model.addAttribute("name ", name);
        return "response";
    }

    @GetMapping("/dto/response1")
    @ResponseBody
    public String dtoApi1(@ModelAttribute UserDTO userDTO) {
        // @ModelAttribute : html 폼 데이터를 컨트롤러로 전달할 때 사용, 생략가능
        String msg = userDTO.getName() + " " + userDTO.getAge() + "!!!";
        return msg;
    }
    // 일반 폼 GET 방식 - DTO(@ModelAttribute) 전송 가능
    // 일반 폼 GET 방식 - DTO(@RequestBody) 에러

    @PostMapping("/dto/response2")
    @ResponseBody
    public String dtoApi2(UserDTO userDTO) {
        String msg = userDTO.getName() + " " + userDTO.getAge() + "!!!";
        return msg;
    }

    @PostMapping("/dto/response3")
    @ResponseBody
    public String dtoApi3(@RequestBody UserDTO userDTO) {
        // @RequestBody : json/xml 형태일 때만 데이터 받을 수 있음, 일반 폼 전송이 아닌 axios 사용할때 가능
        String msg = userDTO.getName() + " " + userDTO.getAge() + "!!!";
        return msg;
    }

    @GetMapping("/vo/response1")
    public String voApi1(UserVO userVO) {
        // @ModelAttribute 어노테이션은 객체의 setter를 기준으로 동작하기 때문에, setter가 없는 VO는 null이 들어감
        String msg = userVO.getName() + " " + userVO.getAge() + "!!!";
        return msg;
    }
}