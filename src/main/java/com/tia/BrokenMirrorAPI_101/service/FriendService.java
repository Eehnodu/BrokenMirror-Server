package com.tia.BrokenMirrorAPI_101.service;

import com.tia.BrokenMirrorAPI_101.entity.Friend;
import com.tia.BrokenMirrorAPI_101.repository.FriendRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class FriendService {

    private final FriendRepository friendRepository;  // final이 아니라 static이라면..?

    public FriendService(FriendRepository friendRepository) {
        this.friendRepository = friendRepository;
    }  // 이건 생성자 같은데 파라미터 부분에 왜 리파지토리 변수가 들어가 있는 거지?

    public List<Friend> getFriendByUserId(String userId) {
        return friendRepository.findByUserId1(userId);
    }

    public List<Friend> getAllFriends() {
        return friendRepository.findAll();  //test
    }

}
