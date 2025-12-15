package com.revature.users.dao;

import com.revature.users.model.User;

public interface UserRepository {
    public User findById(Long id);
    public void save (User user);
    public User findByEmail(String email);
    public boolean register(User user);
}
