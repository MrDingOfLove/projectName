package com.ding.ssm.controller.interceptor;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class HandlerInterceptor2 implements HandlerInterceptor {
    /**
     * 进入Handler之前
     * 应用场景：身份认证，身份授权
     */
    @Override
    public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o) throws Exception {
        System.out.println("HandlerINterceptor2-------->preHandle");
        return true;//表示拦截不向下执行
    }
    /**
     * 进入Handler方法之后，返回ModelAndView之前
     */
    @Override
    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {
        System.out.println("HandlerINterceptor2-------->postHandle");
    }
    /**
     * 执行Handler完成后
     * 应用场景：统一异常处理，统一日志处理
     */
    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {
        System.out.println("HandlerINterceptor2-------->afterCompletion");
    }
}
