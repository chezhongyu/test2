package com.foreknow.controller;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

public class SessionTest  extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        resp.setContentType("text/html;charset=utf-8");
        PrintWriter out = resp.getWriter();
        //如何获取session对象
        HttpSession session = req.getSession();
        //如何向session中保存数据
        session.setAttribute("username",req.getParameter("username"));
        //如何从session中获取数据
        String name = (String)session.getAttribute("name");
        out.println("JSESSIONID"+session.getId()+"---"+name);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
       doGet(req, resp);
    }
}
