package com.foreknow.controller;

import com.foreknow.bean.Guestbook;
import com.foreknow.service.GuestbookService;
import com.foreknow.service.impl.GuestbookServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class InsertServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doGet(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
       resp.setContentType("text/html;charset=UTF-8");
       req.setCharacterEncoding("UTF-8");
       PrintWriter out = resp.getWriter();
       String name = req.getParameter("name");
       String phone = req.getParameter("phone");
       String email = req.getParameter("email");
       String title = req.getParameter("title");
       String content = req.getParameter("content");
        Date date = new Date();
        SimpleDateFormat da = new SimpleDateFormat("yyyy-MM-dd");
        String time = da.format(date);

       GuestbookService guestbookService = new GuestbookServiceImpl();
       //将获取的对象封装到gu中
       Guestbook gu = new Guestbook();
        gu.setName(name);
        gu.setPhone(phone);
        gu.setEmail(email);
        gu.setTitle(title);
        gu.setContent(content);
        gu.setTime(time);
        boolean boo = false;
        try {
            boo = guestbookService.isValidate(gu);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        if(boo==true){
//                out.println("<a href='/test2/use'>query info</a>");
            //请求转发
            req.getRequestDispatcher("/usermanager?q=list").forward(req,resp);
            //重定向
           //resp.sendRedirect("/test2/use");

        }else{
                out.println("false");
            }

    }
}
