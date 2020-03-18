package com.example.springboot.web.dto;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class HelloResponseDtoTest {
    @Test
    public void 롬복_기능_테스트() {
        //given
        String name = "test";
        int amount = 1000;

        //when
        HelloResponseDto dto = new HelloResponseDto(name, amount);

        //then
        assertThat(dto.getName()).isEqualTo(name);
        assertThat(dto.getAmount()).isEqualTo(amount);

        //assertThat
        //assertj라는 테스트 검증 라이브러리의 메서드
        //검증하고 싶은 대상을 메서드 인자로 받는다.
        //isEqualTo
        //동등비교 메서드. assertThat의 값과 비교해서 같을 때만 성공
    }
}
