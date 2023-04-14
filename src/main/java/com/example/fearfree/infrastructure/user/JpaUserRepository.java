package com.example.fearfree.infrastructure.user;

import com.example.fearfree.domain.user.User;
import com.example.fearfree.domain.user.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public class JpaUserRepository implements UserRepository {

    @Autowired
    UserDao userDao;

    public JpaUserRepository(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public Optional<User> findUserById(int id) {
        return userDao.findById(id);
    }

    @Override
    public User addUser(User user) {
        return userDao.save(user);
    }

    @Override
    public User updateUser(User user) {
        return userDao.save(user);
    }

    @Override
    public void deleteUser(int id) {
        userDao.deleteById(id);
    }
}
