package bbs.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.dao.DataAccessException;

import bbs.dao.IUserDao;
import bbs.entity.User;

public class UserDaoImpl extends BaseDaoImpl<User> implements IUserDao{

	@Override
	public int add(User user) {     //
		// TODO Auto-generated method stub
		String sql = "INSERT INTO bbs_user VALUES(?, ?, ?, ?)";
		return add(sql,user.getUser_id(), user.getUser_name(),
				user.getPassword(), user.getEmail());
	}

	@Override
	public int update(User user) {
		// TODO Auto-generated method stub
		String sql = "UPDATE bbs_user SET user_name = ?, password = ?, email = ? WHERE id = ?";
		return update(sql, user.getUser_name(), user.getPassword(), user.getEmail());
	}
	@Override
	public User find(String id) {
		// TODO Auto-generated method stub
		String sql = "SELECT * FROM bbs_user WHERE id = ?";
		return find(sql, id);
	}

	@Override
	public List<User> findList() {
		// TODO Auto-generated method stub
		String sql = "SELECT * FROM bbs_user";
		return findList(sql);
	}

	@Override
	public User checkLogin(String user_id, String password) {
		// TODO Auto-generated method stub
		String sql = "SELECT * FROM bbs_user WHERE id = ? AND password = ?";
		return find(sql, user_id, password);
	}

	@Override
	public List<User> resultSetToList(ResultSet rs) throws SQLException {
		// TODO Auto-generated method stub
		List<User> users = new ArrayList<User>();
		while (rs.next()) {
			User user = new User();
			String user_id = rs.getString("id");
			String user_name = rs.getString("user_name");
			String password = rs.getString("password");
			String email = rs.getString("email");

			user.setUser_id(user_id);
			user.setUser_name(user_name);
			user.setPassword(password);
			user.setEmail(email);
			
			users.add(user);
		}
		return users;
	}

}
