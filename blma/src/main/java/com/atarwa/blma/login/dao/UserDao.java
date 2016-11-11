package com.atarwa.blma.login.dao;

import com.atarwa.blma.login.model.User;

public interface UserDao {
	User findUserById(int id);
    User findUserByUserName(String userName);
}
