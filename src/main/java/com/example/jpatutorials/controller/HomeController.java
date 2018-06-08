package com.example.jpatutorials.controller;

import com.alibaba.fastjson.JSONObject;
import com.example.jpatutorials.entity.User;
import com.example.jpatutorials.service.datajpa.UserService;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.apache.shiro.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping("/home")
public class HomeController {

  @Autowired
  UserService userService;

  @RequestMapping("")
  public String index(HttpSession session, ModelMap map, HttpServletRequest request) {
//        User user = (User) session.getAttribute("user");

    System.out.println(request.getUserPrincipal().getName());
    System.out.println(SecurityUtils.getSubject().getPrincipal());

    User loginUser = userService.getLoginUser();
    System.out.println(JSONObject.toJSONString(loginUser));

    map.put("user", loginUser);
    return "home";
  }


}
