package com.example.fearfree.domain.user;

import java.util.Optional;

public interface UserRepository {

    Optional<User> findUserById(int id);

    User addUser(User user);

    User updateUser(User user);

    void deleteUser(int id);

}
