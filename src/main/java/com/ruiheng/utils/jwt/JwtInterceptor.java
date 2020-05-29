package com.ruiheng.utils.jwt;

import io.jsonwebtoken.Claims;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 自定义拦截器
 * 继承HandlerInterceptorAdapter
 * preHandle进入到控制器方法前执行的内容
 *      boolean:true可以继续执行false:拦截
 * postHandle执行控制器方法后执行内容
 * afterCompletion响应结束之前执行的内容
 *
 * 1.简化获取token数据的代码编写
 *      统一的用户权限校正(是否登录)
 * 2.判断用户是否当前访问接口的权限
 *
 */
@Component
public class JwtInterceptor extends HandlerInterceptorAdapter {

    @Autowired
    private JwtUtils jwtUtils;
    /**
     * 1.通过request获取请求token
     * 2.从token中解析获取claims
     * 3.将claims绑定到request域中
     */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        //通过request获取请求token
        String authorization = request.getHeader("Authorization");
        System.out.println("请求头数据==="+authorization);
        //判断请求信息是否为空,或者是否已Bearer开头
        if (!StringUtils.isEmpty(authorization) && authorization.startsWith("Bearer")){
            //获取token数据
            String token = authorization.replace("Bearer ","");
            //解析token获取claims
            Claims claims = jwtUtils.parseJwt(token);
            if (claims != null){
                request.setAttribute("user_claims",claims);
                return true;
            }
        }
        System.out.println("空---------------------------------------------");
        return false;
    }

}
