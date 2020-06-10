package com.example.service;

import java.util.List;

import com.blade.ioc.annotation.Bean;
import com.blade.ioc.annotation.Inject;
import com.example.dao.Userdao;
import com.example.model.User;

@Bean
public class UserServiceImpl implements UserService {
    @Inject
    Userdao userDao;

    @Override
    public int insert(User user) {
        return userDao.insertUserData(user);

    }

    @Override
    public List<User> getProjectDetail() {
        return userDao.getProjectDetails();
    }

    @Override
    public User getDetailsOnPid(String pid) {
        return userDao.getDetailsOnPid(pid);
    }

    @Override
    public int deleteDetailOfId(String pid) {
        return userDao.deleteDetailOfId(pid);

    }

}