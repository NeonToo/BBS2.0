package bbs.dao.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import bbs.dao.IBaseDao;
import bbs.util.Common;
import bbs.util.DBConfig;

public abstract class BaseDaoImpl<T> implements IBaseDao<T> {
	private static DBConfig dbConfig = null;

	static {
		dbConfig = new DBConfig();
		try {
			Class.forName(dbConfig.getDriver());
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * 用于add 返回新加入ID值
	 *
	 * @param sql
	 * @return 新加入ID值
	 * @throws SQLException
	 */
	public int add(String sql, Object... paramters) {
		int returnValue = 0;
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;

		try {
			conn = DriverManager.getConnection(dbConfig.getUrl(),
					dbConfig.getUser(), dbConfig.getPassword());
			ps = conn.prepareStatement(sql,
					Statement.RETURN_GENERATED_KEYS);
			for (int i = 0; i < paramters.length; i++) {
				ps.setObject(i + 1, paramters[i]);
			}
			ps.executeUpdate();
			rs = ps.getGeneratedKeys();
			if (rs.next()) {
				returnValue = rs.getInt(1);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			Common.free(conn, ps, rs);
		}
		return returnValue;
	}

	/**
	 * 通用更新操作
	 * 
	 * @param sql
	 *            语句
	 * @param paramters
	 *            动态参数
	 * @return
	 */
	public int update(String sql, Object... parameters) {
		int returnValue = 0;
		Connection conn = null;
		PreparedStatement ps = null;

		try {
			conn = DriverManager.getConnection(dbConfig.getUrl(),
					dbConfig.getUser(), dbConfig.getPassword());
			ps = conn.prepareStatement(sql);
			for (int i = 0; i < parameters.length; i++) {
				ps.setObject(i + 1, parameters[i]);
			}
			returnValue = ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			Common.free(conn, ps, null);
		}
		return returnValue;
	}

	/**
	 * 通用查询操作
	 * 
	 * @param sql
	 *            语句
	 * @param paramters
	 *            动态参数
	 * @return
	 */
	public T find(String sql, Object... parameters) {
		List<T> list = new ArrayList<T>();
		Connection conn = null;
		PreparedStatement ps = null;

		try {
			conn = DriverManager.getConnection(dbConfig.getUrl(),
					dbConfig.getUser(), dbConfig.getPassword());
			ps = conn.prepareStatement(sql);
			for (int i = 0; i < parameters.length; i++) {
				ps.setObject(i + 1, parameters[i]);
			}
			ResultSet rs = ps.executeQuery();
			list = resultSetToList(rs);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			Common.free(conn, ps, null);
		}
		return list.size() == 0 ? null : list.get(0);
	}

	public List<T> findList(String sql) {
		List<T> list = new ArrayList<T>();
		Connection conn = null;
		PreparedStatement ps = null;

		try {
			conn = DriverManager.getConnection(dbConfig.getUrl(),
					dbConfig.getUser(), dbConfig.getPassword());
			ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			list = resultSetToList(rs);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			Common.free(conn, ps, null);
		}
		return list;
	}

	public abstract List<T> resultSetToList(ResultSet rs) throws SQLException;
}
