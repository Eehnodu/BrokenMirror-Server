// 참고 : https://wooj-coding-fordeveloper.tistory.com/76
// 참고2 : https://ccomccomhan.tistory.com/131

// 참고3 : https://kkkdh.tistory.com/entry/JPA-%EC%97%94%ED%8B%B0%ED%8B%B0-%EB%A7%A4%ED%95%91

// DB 테이블과 매핑될 엔티티 클래스
package com.tia.BrokenMirrorAPI_101.entity;


import jakarta.persistence.*;
import lombok.*;

@Getter  // 엔티티의 필드를 조회해야 할 경우 Getter는 무조건 필요
@NoArgsConstructor(access = AccessLevel.PROTECTED)  // 기본생성자 만듦 + 영속성 지키기 위해 protected 설정
@AllArgsConstructor
@Builder  // 선언한 클래스의 'builder 패턴을 갖는 클래스'를 생성한다
// JPA에서는 Setter를 쓰지 않는다. cuz 영속성을 잃어버릴 수도 있어서. 그래서 빌더 패턴을 사용하는 것
@Data
@Entity  // Friend라는 객체와 DB테이블을 매핑해줌. (JPA가 관리한다)
@Table(name = "friend")  // 테이블 이름 지정
@IdClass(FriendId.class)
public class Friend {

    @Id
    @Column(name = "user_id1", nullable = false)
    private String userId1;

    @Id
    @Column(name = "user_id2", nullable = false)
    private String userId2;

    @Column(name = "certified_key", nullable = false)
    private int certifiedKey;

}
// 안되면 기본생성자 public Friend() {} 랑 필드별 생성자 추가하기
// 그리고 각 필드마다 매핑 어노테이션 @Column(name = "컬럼명") 추가해보기