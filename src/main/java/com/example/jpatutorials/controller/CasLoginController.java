package com.example.jpatutorials.controller;


import com.example.jpatutorials.config.shiroCas.ShiroCasConfiguration;
import com.example.jpatutorials.entity.User;
import javax.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * 跳转至cas server去登录（一个入口）
 */
@Controller
@RequestMapping("")
public class CasLoginController {

  /**
   * 一般用不到
   */
  @RequestMapping(value = "/login", method = RequestMethod.GET)
  public String loginForm(Model model) {
    model.addAttribute("user", new User());
//      return "login";
    return "redirect:" + ShiroCasConfiguration.loginUrl;
  }


  @RequestMapping(value = "logout", method = {RequestMethod.GET,
      RequestMethod.POST})
  public String loginout(HttpSession session) {
    return "redirect:" + ShiroCasConfiguration.logoutUrl;
  }
}
