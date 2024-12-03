package com.tia.BrokenMirrorAPI_101.controller;

import com.tia.BrokenMirrorAPI_101.entity.LoginInfo;
import com.tia.BrokenMirrorAPI_101.service.LoginInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")  // 공통 경로
public class LoginInfoController {
    @Autowired
    private LoginInfoService loginInfoService;

    // putLoginInfo (로그인 내역 등록) // logininfo에 id를 같이 보내는데 path가 필요할까?
    @PostMapping("/putlogininfo")
    public void putLoginInfo(@RequestBody LoginInfo logininfo) {
        loginInfoService.putLoginInfo(logininfo);
    }

    // getLoginInfo (로그인 내역 조회)
    @GetMapping("/{id}/getlogininfo")
    public List<LoginInfo> getLoginInfo(@PathVariable("id") String id) {
        return loginInfoService.getLoginInfo(id);
    }
}
