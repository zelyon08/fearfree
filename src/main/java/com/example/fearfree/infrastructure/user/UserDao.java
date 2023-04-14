package com.example.fearfree.infrastructure.user;

import com.example.fearfree.domain.user.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserDao extends CrudRepository<User, Integer> {
}
