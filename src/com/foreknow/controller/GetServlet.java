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
import java.util.List;

public class GetServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
        resp.setContentType("text/html;charset=UTF-8");
        req.setCharacterEncoding("UTF-8");
        PrintWriter out = resp.getWriter();
        GuestbookService service = new GuestbookServiceImpl();
        List<Object> list = null;
        list = service.queryInfo();
        out.println("<html>");
        out.println("<head><title>test</title></head>");
        out.println("<body>");
        out.println("<table border='1'>");
        out.println("<tr>");
        out.println("<td>id</td>");
        out.println("<td>name</td>");
        out.println("<td>phone</td>");
        out.println("<td>email</td>");
        out.println("<td>title</td>");
        out.println("<td>content</td>");
        out.println("<td>createdtime</td>");
        out.println("</tr>");
        for(int i = 0;i<list.size();i++){
            Guestbook gb = (Guestbook) list.get(i);
            out.println("<tr>");
            out.println("<td>"+gb.getId()+"</td>");
            out.println("<td>"+gb.getName()+"</td>");
            out.println("<td>"+gb.getPhone()+"</td>");
            out.println("<td>"+gb.getEmail()+"</td>");
            out.println("<td>"+gb.getTitle()+"</td>");
            out.println("<td>"+gb.getContent()+"</td>");
            out.println("<td>"+gb.getTime()+"</td>");
            out.println("</tr>");
        }
        out.println("</table>");
        out.println("</body>");
        out.println("</html>");
    }



    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
     doGet(req, resp);
    }
}
