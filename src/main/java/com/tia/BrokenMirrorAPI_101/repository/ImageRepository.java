package com.tia.BrokenMirrorAPI_101.repository;

import com.tia.BrokenMirrorAPI_101.entity.Image;
import com.tia.BrokenMirrorAPI_101.entity.LoginInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ImageRepository extends JpaRepository<Image, Long> {
}
