package bbs.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import bbs.dao.IModuleDao;
import bbs.dao.IThemeDao;
import bbs.dao.IUserDao;
import bbs.entity.Module;
import bbs.entity.Theme;
import bbs.entity.User;

public class ThemeDaoImpl extends BaseDaoImpl<Theme> implements IThemeDao {
	private IUserDao userDao = new UserDaoImpl();
	private IModuleDao moduleDao = new ModuleDaoImpl();

	@Override
	public int add(Theme theme) {
		// TODO Auto-generated method stub
		String sql = "INSERT INTO bbs_theme(theme,user_id,module_id,is_up,is_hot,is_lock,create_time) "
				+ "VALUES (?, ?, ?, ?, ?, ?, ?)";
		return add(sql, theme.getTheme(), theme.getUser().getUser_id(), theme
				.getModule().getId(), theme.getIs_up(), theme.getHot(),
				theme.getIs_lock(), theme.getCreate_time());
	}

	@Override
	public int update(Theme theme) {
		// TODO Auto-generated method stub
		String sql = "UPDATE bbs_theme SET theme = ?, user_id = ?, module_id = ?, "
				+ "is_up = ?, is_hot = ?, is_lock = ? WHERE id = ?";
		return update(sql, theme.getTheme(), theme.getUser().getUser_id(), theme.getModule().getId(), 
				theme.getIs_up(), theme.getHot(), theme.getIs_lock(), theme.getId());
	}
	
	@Override
	public List<Theme> findList() {
		// TODO Auto-generated method stub
		String sql = "SELECT * FROM bbs_theme ORDER BY is_up DESC,create_time DESC";
		return findList(sql);
	}

	@Override
	public Theme find(int theme_id) {
		// TODO Auto-generated method stub
		String sql = "SELECT * FROM bbs_theme WHERE id = ?";
		return find(sql, theme_id);
	}

	@Override
	public Theme getThemeByName(String theme) {
		// TODO Auto-generated method stub
		String sql = "SELECT * FROM bbs_theme WHERE theme = ?";
		return find(sql, theme);
	}

	@Override
	public List<Theme> search(String sql) {
		// TODO Auto-generated method stub
		return findList(sql);
	}

	@Override
	public List<Theme> searchTheme(String theme_name) {
		// TODO Auto-generated method stub
		String sql = "SELECT * FROM bbs_theme WHERE theme LIKE '%" + theme_name + "%' ORDER BY create_time DESC";
		return findList(sql);
	}
	
	@Override
	public int delete(int theme_id) {
		// TODO Auto-generated method stub
		String sql = "DELETE FROM bbs_theme WHERE id = ?";
		return super.update(sql, theme_id);
	}

	@Override
	public List<Theme> resultSetToList(ResultSet rs) throws SQLException {
		// TODO Auto-generated method stub
		List<Theme> themes = new ArrayList<Theme>();
		while (rs.next()) {
			Theme theme = new Theme();
			int theme_id = rs.getInt("id");
			String theme_name = rs.getString("theme");
			String user_id = rs.getString("user_id");
			int module_id = rs.getInt("module_id");
			int is_up = rs.getInt("is_up");
			int is_hot = rs.getInt("is_hot");
			int is_lock = rs.getInt("is_lock");
			Date create_time = rs.getTimestamp("create_time");

			User user = userDao.find(user_id);
			Module module = moduleDao.find(module_id);
			
			theme.setId(theme_id);
			theme.setTheme(theme_name);
			theme.setUser(user);
			theme.setModule(module);
			theme.setIs_up(is_up);
			theme.setHot(is_hot);
			theme.setIs_lock(is_lock);
			theme.setCreate_time(create_time);
			
			themes.add(theme);
		}
		return themes;
	}

	@Override
	public List<Theme> findHotList() {
		// TODO Auto-generated method stub
		String sql = "SELECT * FROM bbs_theme WHERE is_hot = 1 ORDER BY is_up DESC,create_time DESC";
		return findList(sql);
	}

	@Override
	public List<Theme> getModuleTheme(int module_id) {
		// TODO Auto-generated method stub
		String sql = "SELECT * FROM bbs_theme WHERE module_id = " + module_id + " ORDER BY is_up DESC,create_time DESC";
		return findList(sql);
	}
}
