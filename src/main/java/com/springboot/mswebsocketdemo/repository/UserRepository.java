package com.springboot.mswebsocketdemo.repository;

import com.springboot.mswebsocketdemo.constant.UserStatusEnum;
import com.springboot.mswebsocketdemo.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, String> {

    List<User> findAllByStatus(UserStatusEnum status);
}
