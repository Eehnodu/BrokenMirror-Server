package com.tia.BrokenMirrorAPI_101.controller;

import com.tia.BrokenMirrorAPI_101.entity.Friend;
import com.tia.BrokenMirrorAPI_101.service.FriendService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/friend")  // 이거 쓰는 거 맞겠지..?
@Slf4j
public class FriendController {

    // @Autowired
    private final FriendService friendService;  // 왜 final이 붙어야 하지..?

    // @Autowired
    public FriendController(FriendService friendService) {
        this.friendService = friendService;
    }

    // getFriendsByUserId (친구목록 가져오기)
    @GetMapping("/user/{userId}")
    public List<Friend> getFriendByUserId(@PathVariable("userId") String userId) {
        return friendService.getFriendByUserId(userId);
    }

    @GetMapping("/all")
    public List<Friend> getAllFriend() {
        return friendService.getAllFriends();
    }

}
