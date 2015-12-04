package bbs.util;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class DBConfig {
	private String driver;
	private String url;
	private String user;
	private String password;

	public DBConfig() {
		super();
		InputStream in = null;
		try {
			//in = new FileInputStream("c:\\jdbc.properties");
			in = this.getClass().getClassLoader().getResourceAsStream("/jdbc.properties");
			Properties p = new Properties();
			p.load(in);
			this.driver = p.getProperty("jdbc.driver");
			this.url = p.getProperty("jdbc.url");
			this.user = p.getProperty("jdbc.user");
			this.password = p.getProperty("jdbc.password");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if (in != null) {
				try {
					in.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}

	public String getDriver() {
		return driver;
	}

	public String getUrl() {
		return url;
	}

	public String getUser() {
		return user;
	}

	public String getPassword() {
		return password;
	}

}
