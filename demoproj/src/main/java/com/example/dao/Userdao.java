package com.example.dao;

import java.util.List;

import com.example.model.User;

public interface Userdao {
    public int insertUserData(User user);
    public List<User> getProjectDetails();
    public User getDetailsOnPid(String pid);
    public int deleteDetailOfId(String pid);
    
}