package com.atarwa.blma.login.service;

import com.atarwa.blma.login.model.User;

public interface UserService {
	User findUserById(int id);
    User findUserByUserName(String userName);
}
