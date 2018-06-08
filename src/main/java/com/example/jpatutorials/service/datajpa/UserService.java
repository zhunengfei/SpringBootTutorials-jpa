package com.example.jpatutorials.service.datajpa;

import com.example.jpatutorials.entity.User;
import java.util.List;

public interface UserService {

  User findById(int id);

  User findByNumber(String number);

  List<User> findAllUserByPage(int page, int size);

  User updateUser(User user, boolean throwEx);

  void deleteUser(int id);

  User getLoginUser();
}
