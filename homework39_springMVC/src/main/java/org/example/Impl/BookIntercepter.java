package org.example.Impl;

import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class BookIntercepter implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        String admin = (String) request.getSession().getAttribute("Admin");
        if (admin != null && admin.equals("Admin")) {
            return true;
        } else {

            request.getSession().setAttribute("Admin", "Admin");
            request.getRequestDispatcher("interceptor.jsp").forward(request, response);

            return false;
        }

    }

  /*  @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        HandlerInterceptor.super.postHandle(request, response, handler, modelAndView);
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        HandlerInterceptor.super.afterCompletion(request, response, handler, ex);
    }*/
}
