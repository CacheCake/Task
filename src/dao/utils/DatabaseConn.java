package dao.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import java.sql.PreparedStatement;


public class DatabaseConn {
	private static final String DBDRIVER = "com.mysql.jdbc.Driver";
	private static final String DBURL = "jdbc:mysql://localhost:3306/lolit";
	private static final String DBUSER = "root";
	private static final String DBPASSWORD = "root";

	private Connection conn = null;
	private static DatabaseConn etDBConn = null;

	// 连接数据库
	public DatabaseConn() throws Exception {
		try {
			Class.forName(DBDRIVER);// 加载驱动程序
		} catch (Exception e) {
			throw e;
		}
	}

	public static DatabaseConn getGetDBConn() throws Exception {
		if (etDBConn == null) {
			etDBConn = new DatabaseConn();
		}
		return etDBConn;
	}

	public Connection getConnection() {// 取得数据库连接
		try {
			this.conn = DriverManager.getConnection(DBURL, DBUSER, DBPASSWORD);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return this.conn;
	}

	public void close(Connection conn, PreparedStatement pstmt, ResultSet rs)
			throws Exception {// 数据库关闭操作
		if (rs != null) {
			try {
				rs.close();// 关闭数据库
			} catch (Exception e) { // 抛出异常
				throw e;
			} finally {
				if (pstmt != null) {
					try {
						pstmt.close();
					} catch (Exception e) {
						throw e;
					} finally {
						if (conn != null) {
							try {
								conn.close();
							} catch (Exception e) {
								throw e;
							}
						}
					}
				}
			}
		}
	}

	public void close(Connection conn, PreparedStatement pstmt)
			throws Exception {// 数据库关闭操作

		if (pstmt != null) {
			try {
				pstmt.close();
			} catch (Exception e) {
				throw e;
			} finally {
				if (conn != null) {
					try {
						conn.close();
					} catch (Exception e) {
						throw e;
					}
				}
			}
		}
	}

}
