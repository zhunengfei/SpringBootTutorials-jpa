package com.example.jpatutorials.service;


import com.example.jpatutorials.dao.UserDao;
import com.example.jpatutorials.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
@Transactional
public class UserServiceImpl implements UserService {

  @Autowired
  private UserDao userDao;

  @Override
  @Transactional(readOnly = true)
  public User getById(int id) {
    return userDao.getById(id);
  }

  @Override
  @Transactional(readOnly = true)
  public User getByNumber(String number) {
    return userDao.getByNumber(number);
  }

  @Override
  public int addUser(User user) {
    return this.userDao.addUser(user);
  }

  @Override
  public void deleteUserById(int id) {
    this.userDao.deleteUserById(id);
  }

  @Override
  public User updateUser(User user, boolean throwEx) {
    User userNew = this.userDao.updateUser(user);
    if (throwEx) {
      throw new RuntimeException("throw a ex");
    }
    return userNew;
  }


}
