package com.didispace.service;

import com.didispace.bean.User;

import java.util.List;

public interface UserService {
    public User getUser(Long id);
    public List<User> findUsers(String userName, String note);
    public int insertUser(User user);
    public int updateUser(User user);
    public int deleteUser(Long id);
}
