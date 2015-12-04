package bbs.service.impl;

import java.io.IOException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bbs.dao.IModuleDao;
import bbs.dao.IResponseDao;
import bbs.dao.IThemeDao;
import bbs.dao.IUserDao;
import bbs.dao.IVisitDao;
import bbs.dao.impl.ModuleDaoImpl;
import bbs.dao.impl.ResponseDaoImpl;
import bbs.dao.impl.ThemeDaoImpl;
import bbs.dao.impl.UserDaoImpl;
import bbs.dao.impl.VisitDaoImpl;
import bbs.entity.Module;
import bbs.entity.Response;
import bbs.entity.Theme;
import bbs.entity.User;
import bbs.entity.Visit;
import bbs.service.IThemeService;
import bbs.util.Constant;

public class ThemeServiceImpl implements IThemeService {
	IUserDao userDao = new UserDaoImpl();
	IThemeDao themeDao = new ThemeDaoImpl();
	IModuleDao moduleDao = new ModuleDaoImpl();
	IResponseDao responseDao = new ResponseDaoImpl();
	IVisitDao visitDao = new VisitDaoImpl();
	
	@Override
	public String add(HttpServletRequest request, HttpServletResponse response)
			throws IOException {
		// TODO Auto-generated method stub
		String result;
		String theme_name = request.getParameter("theme");
		String module_name = request.getParameter("module_name");
		String content = request.getParameter("content");
		Theme t = themeDao.getThemeByName(theme_name);
		String user_id;
		
		if (request.getSession().getAttribute(Constant.USERID_MARK) == null) {
			result = "NoLogin";
		} else {
			user_id = request.getSession().getAttribute(Constant.USERID_MARK).toString();
			if(t != null){
				result = "ThemeExist";
			} else {
				if(module_name.equals("Ñ¡Ôñ·ÖÀà")){
					result = "NoModule";
				}
				else{
					Theme theme = new Theme();
					java.util.Date d = new java.util.Date();
					User user = userDao.find(user_id);
					Module module = moduleDao.getModuleByName(module_name);
					
					theme.setTheme(theme_name);
					theme.setUser(user);
					theme.setModule(module);
					theme.setIs_up(0);
					theme.setHot(0);
					theme.setIs_lock(0);
					theme.setCreate_time(new Timestamp(d.getTime()));
					int theme_id = themeDao.add(theme);
					theme = themeDao.find(theme_id);
					
					Response reply = new Response();
					reply.setUser(user);
					reply.setTheme(theme);
					reply.setContent(content);
					reply.setCreate_time(new Timestamp(d.getTime()));
					responseDao.add(reply);
					
					Visit visit = new Visit();
					visit.setTheme(theme);
					visit.setUser(user);
					visit.setStart_time(new Timestamp(d.getTime()));
					visitDao.add(visit);
					
					result =  theme_id > 0 ? "ok" : "error";
				}
			}
		}
		return result;
	}

	@Override
	public String update(HttpServletRequest request,
			HttpServletResponse response) {
		// TODO Auto-generated method stub
		int id = Integer.parseInt(request.getParameter("id"));
		String module_name = request.getParameter("module_name");
		String theme_name = request.getParameter("theme");
		String user_id = request.getParameter("user_id");
		int is_up = Integer.parseInt(request.getParameter("is_up"));
		int is_lock = Integer.parseInt(request.getParameter("is_lock"));
		int is_hot = Integer.parseInt(request.getParameter("is_hot"));
		User user = userDao.find(user_id);
		Module module = moduleDao.getModuleByName(module_name);
		Theme theme = themeDao.find(id);
		theme.setModule(module);
		theme.setUser(user);
		theme.setTheme(theme_name);
		theme.setIs_up(is_up);
		theme.setIs_lock(is_lock);
		theme.setHot(is_hot);
		
		return themeDao.update(theme) > 0 ? "ok" : "error";
	}
	
	@Override
	public String delete(HttpServletRequest request,
			HttpServletResponse response) {
		// TODO Auto-generated method stub
		String result;
		int id = Integer.parseInt(request.getParameter("id"));
		
		result = themeDao.delete(id) > 0 ? "ok" : "erro";
		return result;
	}

	@Override
	public Theme find(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		int theme_id = Integer.parseInt(request.getParameter("theme_id"));
		return themeDao.find(theme_id);
	}

