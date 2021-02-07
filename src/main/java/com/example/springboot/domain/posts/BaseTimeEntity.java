package com.example.springboot.domain.posts;

import lombok.Getter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;
import java.time.LocalDateTime;

@Getter
@MappedSuperclass // jpa Entity클래스들이 BaseTimeEntity를 상속할 경우 GaseTimeEntity의 필드도 칼럼으로 인식하도록 한다.
@EntityListeners(AuditingEntityListener.class) //Auditing 기능을 포함시킨다 / auditing기능이란 시간에 대해서 자동으로 값을 넣어주는 기능
public abstract class BaseTimeEntity {

    @CreatedDate //Entity가 생성되어 저장될 때 시간이 자동저장됨
    private LocalDateTime createdDate;

    @LastModifiedDate //조회한 Entity의 값을 변경할 때 시간이 자동저장됨
    private LocalDateTime modifiedDate;
}
