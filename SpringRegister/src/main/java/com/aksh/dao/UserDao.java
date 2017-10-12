package com.aksh.dao;

import com.aksh.model.Login;
import com.aksh.model.User;

public interface UserDao {
	  void register(User user);

	  User validateUser(Login login);
}
