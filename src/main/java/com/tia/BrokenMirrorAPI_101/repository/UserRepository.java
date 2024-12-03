package com.tia.BrokenMirrorAPI_101.repository;

import com.tia.BrokenMirrorAPI_101.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, String> {
    User findByUserNameAndBirthAndPhoneNum(String userName, String birth, String phoneNum);

    User findByIdAndUserNameAndBirthAndPhoneNum(String id, String userName, String birth, String phoneNum);
}
