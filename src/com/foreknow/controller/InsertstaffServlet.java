package com.foreknow.controller;

import com.foreknow.bean.Staff;
import com.foreknow.service.StaffService;
import com.foreknow.service.impl.StaffServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

/**
 * create by foreknow on 2021/1/7
 */
public class InsertstaffServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doGet(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=UTF-8");
        req.setCharacterEncoding("UTF-8");
        PrintWriter out = resp.getWriter();
        String number = req.getParameter("number");
        String name = req.getParameter("name");
        String sex = req.getParameter("sex");
        String age = req.getParameter("age");
        String height = req.getParameter("height");
        String date = req.getParameter("date");
        String nation = req.getParameter("nation");
        String place = req.getParameter("place");
        String phone = req.getParameter("phone");
        String email = req.getParameter("email");
        String political = req.getParameter("political");
        String department = req.getParameter("department");
        String post = req.getParameter("post");
        String entrydate = req.getParameter("entrydate");
        String workingdate = req.getParameter("workingdate");

        StaffService service = new StaffServiceImpl();
        //将获取的对象封装到staff中
        Staff staff = new Staff();
        staff.setNumber(number);
        staff.setName(name);
        staff.setSex(sex);
        staff.setAge(Integer.valueOf(age));
        staff.setHeight(height);
        staff.setDate(date);
        staff.setNation(nation);
        staff.setPlace(place);
        staff.setPhone(phone);
        staff.setEmail(email);
        staff.setPolitical(political);
        staff.setDepartment(department);
        staff.setPost(post);
        staff.setEntrydate(entrydate);
        staff.setWorkingdate(workingdate);
        boolean boo = false;
        try {
            boo = service.isValidate(staff);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        if(boo==true){
//                out.println("<a href='/test2/use'>query info</a>");
            //请求转发
            req.getRequestDispatcher("/sta?q=list").forward(req,resp);
            //重定向
            //resp.sendRedirect("/test2/use");

        }else{
            out.println("false");
        }

    }

}
