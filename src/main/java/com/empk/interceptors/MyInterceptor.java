package com.empk.interceptors;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;

import com.empk.entity.Emp;

public class MyInterceptor implements HandlerInterceptor{

	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		String requestURI = request.getRequestURI();

		Emp emp = (Emp) request.getSession().getAttribute("loginuser");

		//checks if user is loggin in or not
		if (emp == null) {
			response.sendRedirect(request.getContextPath() + "/login");
			// response.getWriter().print("<h1> Please Login</h1>");
			return false;
		} else {
			return true;
		}

	}
}
