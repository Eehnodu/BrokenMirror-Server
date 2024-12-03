package com.tia.BrokenMirrorAPI_101.service;

import com.tia.BrokenMirrorAPI_101.entity.Image;
import com.tia.BrokenMirrorAPI_101.repository.ImageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

@Service
public class ImageService {

    @Autowired
    private ImageRepository imageRepository;

//    private static final String IMAGE_BASE_URL = "http://localhost:8081/profile/"; // 서버의 이미지 URL 기본 주소
    private static final String IMAGE_BASE_URL = "http://10.0.2.2:8081/profile/"; // 서버의 이미지 URL 기본 주소(에뮬레이터)

    public String saveImage(MultipartFile imageFile) throws IOException {
        // 저장할 파일 이름 생성
        String fileName = System.currentTimeMillis() + "-" + imageFile.getOriginalFilename();
        Path directoryPath = Paths.get("profile");
        // 디렉토리가 존재하지 않으면 생성
        if (!Files.exists(directoryPath)) {
            Files.createDirectories(directoryPath);
        }
        // 파일 경로 설정
        Path path = directoryPath.resolve(fileName);
        // 파일 복사
        Files.copy(imageFile.getInputStream(), path, StandardCopyOption.REPLACE_EXISTING);
        // URL 생성: 서버 주소와 저장된 파일 경로 결합
        String imageUrl = IMAGE_BASE_URL + fileName;
        // Image 객체 생성 후 URL 저장
        Image image = new Image();
        image.setImageUrl(imageUrl);  // 데이터베이스에 저장할 URL
        imageRepository.save(image);
        return fileName;
    }
}