package com.krtopi.backend.user;

public interface UserService {
    public String createUser(UserEntity user);
    public String updateUser(UserEntity user);
    public String deleteUser(Long id);
    public UserEntity getUser(Long id);
}
