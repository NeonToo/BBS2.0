package bbs.dao;

import bbs.entity.User;


public interface IUserDao extends IBaseDao<User>{
	public User find(String user_id);
	
	public User checkLogin(String user_id, String password);
}