	@Override
	public List<Theme> search(HttpServletRequest request,
			HttpServletResponse response) {
		// TODO Auto-generated method stub
		StringBuffer sb = new StringBuffer("SELECT * FROM bbs_theme");
		String module_name = request.getParameter("module_name");
		String user_id = request.getParameter("user_id");
		String theme_name = request.getParameter("theme");
		
		if(module_name != "" && user_id == "" && theme_name == ""){
			List<Module> modules = moduleDao.search(module_name);
			if(modules.size() > 0){
				sb.append(" WHERE module_id IN (").append(modules.get(0).getId());
				for(int i = 1;i < modules.size();i++){
					int mid = modules.get(i).getId();
					sb.append(", ").append(mid);
				}
				sb.append(")");
			}
			else{
				sb.append(" WHERE id = 0");
			}
		}
		else if(module_name == "" && user_id != "" && theme_name == ""){
			sb.append(" WHERE user_id LIKE '%").append(user_id).append("%'");
		}
		else if(module_name == "" && user_id == "" && theme_name != ""){
			sb.append(" WHERE theme LIKE '%").append(theme_name).append("%'");
		}
		else if(module_name == "" && user_id != "" && theme_name != ""){
			sb.append(" WHERE user_id LIKE '%").append(user_id).append("%' AND theme LIKE '%").append(theme_name).append("%'");
		}
		else if(module_name != "" && user_id != "" && theme_name == ""){
			List<Module> modules = moduleDao.search(module_name);
			if(modules.size() > 0){
				sb.append(" WHERE module_id IN (").append(modules.get(0).getId());
				for(int i = 1;i < modules.size();i++){
					int mid = modules.get(i).getId();
					sb.append(", ").append(mid);
				}
				sb.append(")").append(" AND user_id LIKE '%").append(user_id).append("%'");
			}
			else{
				sb.append(" WHERE id = 0");
			}
		}
		else if(module_name != "" && user_id == "" && theme_name != ""){
			List<Module> modules = moduleDao.search(module_name);
			if(modules.size() > 0){
				sb.append(" WHERE module_id IN (").append(modules.get(0).getId());
				for(int i = 1;i < modules.size();i++){
					int mid = modules.get(i).getId();
					sb.append(", ").append(mid);
				}
				sb.append(")").append(" AND theme LIKE '%").append(theme_name).append("%'");
			}
			else{
				sb.append(" WHERE id = 0");
			}
		}
		else if(module_name != "" && user_id != "" && theme_name != ""){
			List<Module> modules = moduleDao.search(module_name);
			if(modules.size() > 0){
				sb.append(" WHERE module_id IN (").append(modules.get(0).getId());
				for(int i = 1;i < modules.size();i++){
					int mid = modules.get(i).getId();
					sb.append(", ").append(mid);
				}
				sb.append(")").append(" AND user_id LIKE '%").
				append(user_id).append("%' AND theme LIKE '%").append(theme_name).append("%'");
			}
			else{
				sb.append(" WHERE id = 0");
			}
		}
		return themeDao.search(sb.toString());
	}
	
	@Override
	public List<Theme> searchTheme(HttpServletRequest request,
			HttpServletResponse response) {
		// TODO Auto-generated method stub
		String theme_name = request.getParameter("theme");
		return themeDao.searchTheme(theme_name);
	}

	@Override
	public List<Theme> getAll(HttpServletRequest request,
			HttpServletResponse response) {
		// TODO Auto-generated method stub
		return themeDao.findList();
	}

	@Override
	public Theme visit(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		int theme_id = Integer.parseInt(request.getParameter("theme_id"));
		String user_id;
		java.util.Date d = new java.util.Date();

		if (request.getSession().getAttribute(Constant.USERID_MARK) == null) {
			user_id = "";
		} else {
			user_id = request.getSession().getAttribute(Constant.USERID_MARK).toString();
		}
		
		Theme theme = themeDao.find(theme_id);
		User user = userDao.find(user_id);
		Visit visit = new Visit();
		
		visit.setTheme(theme);
		visit.setUser(user);
		visit.setStart_time(new Timestamp(d.getTime()));
		visitDao.add(visit);
		
		return theme;
	}

	@Override
	public List<Theme> getHot(HttpServletRequest request,
			HttpServletResponse response) {
		// TODO Auto-generated method stub
		return themeDao.findHotList();
	}

	@Override
	public int getVisit(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		int theme_id = Integer.parseInt(request.getParameter("theme_id"));
		return visitDao.getVisit(theme_id).size();
	}

	@Override
	public List<Response> getReply(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		int theme_id = Integer.parseInt(request.getParameter("theme_id"));
		return responseDao.getReply(theme_id);
	}

	@Override
	public String top(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		int id = Integer.parseInt(request.getParameter("id"));
		Theme theme = themeDao.find(id);
		theme.setIs_up(1);
		
		return themeDao.update(theme) > 0 ? "ok" : "error";
	}

	@Override
	public String cancelTop(HttpServletRequest request,
			HttpServletResponse response) {
		// TODO Auto-generated method stub
		int id = Integer.parseInt(request.getParameter("id"));
		Theme theme = themeDao.find(id);
		theme.setIs_up(0);
		
		return themeDao.update(theme) > 0 ? "ok" : "error";
	}

	@Override
	public String lock(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		int id = Integer.parseInt(request.getParameter("id"));
		Theme theme = themeDao.find(id);
		theme.setIs_lock(1);
		
		return themeDao.update(theme) > 0 ? "ok" : "error";
	}

	@Override
	public String cancelLock(HttpServletRequest request,
			HttpServletResponse response) {
		// TODO Auto-generated method stub
		int id = Integer.parseInt(request.getParameter("id"));
		Theme theme = themeDao.find(id);
		theme.setIs_lock(0);
		
		return themeDao.update(theme) > 0 ? "ok" : "error";
	}

	@Override
	public String hot(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		int id = Integer.parseInt(request.getParameter("id"));
		Theme theme = themeDao.find(id);
		theme.setHot(1);
		
		return themeDao.update(theme) > 0 ? "ok" : "error";
	}

	@Override
	public String cancelHot(HttpServletRequest request,
			HttpServletResponse response) {
		// TODO Auto-generated method stub
		int id = Integer.parseInt(request.getParameter("id"));
		Theme theme = themeDao.find(id);
		theme.setHot(0);
		
		return themeDao.update(theme) > 0 ? "ok" : "error";
	}
}
