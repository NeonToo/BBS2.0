package bbs.service.impl;

import java.io.IOException;
import java.sql.Timestamp;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bbs.dao.IResponseDao;
import bbs.dao.IThemeDao;
import bbs.dao.IUserDao;
import bbs.dao.IVisitDao;
import bbs.dao.impl.ResponseDaoImpl;
import bbs.dao.impl.ThemeDaoImpl;
import bbs.dao.impl.UserDaoImpl;
import bbs.dao.impl.VisitDaoImpl;
import bbs.entity.Response;
import bbs.entity.Theme;
import bbs.entity.User;
import bbs.entity.Visit;
import bbs.service.IResponseService;
import bbs.util.Constant;

public class ResponseServiceImpl implements IResponseService {
	IUserDao userDao = new UserDaoImpl();
	IThemeDao themeDao = new ThemeDaoImpl();
	IResponseDao responseDao = new ResponseDaoImpl();
	IVisitDao visitDao = new VisitDaoImpl();

	@Override
	public String add(HttpServletRequest request, HttpServletResponse response)
			throws IOException {
		// TODO Auto-generated method stub
		String result;
		int theme_id = Integer.parseInt(request.getParameter("theme_id"));
		String content = request.getParameter("content");
		java.util.Date d = new java.util.Date();
		String user_id = null;

		if (request.getSession().getAttribute(Constant.USERID_MARK) == null) {
			result = "NoUser";
		} else {
			user_id = request.getSession().getAttribute(Constant.USERID_MARK)
					.toString();
			Response reply = new Response();
			User user = userDao.find(user_id);
			Theme theme = themeDao.find(theme_id);
			
			reply.setTheme(theme);
			reply.setUser(user);
			reply.setContent(content);
			reply.setCreate_time(new Timestamp(d.getTime()));
			
			result = responseDao.add(reply) > 0 ? "ok" : "error";
		}
		return result;
	}

	@Override
	public boolean delete(HttpServletRequest request,
			HttpServletResponse response) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<Response> getAll(HttpServletRequest request,
			HttpServletResponse response) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Response findLastReply(int theme_id) {
		// TODO Auto-generated method stub
		return responseDao.findLastReply(theme_id);
	}

	@Override
	public int getReplyCount(int theme_id) {
		// TODO Auto-generated method stub
		return responseDao.getReply(theme_id).size();
	}
}
