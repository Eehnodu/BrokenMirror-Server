package com.tia.BrokenMirrorAPI_101.dto;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MailDto {
    private String address;
    private String title;
    private String message;
}
