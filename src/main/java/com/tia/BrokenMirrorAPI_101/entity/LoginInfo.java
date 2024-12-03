package com.tia.BrokenMirrorAPI_101.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;

@Entity
@Builder
@Table(name = "logininfo")
@Data
@AllArgsConstructor
@NoArgsConstructor
@EntityListeners(AuditingEntityListener.class)
public class LoginInfo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "login_idx", nullable = false)
    private Long loginIdx;
    @Column(name = "id", nullable = false)
    private String id;
    @Column(name = "device", nullable = false)
    private String device;
    @Column(name = "ip", nullable = false)
    private String ipAddress;
    @CreatedDate //엔티티 생성 시 특정 필드를 자동으로 데이터베이스에 매핑해주기 위해 사용
    @Column(name = "created_at", nullable = false, updatable = false)
    private LocalDateTime createdAt;
}
