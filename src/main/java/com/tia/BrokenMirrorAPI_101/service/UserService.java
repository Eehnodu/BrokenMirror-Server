package com.tia.BrokenMirrorAPI_101.service;

import com.tia.BrokenMirrorAPI_101.dto.MailDto;
import com.tia.BrokenMirrorAPI_101.entity.Friend;
import com.tia.BrokenMirrorAPI_101.entity.User;
import com.tia.BrokenMirrorAPI_101.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private MailService mailService;

    // UserLogin (회원가입)
    public User userJoin(User user) {
        return userRepository.save(user);
    }

    // UserLogin (로그인)
    public Optional<User> userLogin(User user) {
        Optional<User> user_option = userRepository.findById(user.getId());
        if (user_option.isPresent()) {
            return userRepository.findById(user.getId());
        } else {
            return Optional.empty();
        }
    }

    // CurrentPw (현재 비밀번호 확인)
    public Optional<User> currentPw(String id) {
        Optional<User> user_option = userRepository.findById(id);
        if (user_option.isPresent()) {
            return userRepository.findById(id);
        } else {
            return Optional.empty();
        }
    }

    // NewPw (비밀번호 변경)
    public User newPw(String id, String pw) {
        Optional<User> user_option = userRepository.findById(id);
        if (user_option.isPresent()) {
            User update_pw = user_option.get();
            update_pw.setPw(pw);
            return userRepository.save(update_pw);
        } else {
            return null;
        }
    }

    // CurrentPhoneNum (현재 전화번호 확인)
    public Optional<User> currentPhoneNum(String id) {
        Optional<User> user_option = userRepository.findById(id);
        if (user_option.isPresent()) {
            return userRepository.findById(id);
        } else {
            return Optional.empty();
        }
    }

    // NewPhoneNum (전화번호 변경)
    public User newPhoneNum(String id, String phoneNum) {
        Optional<User> user_option = userRepository.findById(id);
        if (user_option.isPresent()) {
            User update_phone_num = user_option.get();
            update_phone_num.setPhoneNum(phoneNum);
            return userRepository.save(update_phone_num);
        } else {
            return null;
        }
    }

    // userDelete (회원 탈퇴)
    public void userDelete(String id) {
        Optional<User> user_option = userRepository.findById(id);
        if (user_option.isPresent()) {
            userRepository.deleteById(id);
        }
    }

    // newUserName (이름 변경)
    public User newUserName(String id, String userName) {
        Optional<User> user_option = userRepository.findById(id);
        if (user_option.isPresent()) {
            User update_user_name = user_option.get();
            update_user_name.setUserName(userName);
            return userRepository.save(update_user_name);
        } else {
            return null;
        }
    }

    // findId (아이디 찾기)
    public User findId(User user) {
        Optional<User> user_option = Optional.ofNullable(userRepository.findByUserNameAndBirthAndPhoneNum(user.getUserName(), user.getBirth(), user.getPhoneNum()));
        if (user_option.isPresent()) {
            return userRepository.findByUserNameAndBirthAndPhoneNum(user.getUserName(), user.getBirth(), user.getPhoneNum());
        } else {
            return null;
        }
    }

    // findPw (비밀번호 찾기)
    public User findPw(String id, String userName, String birth, String phoneNum, String address) {
        Optional<User> user_option = Optional.ofNullable(userRepository.findByIdAndUserNameAndBirthAndPhoneNum(id, userName, birth, phoneNum));
        if (user_option.isPresent()) {
            String pw = mailService.getTempPw();
            MailDto maildto = mailService.createMail(address, pw);
            mailService.sendMail(maildto);
            User find_pw = user_option.get();
            find_pw.setPw(pw);
            return userRepository.save(find_pw);
        } else {
            return null;
        }
    }

    // newImage (이미지 변경)
    public User newImage(String id, String profileImg) {
        Optional<User> user_option = userRepository.findById(id);
        if (user_option.isPresent()) {
            User update_user_image = user_option.get();
            update_user_image.setProfileImg(profileImg);
            return userRepository.save(update_user_image);
        } else {
            return null;
        }
    }

    // certifyMail (인증번호 메일 발송)
    public String certifyMail(String id) {
        String num = mailService.certifyNum();
        MailDto maildto = mailService.certifyMail(id, num);
        mailService.sendMail(maildto);
        return num;
    }

    // getFriendInfo (친구 유저 정보 조회)
    public List<User> getFriendInfo(List<Friend> friendlist) {
        List<String> userIds = new ArrayList<>();
        for (Friend friend : friendlist) {
            userIds.add(friend.getUserId2());
        }
        return userRepository.findAllById(userIds);
    }
}
