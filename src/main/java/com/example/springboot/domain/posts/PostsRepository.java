package com.example.springboot.domain.posts;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface PostsRepository extends JpaRepository<Posts, Long> {
    //JpaRepository<Entity클래스, pk타입>을 상속하면 기본 crud메소드가 자동으로 생성된다.
    //Entity틀래스와 기본 Entity Repository는 함께 위치시켜야 한다.

    @Query("SELECT p FROM Posts p ORDER BY p.id DESC")
    List<Posts> findAllDesc();
}
