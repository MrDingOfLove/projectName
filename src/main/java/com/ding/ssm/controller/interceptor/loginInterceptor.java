package com.ding.ssm.controller.interceptor;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class loginInterceptor implements HandlerInterceptor {
    /**
     * 进入Handler之前
     * 应用场景：身份认证，身份授权
     */
    @Override
    public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o) throws Exception {
        System.out.println("HandlerINterceptor1-------->prehandle");
        //获取请求的url
        String url = httpServletRequest.getRequestURI();
        //判断是否是公开地址(实际开发公开地址应该放在配置文件中)
        if (url.indexOf("login")>=0){
            return true;
        }
        //判断session
        HttpSession session = httpServletRequest.getSession();
        //从session中取出用户信息
        String username = (String) session.getAttribute("username");
        String pwd = (String) session.getAttribute("pwd");
        if (username!=null){
            //身份存在
            if (true){
                //再次验证身份信息(如：过程中修改过密码)
                return true;
            }
        }
        //验证失败 跳回登录页面
        httpServletRequest.getRequestDispatcher("/WEB-INF/login.jsp").forward(httpServletRequest,httpServletResponse);
        return false;//表示拦截不向下执行
    }
    /**
     * 进入Handler方法之后，返回ModelAndView之前
     */
    @Override
    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {
        System.out.println("HandlerINterceptor1-------->postHandle");
    }
    /**
     * 执行Handler完成后
     * 应用场景：统一异常处理，统一日志处理
     */
    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {
        System.out.println("HandlerINterceptor1-------->afterCompletion");
    }
}
