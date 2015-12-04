package bbs.dao;

import java.util.List;
import java.util.Map;

public interface IBaseDao<T> {
	// BaseDao�����Ӧ�ķ���Ϊ������������ݿ�����Ļ����������ھ��������涼Ҫʵ��
	public int add(T t);

	public int update(T t);

	public List<T> findList();
	
	public List<T> findList(String sql);
}
