package com.tia.BrokenMirrorAPI_101.repository;

import com.tia.BrokenMirrorAPI_101.entity.LoginInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LoginInfoRepository extends JpaRepository<LoginInfo, Long> {

    @Query(value = "SELECT * FROM logininfo WHERE id =:id AND created_at BETWEEN (DATE_ADD(NOW(), INTERVAL -1 MONTH)) AND NOW() ORDER BY created_at DESC LIMIT 50", nativeQuery = true)
    List<LoginInfo> findLoginInfo(@Param("id") String id);
}
