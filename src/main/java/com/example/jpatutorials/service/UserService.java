package com.example.jpatutorials.service;


import com.example.jpatutorials.entity.User;

public interface UserService {

  User getById(int id);

  User getByNumber(String number);

  int addUser(User user);

  void deleteUserById(int id);

  User updateUser(User user, boolean throwEx);
}
