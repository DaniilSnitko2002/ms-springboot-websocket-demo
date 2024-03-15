package com.springboot.mswebsocketdemo.service.impl;

import com.springboot.mswebsocketdemo.constant.UserStatusEnum;
import com.springboot.mswebsocketdemo.entity.User;
import com.springboot.mswebsocketdemo.repository.UserRepository;
import com.springboot.mswebsocketdemo.service.UserService;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public void saveUser(User user) {
        Optional.of(user)
                .map(this::validateAlreadyExists)
                .map(userRepository::save);
    }

    @Override
    public void disconnect(User user) {
        var storedUser = userRepository.findByNickNameAndFullName(user.getNickName(), user.getFullName()).orElse(null);
        if (storedUser != null) {
            storedUser.setStatus(UserStatusEnum.OFFLINE);
            userRepository.save(storedUser);
        }
    }

    @Override
    public List<User> findConnectedUsers() {
        return userRepository.findAllByStatus(UserStatusEnum.ONLINE);
    }

    /**
     * Method to check if a user already exists
     * @param user the user
     * @return the user
     */
    private User validateAlreadyExists(User user){
        Optional<User> savedUser = userRepository.findByNickNameAndFullName(user.getNickName(), user.getFullName());

        savedUser.ifPresent(given -> BeanUtils.copyProperties(given, user));

        user.setStatus(UserStatusEnum.ONLINE);
        return user;
    }
}
