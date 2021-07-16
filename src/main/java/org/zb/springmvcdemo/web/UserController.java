package org.zb.springmvcdemo.web;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.zb.springmvcdemo.model.User;

import java.util.List;

@RestController
@RequestMapping("/user")
@CrossOrigin
public class UserController {
    @GetMapping("/list")
    public List<User> list(){
        return List.of(new User(1L,"张三"),new User(2L,"王五"));
    }
}
