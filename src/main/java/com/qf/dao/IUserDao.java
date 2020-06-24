package com.qf.dao;

import com.qf.entity.User;

public interface IUserDao {

    /**
     * 根据id查询用户
     * @param id
     * @return
     */
    public User getUserById(Integer id);
}
