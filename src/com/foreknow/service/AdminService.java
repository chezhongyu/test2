package com.foreknow.service;

import com.foreknow.bean.Admin;

/**
 * 业务层的接口
 */
public interface AdminService {
    /**
     * 验证登录
     * @param username 用户名
     * @param password 密码
     * @return Admin
     */

    public Admin isValidate(String username,String password);
}

