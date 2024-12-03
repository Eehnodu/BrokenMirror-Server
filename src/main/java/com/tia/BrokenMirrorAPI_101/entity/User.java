package com.tia.BrokenMirrorAPI_101.entity;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.DynamicUpdate;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;

@Entity
@Builder
@Table(name = "user")
@Data
@AllArgsConstructor
@NoArgsConstructor
@EntityListeners(AuditingEntityListener.class)
@DynamicUpdate // 원하는 값만 update
public class User {
    @Id
    @Column(name = "id", nullable = false)
    private String id;
    @Column(name = "pw", nullable = false)
    private String pw;
    @Column(name = "user_name", nullable = false)
    private String userName;
    @Column(name = "birth", nullable = false)
    private String birth;
    @Column(name = "phone_num", nullable = false)
    private String phoneNum;
    @Column(name = "profile_img", nullable = false)
    private String profileImg;
    @LastModifiedDate //엔티티 최종 수정 날짜를 자동으로 데이터베이스에 매핑해주기 위해 사용
    @Column(name = "updated_at", nullable = false)
    private LocalDateTime updatedAt;
    @CreatedDate //엔티티 생성 시 특정 필드를 자동으로 데이터베이스에 매핑해주기 위해 사용
    @Column(name = "created_at", nullable = false, updatable = false)
    private LocalDateTime createdAt;
}
