package com.foreknow.controller;

import com.foreknow.bean.Admin;
import com.google.gson.Gson;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class ActionServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter out = resp.getWriter();
        //out.println("ajax测试");
        Admin admin = new Admin();
        admin.setId(22);
        admin.setUsername("123");
        admin.setPassword("1231313");

         Gson gson = new Gson();
        String str = gson.toJson(admin);
        out.println(str);

       // out.println("这是从后台返回的字符串");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req,resp);
    }
}