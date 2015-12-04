package bbs.dao;

import java.util.List;

import bbs.entity.Theme;
import bbs.entity.Visit;

public interface IThemeDao extends IBaseDao<Theme> {
	public Theme find(int theme_id);
	
	public Theme getThemeByName(String theme);
	
	public List<Theme> search(String theme);
	
	public int delete(int theme_id);
	
	public List<Theme> findHotList();

	public List<Theme> searchTheme(String theme);

	public List<Theme> getModuleTheme(int module_id);
}
