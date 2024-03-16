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

    /**
     * The Constructor
     * @param userRepository the user repository
     */
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    /**
     * Saves a user in the DDBB
     * @param user the User
     */
    @Override
    public void saveUser(User user) {
        Optional.of(user)
                .map(this::validateAlreadyExists)
                .map(userRepository::save);
    }

    /**
     * Disconnects a user
     * @param user the User
     */
    @Override
    public void disconnect(User user) {
        Optional<User> storedUser = userRepository.findByNickNameAndFullName(user.getNickName(), user.getFullName());
        storedUser.ifPresent(given -> {
            int devicesInUse = given.getDevicesInUse();
            given.setDevicesInUse(devicesInUse-1);
            if(given.getDevicesInUse() == 0){
                given.setStatus(UserStatusEnum.OFFLINE);
            }
            userRepository.save(given);
        });
    }

    /**
     * Finds all the users in the app
     * @return a List of Users
     */
    @Override
    public List<User> findUsers() {
        return userRepository.findAll();
    }

    /**
     * Method to check if a user already exists
     * @param user the user
     * @return the user
     */
    private User validateAlreadyExists(User user){
        Optional<User> savedUser = userRepository.findByNickNameAndFullName(user.getNickName(), user.getFullName());
        savedUser.ifPresent(given -> {
            given.setDevicesInUse(given.getDevicesInUse()+1);
            BeanUtils.copyProperties(given, user);
        });

        user.setStatus(UserStatusEnum.ONLINE);
        return user;
    }
}
