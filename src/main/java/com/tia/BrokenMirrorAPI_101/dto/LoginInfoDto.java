package com.tia.BrokenMirrorAPI_101.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LoginInfoDto {
    private Long loginIdx;
    private String id;
    private String device;
    private String ip;
    private Date createdAt;
}