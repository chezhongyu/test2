package com.foreknow.dao;
import java.sql.*;
public class test66 {

        public static void main(String[] args) throws Exception{
            //加载数据库驱动程序
            try{
                Class.forName("com.mysql.cj.jdbc.Driver");
            }catch (ClassNotFoundException cne){
                cne.printStackTrace();
            }
            String dburl = "jdbc:mysql://localhost:3306/db_food?&useSSL=false&serverTimezone=UTC";
            String sql = "SELECT * FROM order_goods ";
            try(    Connection conn = DriverManager.getConnection(dburl,"root","95174921");
                    Statement stmt = conn.createStatement();
                    ResultSet rst = stmt.executeQuery(sql))

            {
                while (rst.next()){
                    System.out.println(rst.getInt(1)+"\t"+
                            rst.getString(2)+"\t"+rst.getString(3)+
                            "\t"+rst.getFloat(4) + "\t" + rst.getInt(5)
                    );
                }

            }catch (SQLException se){
                se.printStackTrace();
            }

        }
    }

