package bbs.service;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bbs.entity.Response;
import bbs.entity.Theme;


public interface IThemeService {
	public String add(HttpServletRequest request, HttpServletResponse response)
			throws IOException;
	
	public String update(HttpServletRequest request,
			HttpServletResponse response);
	
	public String delete(HttpServletRequest request,
			HttpServletResponse response);

	public Theme find(HttpServletRequest request, HttpServletResponse response);
	
	public Theme visit(HttpServletRequest request, HttpServletResponse response);
	
	public List<Theme> search(HttpServletRequest request, HttpServletResponse response);
	
	public List<Theme> getAll(HttpServletRequest request, HttpServletResponse response);
	
	public List<Theme> getHot(HttpServletRequest request, HttpServletResponse response);

	public int getVisit(HttpServletRequest request, HttpServletResponse response);

	public List<Response> getReply(HttpServletRequest request, HttpServletResponse response);

	public String top(HttpServletRequest request, HttpServletResponse response);

	public String cancelTop(HttpServletRequest request,
			HttpServletResponse response);

	public String lock(HttpServletRequest request, HttpServletResponse response);

	public String cancelLock(HttpServletRequest request,
			HttpServletResponse response);

	public String hot(HttpServletRequest request, HttpServletResponse response);

	public String cancelHot(HttpServletRequest request,
			HttpServletResponse response);

	public List<Theme> searchTheme(HttpServletRequest request,
			HttpServletResponse response);
}
