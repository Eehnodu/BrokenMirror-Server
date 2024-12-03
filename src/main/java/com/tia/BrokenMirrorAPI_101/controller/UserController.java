package com.tia.BrokenMirrorAPI_101.controller;

import com.tia.BrokenMirrorAPI_101.entity.Friend;
import com.tia.BrokenMirrorAPI_101.entity.User;
import com.tia.BrokenMirrorAPI_101.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/users")  // 공통 경로
public class UserController {

    @Autowired
    private UserService userService;

    // userJoin (회원가입) - POST /users
    @PostMapping
    public User userJoin(@RequestBody User user){
        return userService.userJoin(user);
    }

    // userLogin (로그인) - POST /users/login
    @PostMapping("/login")
    public Optional<User> userLogin(@RequestBody User user){
        return userService.userLogin(user);
    }

    // currentPw (현재 비밀번호 확인) - POST /users/{id}/password/check
    @PostMapping("/{id}/password/check")
    public Optional<User> currentPw(@PathVariable("id") String id){
        return userService.currentPw(id);
    }

    // newPw (비밀번호 변경) - PUT /users/{id}/password
    @PutMapping("/{id}/password")
    public User newPw(@PathVariable("id") String id, @RequestParam String pw){
        return userService.newPw(id, pw);
    }

    // currentPhoneNum (현재 전화번호 확인) - POST /users/{id}/phone/check
    @PostMapping("/{id}/phone/check")
    public Optional<User> currentPhoneNum(@PathVariable("id") String id){
        return userService.currentPhoneNum(id);
    }

    // newPhoneNum (전화번호 변경) - PUT /users/{id}/phone
    @PutMapping("/{id}/phone")
    public User newPhoneNum(@PathVariable("id") String id, @RequestParam String phoneNum){
        return userService.newPhoneNum(id, phoneNum);
    }

    // userDelete (회원 탈퇴) - DELETE /users/{id}
    @DeleteMapping("/{id}")
    public void userDelete(@PathVariable("id") String id){
        userService.userDelete(id);
    }

    // newUserName (이름 변경) - PUT /users/{id}/name
    @PutMapping("/{id}/name")
    public User newUserName(@PathVariable("id") String id, @RequestParam String userName){
        return userService.newUserName(id, userName);
    }

    // findId (아이디 찾기)
    @PostMapping("/findid")
    public User findId(@RequestBody User user){
        return userService.findId(user);
    }

    // findPw (비밀번호 찾기)
    @PostMapping("/findpw")
    public User findPw(@RequestParam String id, @RequestParam String userName,
                       @RequestParam String birth, @RequestParam String phoneNum,
                       @RequestParam String address){
        return userService.findPw(id, userName, birth, phoneNum, address);
    }

    // newImage (이미지 변경)
    @PutMapping("/{id}/image")
    public User newImage(@PathVariable("id") String id, @RequestParam String profileImg){
        return userService.newImage(id, profileImg);
    }

    // certifyMail (인증번호 메일 발송)
    @PostMapping("{id}/certify")
    public String certifyMail(@PathVariable("id") String id){
        return userService.certifyMail(id);
    }

    @PostMapping("{id}/friend")
    public List<User> getFriendInfo(@PathVariable("id") String id, @RequestBody List<Friend> friendlist){
        return userService.getFriendInfo(friendlist);
    }
}