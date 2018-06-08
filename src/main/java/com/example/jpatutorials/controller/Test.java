package com.example.jpatutorials.controller;

import com.alibaba.fastjson.JSONObject;
import com.example.jpatutorials.dao.TestDao;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/test")
public class Test {

  @Autowired
  private TestDao testDao;

  @RequestMapping("")
  public String index() {
    return "Test";
  }

  @RequestMapping("/fly")
  public String hello() {
    return "fly!";
  }

  @RequestMapping("/throwex")
  public String throwex() {
    int a = 3;
    int b = 0;
    return String.valueOf(a / b);
  }

  @RequestMapping("/sessionstore/{id}/{name}")
  public String sessionStore(@PathVariable("id") String id, @PathVariable("name") String name,
      HttpSession session) {
    JSONObject jsonObject = new JSONObject();
    jsonObject.put("id", id);
    jsonObject.put("name", name);
    session.setAttribute("user", jsonObject);
    return jsonObject.toJSONString();
  }

  @RequestMapping("transaction")
  public void testTransaction(boolean throwEx) {
    this.testDao.testTransactionManually(throwEx);
  }

  @RequestMapping("jdbc")
  public void testJdbc() {
    this.testDao.testJdbcTemplate();
  }


}
