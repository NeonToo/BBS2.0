package bbs.service.impl;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bbs.dao.IUserDao;
import bbs.dao.impl.UserDaoImpl;
import bbs.entity.User;
import bbs.service.IUserService;
import bbs.util.Common;
import bbs.util.Constant;

public class UserServiceImpl implements IUserService {
	IUserDao userDao = new UserDaoImpl();

	@Override
	public boolean add(HttpServletRequest request, HttpServletResponse response)
			throws IOException {
		// TODO Auto-generated method stub
		boolean result;
		String user_id = request.getParameter("user_id");
		String user_name = request.getParameter("user_name");
		String password = request.getParameter("password");
		String email = request.getParameter("email");
		User u = userDao.find(user_id);

		if (u != null) {
			result = false;
		} else {
			User user = new User();
			user.setUser_id(user_id);
			user.setUser_name(user_name);
			user.setPassword(password);
			user.setEmail(email);

			request.getSession().setAttribute(Constant.USERID_MARK,
					request.getParameter("user_id"));
			request.getSession().setAttribute(Constant.USER_NAME_MARK,
					request.getParameter("user_name"));
			result = userDao.add(user) > 0 ? true : false;
		}
		return result;
	}

	@Override
	public String update(HttpServletRequest request,
			HttpServletResponse response) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String delete(HttpServletRequest request,
			HttpServletResponse response) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public User find(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		String user_id = request.getParameter("user_id");
		User user = userDao.find(user_id);
		return user;
	}

	@Override
	public boolean login(HttpServletRequest request,
			HttpServletResponse response) throws IOException {
		// TODO Auto-generated method stub
		boolean result;
		String user_id = request.getParameter("user_id");
		String password = request.getParameter("password");
		User user = userDao.checkLogin(user_id, password);

		if (user != null) {
			String user_name = user.getUser_name();
			request.getSession().setAttribute(Constant.USERID_MARK, user_id);
			request.getSession().setAttribute(Constant.USER_NAME_MARK,user_name);
			result = true;
		} else {
			result = false;
		}
		return result;
	}

}
