package com.tia.BrokenMirrorAPI_101.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDto {
    private String id;
    private String pw;
    private String userName;
    private String birth;
    private String phoneNum;
    private String profileImg; // 이미지
    private Date updatedAt;
    private Date createdAt;
}