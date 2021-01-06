package com.foreknow.filter;


import javax.servlet.*;
import java.io.IOException;


/**
 * create by foreknow on 2021/1/5
 */
public class CharacterEncodingFilter implements Filter {

   private FilterConfig config;
   private  String encoding = "IS08859-1";

    @Override
    public void init(FilterConfig config) throws ServletException {

        encoding = config.getInitParameter("encoding");
    }


    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        servletRequest.setCharacterEncoding(encoding);
        servletResponse.setContentType("text/html;charset=UTF-8");
        filterChain.doFilter( servletRequest,servletResponse);
    }


    @Override
public void destroy(){
        config = null;
}



}
