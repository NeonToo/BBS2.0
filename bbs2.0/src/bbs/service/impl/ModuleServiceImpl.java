package bbs.service.impl;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bbs.dao.IModuleDao;
import bbs.dao.IThemeDao;
import bbs.dao.impl.ModuleDaoImpl;
import bbs.dao.impl.ThemeDaoImpl;
import bbs.entity.Module;
import bbs.entity.Theme;
import bbs.service.IModuleService;

public class ModuleServiceImpl implements IModuleService {
	IModuleDao moduleDao = new ModuleDaoImpl();
	IThemeDao themeDao = new ThemeDaoImpl();
	
	@Override
	public boolean add(HttpServletRequest request, HttpServletResponse response)
			throws IOException {
		// TODO Auto-generated method stub
		boolean result;
		String module_name = request.getParameter("module_name");
		String description = request.getParameter("description");
		Module m = moduleDao.getModuleByName(module_name);
		
		if(m != null){
			result = false;
		} else {
			Module module = new Module();
			module.setModule_name(module_name);
			module.setDescription(description);
			
			result = moduleDao.add(module) > 0 ? true : false;
		}
		return result;
	}

	@Override
	public boolean update(HttpServletRequest request,
			HttpServletResponse response) {
		// TODO Auto-generated method stub
		boolean result;
		String name = request.getParameter("name");
		String description = request.getParameter("description");
		Module module = moduleDao.getModuleByName(name);
		
		module.setModule_name(name);
		module.setDescription(description);
		
		result = moduleDao.update(module) > 0 ? true : false;
		return result;
	}

	@Override
	public boolean delete(HttpServletRequest request,
			HttpServletResponse response) {
		// TODO Auto-generated method stub
		boolean result;
		int id = Integer.parseInt(request.getParameter("id"));
		
		result = moduleDao.delete(id) > 0 ? true : false;
		return result;
	}

	@Override
	public Module find(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		String module_name = request.getParameter("name");
		return moduleDao.getModuleByName(module_name);
	}

	@Override
	public List<Module> getAll(HttpServletRequest request,
			HttpServletResponse response) {
		// TODO Auto-generated method stub
		return moduleDao.findList();
	}

	@Override
	public List<Module> search(HttpServletRequest request,
			HttpServletResponse response) {
		// TODO Auto-generated method stub
		String module_name = request.getParameter("module_name");
		return moduleDao.search(module_name);
	}

	@Override
	public List<Theme> getModuleTheme(int module_id) {
		// TODO Auto-generated method stub
		return themeDao.getModuleTheme(module_id);
	}
	
}
