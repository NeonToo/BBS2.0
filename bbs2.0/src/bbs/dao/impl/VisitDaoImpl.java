package bbs.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import bbs.dao.IThemeDao;
import bbs.dao.IUserDao;
import bbs.dao.IVisitDao;
import bbs.entity.Theme;
import bbs.entity.User;
import bbs.entity.Visit;

public class VisitDaoImpl extends BaseDaoImpl<Visit> implements IVisitDao {
	private IUserDao userDao = new UserDaoImpl();
	private IThemeDao themeDao = new ThemeDaoImpl();
	
	@Override
	public int add(Visit visit) {
		// TODO Auto-generated method stub
		String sql = "INSERT INTO visit_log(user_id, theme_id, start_time) VALUES(?, ?, ?)";
		return add(sql, visit.getUser().getUser_id(), visit.getTheme().getId(), visit.getStart_time());
	}

	@Override
	public int update(Visit visit) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int delete(int id) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<Visit> findList() {
		// TODO Auto-generated method stub
		String sql = "SELECT * FROM visit_log";
		return findList(sql);
	}

	@Override
	public List<Visit> resultSetToList(ResultSet rs) throws SQLException {
		// TODO Auto-generated method stub
		List<Visit> visits = new ArrayList<Visit>();
		while (rs.next()) {
			Visit visit = new Visit();
			int id = rs.getInt("id");
			String user_id = rs.getString("user_id");
			int theme_id = rs.getInt("theme_id");
			Date start_time = rs.getTimestamp("start_time");

			User user = userDao.find(user_id);
			Theme theme = themeDao.find(theme_id);
			
			visit.setId(id);
			visit.setUser(user);
			visit.setTheme(theme);
			visit.setStart_time(start_time);
			
			visits.add(visit);
		}
		return visits;
	}

	@Override
	public List<Visit> getVisit(int theme_id) {
		// TODO Auto-generated method stub
		String sql = "SELECT * FROM visit_log WHERE theme_id = " + theme_id;
		return findList(sql);
	}
}
