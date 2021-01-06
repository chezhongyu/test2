package com.foreknow.test;

import com.foreknow.bean.Admin;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;


public class DBUtil {
    public static void main(String[] args) {
        //1.数据库加载驱动
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            //2.获取连接
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/hr_systemdb?&useSSL=false&serverTimezone=UTC","root","95174921");
            //3.获取到prepareStatement
            PreparedStatement pstmt = connection.prepareStatement("select * from admin where username=? and password=?");
            //4.将？替换成具体的值  setString(第几个？，具体的值)
            pstmt.setString(1,"123");
            pstmt.setString(2,"123");
            //5.执行查询
            ResultSet  rs = pstmt.executeQuery();

            List<Admin> list = new ArrayList<Admin>();
            while(rs.next()){
                //获取当前行列的值
              String username = rs.getString("username");
              String password = rs.getString("password");
              Integer id = rs.getInt("id");
                System.out.println(id+"   "+username+"-----"+password);
                //将获取到的数据以对象的方式保存到list集合中去
                Admin admin = new Admin();
                admin.setUsername(username);
                admin.setPassword(password);
                admin.setId(id);
                list.add(admin);
            }
            //遍历list集合中的数据
            for (Admin a:list) {
                System.out.println(a.getId()+"  "+a.getUsername()+"  "+a.getPassword());

            }


            //关闭资源
            rs.close();
            pstmt.close();
            connection.close();

        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }
}
