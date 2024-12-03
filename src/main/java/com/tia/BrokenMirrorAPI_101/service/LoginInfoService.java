package com.tia.BrokenMirrorAPI_101.service;

import com.tia.BrokenMirrorAPI_101.entity.LoginInfo;
import com.tia.BrokenMirrorAPI_101.entity.User;
import com.tia.BrokenMirrorAPI_101.repository.LoginInfoRepository;
import com.tia.BrokenMirrorAPI_101.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LoginInfoService {

    @Autowired
    private LoginInfoRepository loginInfoRepository;

    @Autowired
    private UserRepository userRepository;

    // putLoginInfo (로그인 내역 등록)
    public void putLoginInfo(LoginInfo logininfo) {
        Optional<User> user_option = userRepository.findById(logininfo.getId());
        if (user_option.isPresent()) {
            loginInfoRepository.save(logininfo);
        }
    }

    // getLoginInfo (로그인 내역 조회)
    public List<LoginInfo> getLoginInfo(String id) {
        Optional<User> user_option = userRepository.findById(id);
        if(user_option.isPresent()){
            return loginInfoRepository.findLoginInfo(id);
        }else{
            return null;
        }
    }
}
