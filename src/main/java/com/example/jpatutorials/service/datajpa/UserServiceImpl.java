package com.example.jpatutorials.service.datajpa;

import com.example.jpatutorials.dao.UserRepository;
import com.example.jpatutorials.entity.User;
import java.util.List;
import org.apache.shiro.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service("userService2")
@Transactional
public class UserServiceImpl implements UserService {

  @Autowired
  private UserRepository userRepository;

  @Override
  public User findById(int id) {
    return this.userRepository.getOne(id);
  }

  @Override
  public User findByNumber(String number) {
    return this.userRepository.findByNumber(number);
  }

  @Override
  public List<User> findAllUserByPage(int page, int size) {
    Pageable pageable = new PageRequest(page, size);
    Page<User> users = this.userRepository.findAll(pageable);
    return users.getContent();
  }

  @Override
  public User updateUser(User user, boolean throwEx) {
    User userNew = this.userRepository.save(user);
    if (throwEx) {
      throw new RuntimeException("throw a ex");
    }
    return userNew;
  }

  @Override
  public void deleteUser(int id) {
    this.userRepository.deleteUser(id);
  }

  @Override
  public User getLoginUser() {
    String number = SecurityUtils.getSubject().getPrincipal().toString();
    System.out.println("login user is:" + number);
    return this.userRepository.findByNumber(number);
  }
}
