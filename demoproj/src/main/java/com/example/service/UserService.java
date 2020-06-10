package com.example.service;

import java.util.List;

import com.example.model.User;

public interface UserService {
    public int insert(User user);
    public List<User> getProjectDetail();
    public User getDetailsOnPid(String pid);
    public int deleteDetailOfId(String pid);
}