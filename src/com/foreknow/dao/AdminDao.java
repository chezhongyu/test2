package com.foreknow.dao;

//AdminDao:写对bean  admin的相关操作

import com.foreknow.bean.Admin;

public interface AdminDao {


//    根据句用户名和密码查询用户信息
public Admin login (String username, String password);

//    根据id删除用户的信息
public  boolean delete (Integer id);

//    添加用户的信息
public  boolean insert (Admin admin);

//    修改用户的信息
public  boolean update (Admin admin);

//    根据id查询某一个用户的信息
public Admin select (Integer id);

}
