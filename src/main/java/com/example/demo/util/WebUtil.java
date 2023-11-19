package com.example.demo.util;

import com.example.demo.domin.Users;


import jakarta.servlet.http.*;
public class WebUtil {
    //session
    public void addUserToSession(HttpSession session, Users users) {
        session.setAttribute("user", users);
    }
    //cookie
    public void addUserIdToCookie(HttpServletResponse response, String userId) {
        Cookie cookie = new Cookie("userId", userId);
        cookie.setPath("/");
        cookie.setMaxAge(60 * 60 * 24); // 设置cookie有效期为24小时
        response.addCookie(cookie);
    }
    public void addPNameToCookie(HttpServletResponse response, String pName) {
        Cookie cookie = new Cookie("pName", pName);
        cookie.setPath("/");
        cookie.setMaxAge(60 * 60 * 24); // 设置cookie有效期为24小时
        response.addCookie(cookie);
    }
    public String getUserIdFromCookies(HttpServletRequest request) {
        Cookie[] cookies = request.getCookies();
        if (cookies != null) {
            for (Cookie cookie : cookies) {
                if ("userId".equals(cookie.getName())) {
                    return cookie.getValue();
                }
            }
        }
        return null;
    }
    public String getpNameFromCookies(HttpServletRequest request) {
        Cookie[] cookies = request.getCookies();
        if (cookies != null) {
            for (Cookie cookie : cookies) {
                if ("pName".equals(cookie.getName())) {
                    return cookie.getValue();
                }
            }
        }
        return null;
    }
}
