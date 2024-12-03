//package com.tia.BrokenMirrorAPI_101.entity;
//
//import java.io.Serializable;
//import java.util.Objects;
//
//public class FriendId implements Serializable {
//    private String userId1;
//    private String userId2;
//
//    // 기본 생성자
//    public FriendId() {}
//
//    // equals()와 hashCode() 메서드 구현 필요
//    @Override
//    public boolean equals(Object o) {
//        if (this == o) return true;
//        if (!(o instanceof FriendId)) return false;
//        FriendId that = (FriendId) o;
//        return userId1.equals(that.userId1) && userId2.equals(that.userId2);
//    }
//
//    @Override
//    public int hashCode() {
//        return Objects.hash(userId1, userId2);
//    }
//}
//
//
package com.tia.BrokenMirrorAPI_101.entity;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.Objects;

@Setter
@Getter
public class FriendId implements Serializable {
    private String userId1;
    private String userId2;

    // 기본 생성자
    public FriendId() {
    }

    // equals()와 hashCode() 메서드 구현
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof FriendId)) return false;
        FriendId that = (FriendId) o;
        return Objects.equals(userId1, that.userId1) && Objects.equals(userId2, that.userId2);
    }

    @Override
    public int hashCode() {
        return Objects.hash(userId1, userId2);
    }
} //복합키
