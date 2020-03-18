package com.example.springboot.web;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@RunWith(SpringRunner.class) //테스트를 진행할 때 jUnit에 내장된 실행자 외에 다른 실행자를 실행시킵니다.
//스프링 부트 테스트와 jUnit 사이에 연결자 역할을 한다.
@WebMvcTest(controllers = HelloController.class)//여러 스프링 테스트 어노테이션 중 web에 집중할 수 있는 어노테이션
//@Controller나 @ControllerAdvice등을 사용할 수 있다.
//단 @Service, @Component, @Repository등은 사용할 수 없다.
public class HelloControllerTest {
    @Autowired //spring이 관리하는 bean주입
    private MockMvc mvc; //웹 api를 테스트할때 사용한다.
    // 스프링 mvc 테스트의 시작점. 이 클래스를 통해 http, get, post에 대한 api 테스트

    @Test
    public void hello가_리턴된다() throws Exception {
        String hello = "hello";

        mvc.perform(get("/hello")) //체이닝이 지원되어 아래와 같이 여러 선언이 가능하다.
                .andExpect(status().isOk())//mvc.perform의 결과를 검증 http Header의 Status를 검증
                .andExpect(content().string(hello));//mvc.perform의 결과를 검증, 응답 본문의 내용을 검증
        //Controller에서 "hello"를 리턴하기 때문에 이 값이 맞는지 검증한다.
    }

    @Test
    public void helloDto가_리턴된다() throws Exception {
        String name = "hello";
        int amount = 1000;

        mvc.perform(
                get("/hello/dto")
                .param("name", name)
                .param("amount", String.valueOf(amount))
        ).andExpect(status().isOk())
                .andExpect(jsonPath("$.name", is(name)))
                .andExpect(jsonPath("$.amount", is(amount)));
    }
}
