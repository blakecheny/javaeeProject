package com.cuit.dbconnect;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

import javax.sql.DataSource;

import org.apache.commons.dbcp.BasicDataSourceFactory;

public class DBconnect {
	
	private static ThreadLocal<Connection> threadLocal = new ThreadLocal<Connection>();
	private static DataSource ds;
	
	private DBconnect(){
		
	}
	
	static{
		InputStream in = DBconnect.class.getResourceAsStream("/mysql.properties");
		Properties properties = new Properties();
			try {
				properties.load(in);
				DBconnect.ds = BasicDataSourceFactory.createDataSource(properties);
			} catch (IOException e) {
				System.out.println("配置文件装载出错");
				e.printStackTrace();
			} catch (Exception e) {
				e.printStackTrace();
			}	
	}
	public static Connection getConn() throws SQLException{
		Connection conn = threadLocal.get();
		if(conn == null || conn.isClosed()){
			conn = ds.getConnection();
			threadLocal.set(conn);
		}
		return conn;
	}
	
	 public static void closeConn(){
		 Connection conn = threadLocal.get();
		 try {
			if(conn != null || !conn.isClosed()){
				 conn.close();
			 }
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 finally {
			threadLocal.set(null);
		}
	 }
}
