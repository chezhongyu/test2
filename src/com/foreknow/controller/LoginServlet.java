package com.foreknow.controller;

import com.foreknow.bean.Admin;
import com.foreknow.service.AdminService;
import com.foreknow.service.impl.AdminServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * LoginServlet 作用主要来处理Login.html页面发送的1请求
 * 规则：
 * 1.所有的Servlet都要继承HttpServlet
 * 2.要重写HttpServlet中的doGet，doPost方法
 *    如果客户端向服务器端发的是post请求，后台自动调用doPost方法
 *    如果客户端向服务器端发的是get请求，后台自动调用doGet方法
 *    HttpServletRequest req表示请求对象，它是一个接口
 *    HttpServletResponse resp表示响应对象，它是一个接口
 *    注意：所有的web应用都是基于请求和响应的
 */
public class LoginServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doGet(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
       //设置服务器端响应给客户端的内容的类型
        resp.setContentType("text/html;charset=UTF-8");
        //客户端向服务器端发送请求的编码
        req.setCharacterEncoding("UTF-8");
        HttpSession session = req.getSession();
        PrintWriter out = resp.getWriter();
        //如何提取表单的参数   ?username=xxxxx&password=xxxxx
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        //调用Service层的方法
        AdminService adminService = new AdminServiceImpl();
        Admin admin = adminService.isValidate(username,password);
        if(admin!=null){
            //session.setAttribute("admin",admin);
            //转发资源
            req.getRequestDispatcher("/index.jsp").forward(req,resp);
        }else{
            out.println("no data");
        }




    }
}
