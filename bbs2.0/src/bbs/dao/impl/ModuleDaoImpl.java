package bbs.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import bbs.dao.IModuleDao;
import bbs.entity.Module;
import bbs.entity.User;

public class ModuleDaoImpl extends BaseDaoImpl<Module> implements IModuleDao {

	@Override
	public int add(Module module) {
		// TODO Auto-generated method stub
		String sql = "INSERT INTO bbs_module(name,description) VALUES (?, ?)";
		return add(sql, module.getModule_name(), module.getDescription());
	}

	@Override
	public int update(Module module) {
		// TODO Auto-generated method stub
		String sql = "UPDATE bbs_module SET name = ?, description = ? WHERE id = ?";
		return update(sql, module.getModule_name(), module.getDescription(), module.getId());
	}

	@Override
	public List<Module> findList() {
		// TODO Auto-generated method stub
		String sql = "SELECT * FROM bbs_module";
		return findList(sql);
	}

	@Override
	public Module find(int module_id) {
		// TODO Auto-generated method stub
		String sql = "SELECT * FROM bbs_module WHERE id = ?";
		return find(sql, module_id);
	}

	@Override
	public List<Module> resultSetToList(ResultSet rs) throws SQLException {
		// TODO Auto-generated method stub
		List<Module> modules = new ArrayList<Module>();
		while (rs.next()) {
			Module module = new Module();
			int module_id = rs.getInt("id");
			String module_name = rs.getString("name");
			String description = rs.getString("description");

			module.setId(module_id);
			module.setModule_name(module_name);
			module.setDescription(description);
			
			modules.add(module);
		}
		return modules;
	}

	@Override
	public Module getModuleByName(String module_name) {
		// TODO Auto-generated method stub
		String sql = "SELECT * FROM bbs_module WHERE name = ?";
		return find(sql, module_name);
	}

	@Override
	public List<Module> search(String module_name) {
		// TODO Auto-generated method stub
		String sql = "SELECT * FROM bbs_module WHERE name LIKE '%" + module_name + "%'";
		return super.findList(sql);
	}

	@Override
	public int delete(int module_id) {
		// TODO Auto-generated method stub
		String sql = "DELETE FROM bbs_module WHERE id = ?";
		return super.update(sql, module_id);
	}
}
