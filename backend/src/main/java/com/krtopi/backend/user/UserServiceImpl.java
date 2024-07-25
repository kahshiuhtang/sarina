package com.krtopi.backend.user;

public class UserServiceImpl implements UserService {
    UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository){
        this.userRepository = userRepository;
    }
    @Override
    public String createUser(UserEntity user) {
        this.userRepository.save(user);
        return "Success";
    }

    @Override
    public String updateUser(UserEntity user) {
        this.userRepository.save(user);
        return "Success";
    }

    @Override
    public String deleteUser(Long id) {
        return "";
    }

    @Override
    public UserEntity getUser(Long id) {
        return null;
    }
}
