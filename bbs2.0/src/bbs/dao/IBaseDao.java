package bbs.dao;

import java.util.List;
import java.util.Map;

public interface IBaseDao<T> {
	// BaseDao里面对应的方法为各个对象对数据库操作的基本方法，在具体类里面都要实现
	public int add(T t);

	public int update(T t);

	public List<T> findList();
	
	public List<T> findList(String sql);
}
