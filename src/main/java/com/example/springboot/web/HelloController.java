package com.example.springboot.web;

import com.example.springboot.web.dto.HelloResponseDto;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController//컨트롤러를 json을 반환하는 컨트롤러로 만들어준다
//기존 spring에서 @ResponseBody를 각 메소드마다 선언했던것을 한번에 사용할 수 있게해준다.
public class HelloController {
    @GetMapping("/hello") //http의 get요청을 받을 수 있는 api를 만들어준다.
    public String hello() {
        return "hello";
    }
    @GetMapping("/hello/dto")
    public HelloResponseDto helloDto(@RequestParam("name") String name,
                                     @RequestParam("amount") int amount) {
        //외부에서 api로 넘긴 파라미터를 가져오는 어노테이션
        return new HelloResponseDto(name, amount);
    }
}
