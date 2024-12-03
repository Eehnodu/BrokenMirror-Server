package com.tia.BrokenMirrorAPI_101.repository;

import com.tia.BrokenMirrorAPI_101.entity.Friend;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

// JpaRepository를 상속받아, 기본적인 CRUD 메서드와 JPA 쿼리 메서드를 제공하는 인터페이스
@Repository
public interface FriendRepository extends JpaRepository<Friend, String> {
    List<Friend> findByUserId1(String userId);
}
