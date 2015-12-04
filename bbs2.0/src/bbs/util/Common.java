package bbs.util;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Common {
	/**
	 * 关闭
	 * 
	 * @param conn
	 * @param statement
	 * @param rs
	 */
	public static void free(Connection conn, Statement st, ResultSet rs) {
		if (rs != null) {
			try {
				rs.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		if (st != null) {
			try {
				st.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		if (conn != null) {
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	/**
	 * 将结果集封闭成hashMap列表
	 * 
	 * @param returnValue
	 * @param rs
	 * @throws SQLException
	 */
	public static void getList(List returnValue, ResultSet rs)
			throws SQLException {
		while (rs.next()) {
			ResultSetMetaData md = rs.getMetaData();
			Map map = new HashMap();
			for (int j = 0; j < md.getColumnCount(); j++) {
				map.put(md.getColumnLabel(j + 1), rs.getObject(j + 1));
			}
			returnValue.add(map);

		}
	}

	/**
	 * 返回并提示
	 * 
	 * @param msg
	 * @return
	 */
	public static String AlertBack(String msg) {
		StringBuffer sb = new StringBuffer();
		sb.append("<html> <head><meta http-equiv=\"Content-Type\" content=\"text/html; charset=utf-8\" /> </head><body>");
		sb.append("<script charset='utf-8'>alert(\""
				+ msg.replace('"', ' ').replace("\r\n", "")
				+ "\");window.history.back();</script></body></html>");
		return sb.toString();
	}

	/**
	 * 页面提示
	 * 
	 * @param msg
	 * @return
	 */
	public static String Alert(String msg) {
		StringBuffer sb = new StringBuffer();
		sb.append("<html> <head><meta http-equiv=\"Content-Type\" content=\"text/html; charset=utf-8\" /> </head><body>");
		sb.append("<script charset=\"utf-8\">alert(\""
				+ msg.replace('"', ' ').replace("\r\n", "") + "\");</script>");
		return sb.toString();
	}

	/**
	 * 提示并跳转
	 * 
	 * @param msg
	 * @param url
	 * @return
	 */
	public static String AlertTo(String msg, String url) {
		StringBuffer sb = new StringBuffer();
		sb.append("<html> <head><meta http-equiv=\"Content-Type\" content=\"text/html; charset=utf-8\" /> </head><body>");
		sb.append("<script charset=\"utf-8\">alert(\""
				+ msg.replace('"', ' ').replace("\r\n", "")
				+ "\");self.location='" + url + "';</script>");
		return sb.toString();

	}
	/**
	 * 字符串是否为空
	 * 
	 * @param string
	 * @return
	 */
	public static boolean isEmptyByString(String string) {
		boolean returnValue = true;
		if (string == null) {
			return returnValue;
		}
		String temp = string.trim();
		returnValue = temp.equals("") || (temp == null);
		return returnValue;
	}
}
