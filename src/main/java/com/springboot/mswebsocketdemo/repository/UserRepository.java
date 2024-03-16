package com.springboot.mswebsocketdemo.repository;

import com.springboot.mswebsocketdemo.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, String> {

    /**
     * Finds a user by nickname and fullname
     * @param nickName the nickname
     * @param fullName the fullname
     * @return the User
     */
    Optional<User> findByNickNameAndFullName(String nickName, String fullName);
}
