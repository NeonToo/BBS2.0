package bbs.service;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bbs.entity.Module;
import bbs.entity.Theme;

public interface IModuleService {
	public boolean add(HttpServletRequest request, HttpServletResponse response)
			throws IOException;

	public boolean update(HttpServletRequest request,
			HttpServletResponse response);

	public boolean delete(HttpServletRequest request,
			HttpServletResponse response);

	public Module find(HttpServletRequest request, HttpServletResponse response);
	
	public List<Module> search(HttpServletRequest request, HttpServletResponse response);
	
	public List<Module> getAll(HttpServletRequest request, HttpServletResponse response);

	public List<Theme> getModuleTheme(int module_id);
}
