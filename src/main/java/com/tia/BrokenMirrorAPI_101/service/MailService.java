package com.tia.BrokenMirrorAPI_101.service;

import com.tia.BrokenMirrorAPI_101.dto.MailDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import java.security.SecureRandom;
import java.util.regex.Pattern;

@Service
public class MailService {

    private MailDto maildto;

    @Autowired
    private JavaMailSender javaMailSender;

    // getTemPw (임시 비밀번호 생성)
    public String getTempPw() {
        SecureRandom random = new SecureRandom();
        String upperCase = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String lowerCase = "abcdefghijklmnopqrstuvwxyz";
        String digits = "0123456789";
        String specialChars = "@$!%*?&";
        String allCharacters = upperCase + lowerCase + digits + specialChars;

        StringBuilder stringBuilder = new StringBuilder();

        // 각 유형에서 하나씩 추가하여 조건을 충족시키도록 함
        stringBuilder.append(upperCase.charAt(random.nextInt(upperCase.length())));
        stringBuilder.append(lowerCase.charAt(random.nextInt(lowerCase.length())));
        stringBuilder.append(digits.charAt(random.nextInt(digits.length())));
        stringBuilder.append(specialChars.charAt(random.nextInt(specialChars.length())));

        // 나머지 자리 랜덤하게 채우기
        for (int i = 4; i < 8; i++) {
            stringBuilder.append(allCharacters.charAt(random.nextInt(allCharacters.length())));
        }

        String random_pw = stringBuilder.toString();

        // 최소 8자리에 영어, 숫자, 특수문자 각 1개 이상 포함
        String pattern = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@$!%*?&])[A-Za-z\\d@$!%*?&]{8,}$";
        if (!Pattern.matches(pattern, random_pw)) {
            return getTempPw();    // 비밀번호 조건에 맞지 않으면 재생성
        }

        return random_pw;
    }

    // createMail (메일 생성)
    public MailDto createMail(String address, String pw) {
        MailDto mail = new MailDto();
        mail.setAddress(address);
        mail.setTitle("[brokenmirror] 임시 비밀번호 발송");
        mail.setMessage("안녕하세요. [brokenmirror] 임시 비밀번호 안내 관련 이메일입니다.\n"
                + "회원님의 임시 비밀번호는 ["
                + pw + "] 입니다.\n" +
                "로그인 후에 비밀번호를 변경해주세요");
        return mail;
    }

    // sendMail (메일 발송)
    public void sendMail(MailDto mail) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setSubject(mail.getTitle());
        message.setText(mail.getMessage());
        message.setTo(mail.getAddress());
        message.setFrom("nodu00719@gmail.com");
        javaMailSender.send(message);
    }

    // certifyNum (인증번호 생성)
    public String certifyNum() {
        SecureRandom random = new SecureRandom();
        String digits = "0123456789";
        StringBuilder stringBuilder = new StringBuilder();
        // 나머지 자리 랜덤하게 채우기
        for (int i = 0; i < 5; i++) {
            stringBuilder.append(digits.charAt(random.nextInt(digits.length())));
        }
        return stringBuilder.toString();
    }

    // certifyMail (인증번호 메일 생성)
    public MailDto certifyMail(String address, String num) {
        MailDto mail = new MailDto();
        mail.setAddress(address);
        mail.setTitle("[brokenmirror] 인증번호 발송");
        mail.setMessage("안녕하세요. [brokenmirror] 인증번호 관련 이메일입니다.\n"
                + "인증번호 ["
                + num + "] 를 정확히 입력해 주시기 바랍니다.\n");
        return mail;
    }
}
