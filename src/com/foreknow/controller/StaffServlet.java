package com.foreknow.controller;

import com.foreknow.bean.Staff;
import com.foreknow.mapping.EntityMapping;
import com.foreknow.mapping.MappingFactory;
import com.foreknow.service.StaffService;
import com.foreknow.service.impl.StaffServiceImpl;
import com.foreknow.util.Pagination;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;

/**
 * create by foreknow on 2021/1/7
 */
public class StaffServlet extends HttpServlet {
    private  int pageSize=10;
    @Override
    public void init(ServletConfig config) throws ServletException {

        //要获取到web.xml中配置的全局初始化参数
        this.pageSize = Integer.parseInt(config.getServletContext().getInitParameter("pageSize"));
    }
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //获取请求参数
        String method = req.getParameter("q");
        if("list".equals(method)){
            //调用list方法
            try {
                list(req, resp);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }else if("insert".equals(method)){
            insert(req, resp);
        }else if("delete".equals(method)){
            try {
                delete(req,resp);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }

    public void list(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException, SQLException {
        resp.setContentType("text/html;charset=UTF-8");
        req.setCharacterEncoding("UTF-8");
        PrintWriter out = resp.getWriter();
        StaffService service = new StaffServiceImpl();
        //要从页面中获取页码
        int pageNumber = 0;
        try{
            pageNumber = Integer.parseInt(req.getParameter("pageNo"));

        } catch (Exception e) {
            pageNumber = 1;
        }

        Pagination pagination = service.getByPage(pageSize,pageNumber);
        //获取区间数据
        MappingFactory mappingFactory = MappingFactory.getMappingFactory();
        EntityMapping mapping = mappingFactory.getMap(MappingFactory.STAFF_MAPPING);
        List<Object> list = pagination.getList(mapping);
        //将查询到的list集合保存到服务器端
        //将总记录数保存到request中
        req.setAttribute("total",pagination.getMaxElements());
        //List<Object> list = null;
        //list = service.queryInfo();
        //我们将list保存到request作用域中，然后在list.jsp中获取数据
        //在服务器端保存数据req.setAttribute(key,value)
        req.setAttribute("list",list);
        //out.println(list.size());
        req.getRequestDispatcher("/extra_search.jsp").forward(req,resp);
    }
    public void delete(HttpServletRequest req, HttpServletResponse resp) throws IOException, SQLException, ServletException {
        resp.setContentType("text/html;charset=UTF-8");
        req.setCharacterEncoding("UTF-8");
        PrintWriter out = resp.getWriter();
        //获取前台参数
        String id = req.getParameter("id");
        StaffService service = new StaffServiceImpl();
        boolean boo = service.deleteInfo(Integer.parseInt(id));
        if(boo==true){
            req.getRequestDispatcher("/sta?q=list").forward(req,resp);
        }else{
            out.println("flase");
        }
    }




    public void insert(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
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
        //将获取的对象封装到gu中
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
