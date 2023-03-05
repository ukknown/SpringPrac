package com.practice.spring.controller;

import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api")
public class Controller {
    //매개변수가 없는 GET 메서드 구현
//    @GetMapping(value = "/name")
//    public String getName(){
//        return "jonguk";
//    }

    //URL에 값을 담아 GET요청 처리방법 1
    @GetMapping(value = "/variable1/{variable}")
    public String getVariable1(@PathVariable String variable){
        return variable;
    }
    //URL에 값을 담아 GET요청 처리방법 2
    @GetMapping(value = "/variable2/{variable}")
    public String getVariable2(@PathVariable("variable") String var){
        return var;
    }

    //쿼리형식으로 값을 전달방법 1
    @GetMapping(value = "/request1")
    public String getRequestParam1(@RequestParam String name, @RequestParam String email, @RequestParam String organ){
        return name + " " + email + " " + organ;
    }

    //쿼리형식으로 값을 전달방법 2
    @GetMapping(value = "/request2")
    public String getRequestParam2(@RequestParam Map<String, String> param){
        StringBuilder sb =new StringBuilder();

        param.entrySet().forEach(map -> {
            sb.append(map.getKey() + " : " + map.getValue() + "\n");
        });

        return sb.toString();

    }






}
