package bbs.dao;

import java.util.List;

import bbs.entity.Module;

public interface IModuleDao extends IBaseDao<Module>{
	public Module find(int module_id);
	
	public Module getModuleByName(String module_name);
	
	public List<Module> search(String module_name);
	
	public int delete(int module_id);
}
