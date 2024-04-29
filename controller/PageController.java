package com.example.response.controller;

import com.example.response.dto.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

// @Controller Annotation
// return type이 String -> 자동으로 resource에 있는 html파일 찾아가게 됨.
// @ResponseBody 붙어있으면 return할 때 리소스 찾거나 하지 않고 response body만들어서 return
// 하지만 page controller로는 html 파일(페이지) 네려주는 용도에만 집중하고
// 페이지 외의 다른 API들에 대해서는 Rest controller로 작성해주는게 best
@Controller
public class PageController {

    // html 파일 내려주기
    @RequestMapping("/main")
    public String main() {
        return "main.html";
    }

    // Json 내려주는 방법 2가지

    // 1) ResponseEntity 객체 return

    // 2번째 방법
    @ResponseBody
    @GetMapping("/user")
    public User user() {
        var user = new User();
        user.setName("steve");
        user.setAddress("패스트캠퍼스");
        return user;
    }
}
