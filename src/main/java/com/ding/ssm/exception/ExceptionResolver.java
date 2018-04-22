package com.ding.ssm.exception;

import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 全局异常处理器
 */
public class ExceptionResolver implements HandlerExceptionResolver {
    /**
     * o:处理器适配器要执行的handler只有(method)
     * e:系统抛出的异常
     */
    @Override
    public ModelAndView resolveException(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) {
        //解析异常类型
        //如果是系统自定义异常，提取异常信息，在错误页面显示
        CustomException customException = null;
        if (e instanceof CustomException){
            customException = (CustomException)e;
        }else{
            //如果不是系统自定义异常，构造一个自定义异常类型(异常信息为 "未知错误")
            customException = new CustomException("未知错误");
        }
        String message = customException.getMessage();
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("errorMessage",message);
        modelAndView.setViewName("error");
        return modelAndView;
    }
}
