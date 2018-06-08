package com.example.jpatutorials.filter;

import com.example.jpatutorials.common.Constant;
import java.io.IOException;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.web.filter.OncePerRequestFilter;

/**
 * 登录过滤器
 */
//@WebFilter(filterName="loginFilter",urlPatterns="/*")
public class LoginFilter extends OncePerRequestFilter {


  @Override
  protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response,
      FilterChain filterChain) throws ServletException, IOException {
    // 不过滤url
    String[] notFilter = new String[]{"/login", "/logout", "/css", "/js", "/error"};

    // 获取uri
    String url = request.getRequestURI();

    boolean doFilter = chek(notFilter, url);
    if (doFilter) {
      Object obj = request.getSession().getAttribute(Constant.SESSION_USER_KEY);
      //Session过期,是AJAX请求
      if (null == obj) {
        if (null != request.getHeader("x-requested-with") && request.getHeader("x-requested-with")
            .equalsIgnoreCase("XMLHttpRequest")) {
          response.setHeader("sessionstatus", "timeout");
          response.sendError(518, "session timeout.");
          return;
        } else {
          //Session过期,非AJAX请求
          response.sendRedirect(request.getContextPath() + "/common/login");
          return;
        }
      } else {
        filterChain.doFilter(request, response);
      }
    } else {
      filterChain.doFilter(request, response);
    }

  }

  /**
   * @param notFilter 允许url
   * @param url       截获的uri
   * @return false通过  true不通过      
   */
  public boolean chek(String[] notFilter, String url) {
    for (String s : notFilter) {
      if (url.indexOf(s) != -1) { //url中包含不过滤的字符串
        return false;
      }
    }
    return true;
  }
}
