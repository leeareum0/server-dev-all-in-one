package com.group.libraryapp.controller.user;

import com.group.libraryapp.domain.user.Fruit;
import com.group.libraryapp.dto.user.request.UserCreateRequest;
import com.group.libraryapp.dto.user.request.UserUpdateRequest;
import com.group.libraryapp.dto.user.response.UserResponse;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {

    //필드 선언
    private final JdbcTemplate jdbcTemplate;

    //생성사 생성
    public UserController(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @PostMapping("/user") //POST /user
    public void saveUser(@RequestBody UserCreateRequest request) {
        String sql = "INSERT INTO user (name, age) VALUES (?, ?)"; //입력값을 넣어야 해서 ? 사용
        jdbcTemplate.update(sql, request.getName(), request.getAge()); //?값 순서대로 작성
    }

    @GetMapping("/fruit")
    public Fruit fruit() {
        return new Fruit("바나나", 2000); //객체 반환
    }

    @GetMapping("/user")
    public List<UserResponse> getUsers() {

        String sql = "SELECT * FROM user";

        //익명 클래스
        //RowMapper - sql 실행 후 user 정보를 선언한 타입인 UserResponse 전환해주는 역할(람다 사용)
        return jdbcTemplate.query(sql, (rs, rowNum) -> {
            long id = rs.getLong("id");
            String name = rs.getString("name");
            int age = rs.getInt("age");
            return new UserResponse(id, name, age);
        });
    }

    //수정
    @PutMapping("/user")
    public void updateUser(@RequestBody UserUpdateRequest request) {
        String sql = "UPDATE user SET name = ? WHERE id = ?";
        jdbcTemplate.update(sql, request.getName(), request.getId());
    }

}
