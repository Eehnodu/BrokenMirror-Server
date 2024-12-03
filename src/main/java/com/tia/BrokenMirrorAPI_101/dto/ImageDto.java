package com.tia.BrokenMirrorAPI_101.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ImageDto {
    private int imageIdx;
    private String imageUrl;
}
