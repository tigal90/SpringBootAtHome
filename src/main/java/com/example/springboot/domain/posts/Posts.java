package com.example.springboot.domain.posts;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

//Entity에서는 setter를 절대 만들지 않는다 setter의 경우 어느 시점에 값을 넣어주는지 명확하지 않다 따라서 Builder를 통해서 값을 정해진 시점에 명시된 값을 부여한다
@Getter// 클래스 필드 내의 Getter메소드를 자동생성
@NoArgsConstructor //기본 생성자 자동 추가
@Entity //테이블과 링크될 클래스임을 나타냄 ex)SalesManager.java -> sales_manager 테이블
public class Posts extends BaseTimeEntity {

    @Id //해당 테이블의 pk필드
    @GeneratedValue(strategy = GenerationType.IDENTITY) //pk의 생성규칙을 나타냄 GenerationType.IDENTITY옵션을 추가해야만 auto_increment가 된다.
    private Long id; //웬만하면 entity의 pk는 long타입의 auto_increment를 추천(mysql에서는 bigint로 적용됨)

    @Column(length=500, nullable = false) // 테이블의 칼럼 선언하지 않아도 되지만 추가로 변경이 필요한 옵션이 있을경우 사용 / 기본값은 varchar(255)
    private String title;

    @Column(columnDefinition = "TEXT", nullable = false)
    private String content;

    private String author;

    @Builder //해당 클래스의 빌더 패턴 클래스 생성 / 생성자 상단에 선언 시 생성자에 포함된 필드만 빌더에 포함
    public Posts(String title, String content, String author) {
        this.title = title;
        this.content = content;
        this.author = author;
    }

    public void update(String title, String content) {
        this.title = title;
        this.content = content;
    }
}
