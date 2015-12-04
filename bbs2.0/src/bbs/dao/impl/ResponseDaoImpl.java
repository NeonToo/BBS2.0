package bbs.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import bbs.dao.IResponseDao;
import bbs.dao.IThemeDao;
import bbs.dao.IUserDao;
import bbs.entity.Response;
import bbs.entity.Theme;
import bbs.entity.User;
import bbs.entity.Visit;

public class ResponseDaoImpl extends BaseDaoImpl<Response> implements
		IResponseDao {
	private IUserDao userDao = new UserDaoImpl();
	private IThemeDao themeDao = new ThemeDaoImpl();

	@Override
	public int add(Response response) {
		// TODO Auto-generated method stub
		String sql = "INSERT INTO bbs_response(theme_id, user_id, content, create_time)"
				+ " VALUES(?, ?, ?, ?)";
		return add(sql, response.getTheme().getId(), response.getUser()
				.getUser_id(), response.getContent(), response.getCreate_time());
	}

	@Override
	public int update(Response t) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Response find(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int delete(int id) {
		// TODO Auto-generated method stub
		String sql = "DELETE FROM bbs_response WHERE id = ?";
		return super.update(sql, id);
	}

	@Override
	public List<Response> findList() {
		// TODO Auto-generated method stub
		String sql = "SELECT * FROM bbs_response";
		return findList(sql);
	}

	@Override
	public List<Response> resultSetToList(ResultSet rs) throws SQLException {
		// TODO Auto-generated method stub
		List<Response> responses = new ArrayList<Response>();
		while (rs.next()) {
			Response reply = new Response();
			int id = rs.getInt("id");
			int theme_id = rs.getInt("theme_id");
			String user_id = rs.getString("user_id");
			String content = rs.getString("content");
			Date create_time = rs.getTimestamp("create_time");

			Theme theme = themeDao.find(theme_id);
			User user = userDao.find(user_id);

			reply.setId(id);
			reply.setTheme(theme);
			reply.setUser(user);
			reply.setContent(content);
			reply.setCreate_time(create_time);

			responses.add(reply);
		}
		return responses;
	}

	@Override
	public List<Response> getReply(int theme_id) {
		// TODO Auto-generated method stub
		String sql = "SELECT * FROM bbs_response WHERE theme_id = " + theme_id;
		return findList(sql);
	}

	@Override
	public Response findLastReply(int theme_id) {
		// TODO Auto-generated method stub
		String sql = "SELECT * FROM bbs_response WHERE theme_id = " + theme_id + " ORDER BY create_time DESC";
		return findList(sql).get(0);
	}
}
