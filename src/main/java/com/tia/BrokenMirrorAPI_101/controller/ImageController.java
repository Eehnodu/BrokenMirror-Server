package com.tia.BrokenMirrorAPI_101.controller;

import com.tia.BrokenMirrorAPI_101.service.ImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
@RequestMapping("/users")  // 공통 경로
public class ImageController {

    @Autowired
    private ImageService imageService;

    @PostMapping("/profile")
    public String saveImage(@RequestParam MultipartFile imageFile) throws IOException {
        return imageService.saveImage(imageFile); // 이미지 서비스에서 URL을 저장하거나 처리하는 로직
    }
}
