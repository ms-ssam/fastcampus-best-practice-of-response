package com.example.response.controller;

import com.example.response.dto.User;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

// spring에서 응답을 내려주는 방법들   +)가장 좋은 방법
@RestController
@RequestMapping("/api")
public class ApiController {

    // GetMapping으로 넘어온 특정 쿼리 파라미터의 특정한 값을 return하는 응답

    // TEXT
    @GetMapping("/text")
    public String text(@RequestParam String account) {
        return account;  // response의 content type plain text
    }

    // JSON 내려주는 형태
    // request 들어오면 object mapper에 의해 object로 바껴서 메서드로 들어옴
    // 메서드에서 object로 return -> object mapper에 의해 Json으로 바껴서 response
    @PostMapping("/json")
    public User json(@RequestBody User user) {
        return user;  // response의 content type Json (default UTF-8)
    }

    // post는 200 내려주고 put은 200과 201을 사용하는데 201에 대한 응답 처리하는 방법
    // response 내릴 때 http status 정해주기 위해 ResponseEntity 객체 return (generic)
    // 추천 - 응답이 커스터마이징이 필요하다면 ResponseEntity 사용 (값을 명확하게 만들어서 내려줄 수 있음)
    @PutMapping("put")
    public ResponseEntity<User> put(@RequestBody User user) {
        // http status code 지정 + body에 데이터 넣어주기 + object mapper에 의해 Json으로 바껴서 내려감
        return ResponseEntity.status(HttpStatus.CREATED).body(user);
    }
}
