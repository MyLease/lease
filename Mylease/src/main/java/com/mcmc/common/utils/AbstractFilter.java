package com.mcmc.common.utils;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.Filter;

public abstract class AbstractFilter implements Filter {

	public FilterConfig config;
	
	public void destroy() {}  

    public abstract void doFilter(ServletRequest request, ServletResponse response,  
            FilterChain chain) throws IOException, ServletException ;
	
  
    public void init(FilterConfig filterConfig) throws ServletException {
    	this.config = filterConfig;
    }  

}
