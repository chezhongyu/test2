package com.foreknow.controller;

import com.foreknow.bean.Guestbook;
import com.foreknow.mapping.EntityMapping;
import com.foreknow.mapping.MappingFactory;
import com.foreknow.service.GuestbookService;
import com.foreknow.service.impl.GuestbookServiceImpl;
import com.foreknow.util.Pagination;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class ManagerServlet extends HttpServlet {
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
        GuestbookService service = new GuestbookServiceImpl();
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
        EntityMapping mapping = mappingFactory.getMap(MappingFactory.GUEST_MAPPING);
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
        req.getRequestDispatcher("/list.jsp").forward(req,resp);
    }
    public void delete(HttpServletRequest req, HttpServletResponse resp) throws IOException, SQLException, ServletException {
        resp.setContentType("text/html;charset=UTF-8");
        req.setCharacterEncoding("UTF-8");
        PrintWriter out = resp.getWriter();
        //获取前台参数
        String id = req.getParameter("id");
        GuestbookService service = new GuestbookServiceImpl();
        boolean boo = service.deleteInfo(Integer.parseInt(id));
        if(boo==true){
            req.getRequestDispatcher("/usermanager?q=list").forward(req,resp);
        }else{
            out.println("flase");
        }
    }




    public void insert(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
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

