package com.tia.BrokenMirrorAPI_101.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class FriendDto {
    private String userId1;
    private String userId2;
    private int certifiedKey;
}