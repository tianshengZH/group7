package com.example.demo.util;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class WebUtil {
    //session
    public void addUserIdToSession(HttpSession session, String userId) {
        session.setAttribute("userId", userId);
    }
    //cookie
    public void addUserIdToCookie(HttpServletResponse response, String userId) {
        Cookie cookie = new Cookie("userId", userId);
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
}
