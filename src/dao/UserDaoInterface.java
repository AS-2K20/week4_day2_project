package dao;

import model.User;

interface UserDaoInterface {
	int signUp(User user);
	boolean loginUser(User user);
}
