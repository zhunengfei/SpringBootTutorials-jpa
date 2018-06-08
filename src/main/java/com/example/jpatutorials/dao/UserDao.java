package com.example.jpatutorials.dao;


import com.example.jpatutorials.entity.User;

/**
 * jpa方式操作数据库
 */
public interface UserDao {

  User getById(int id);

  User getByNumber(String number);


  User getByName(String name);


  int addUser(User user);

  void deleteUserById(int id);

  User updateUser(User user);

}
