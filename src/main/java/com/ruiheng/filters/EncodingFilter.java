package com.ruiheng.filters;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
/**
 * 过滤器乱码
 * @author Administrator
 *
 */
@WebFilter(urlPatterns = { "/*" })
public class EncodingFilter implements Filter{

	public void init(FilterConfig filterConfig) throws ServletException {

	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		//修改request请求与response响应的编码
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
//		System.out.println("进入过滤器，过滤");
		//放行
		chain.doFilter(request, response);
	}

	public void destroy() {

		}

}
