package dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import model.User;

import dao.interfaces.UserDAO;
import dao.utils.DatabaseConn;

public class UserImpl implements UserDAO {

	private Connection conn = null; // 定义数据库连接对象
	private PreparedStatement pstmt = null; // 定义数据库操作对象
	private DatabaseConn dbc = null;// 定义数据库连接
	private ResultSet rs = null;

	public UserImpl() throws Exception { // 设置数据库连接

		this.dbc = new DatabaseConn();// 实例化数据库连接
		this.conn = dbc.getConnection();// 获取数据库连接

	}

	public void closeDBC3() throws Exception {
		try {
			dbc.close(conn, pstmt, rs);
		} catch (Exception e) {
			throw e;
		}
	}

	public void closeDBC2() throws Exception {
		try {
			dbc.close(conn, pstmt);
		} catch (Exception e) {
			throw e;
		}
	}

	@Override
	public Boolean doSelectForSignIn(int uId, String uPwd, int uRole)
			throws Exception {

		// 验证密码
		String sqlPwd = "SELECT uPwd FROM user WHERE uId = '" + uId + "'";
		// 验证权限
		String sqlRole = "SELECT * FROM user WHERE uRole = '" + uRole
				+ "' OR uRole = 0";

		try {
			pstmt = conn.prepareStatement(sqlPwd);
			rs = pstmt.executeQuery();

			if (rs.next()) {
				if (rs.getString("uPwd").equals(uPwd)) {
					pstmt = conn.prepareStatement(sqlRole);
					rs = pstmt.executeQuery();
					if (rs.next()) {
						return true;
					}
				}
			}
		} catch (Exception e) {
			throw e;
		}

		return false;
	}

	@Override
	public List<User> doSelectById(int uId) throws Exception {

		String sql = null;
		if (uId == 0) {
			sql = "SELECT * FROM user WHERE uRole <> 0";
		} else {
			sql = "SELECT * FROM user WHERE uId = '" + uId + "'";
		}

		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();

			ArrayList<User> uList = new ArrayList<User>();

			while (rs.next()) {
				User user = new User();
				user.setuId(rs.getInt("uId"));
				user.setuName(rs.getString("uName"));
				user.setuGender(rs.getString("uGender"));
				switch (rs.getInt("uRole")) {
				case 0:
					user.setuRole("Root");
					break;
				case 1:
					user.setuRole("Admin");
					break;
				case 2:
					user.setuRole("主管");
					break;
				case 3:
					user.setuRole("员工");
					break;
				default:
					break;
				}
				user.setuPosition(rs.getString("uPosition"));
				user.setuExprience(rs.getString("uExprience"));
				user.setuProfessional(rs.getString("uProfessional"));
				user.setuBirthday(rs.getString("uBirthday"));
				user.setuMgr(rs.getString("uMgr"));
				user.setuEducation(rs.getString("uEducation"));
				uList.add(user);
			}

			return uList;

		} catch (Exception e) {
			throw e;
		}

	}

	@Override
	public boolean doInsertMember(User user) throws Exception {
		int uRole = 0;
		if (user.getuRole().equals("管理员")) {
			uRole = 1;
		} else if (user.getuRole().equals("主管")) {
			uRole = 2;
		} else if (user.getuRole().equals("员工")) {
			uRole = 3;
		}
		String sql = "INSERT INTO user (uName,uPwd,uRole,uGender,uPosition,uProfessional,uExprience,uMgr,uEducation) values ('"
				+ user.getuName()
				+ "','"
				+ user.getuPwd()
				+ "','"
				+ uRole
				+ "','"
				+ user.getuGender()
				+ "','"
				+ user.getuPosition()
				+ "','"
				+ user.getuProfessional()
				+ "','"
				+ user.getuExprience()
				+ "','"
				+ user.getuMgr()
				+ "','"
				+ user.getuEducation() + "')";

		try {
			pstmt = conn.prepareStatement(sql);
			int inta = pstmt.executeUpdate();

			if (inta > 0) {
				return true;
			}
		} catch (Exception e) {
			throw e;
		}

		return false;
	}

	@Override
	public List<String> doSelectAllMgr(int uId) throws Exception {

		String sql = "SELECT DISTINCT uMgr FROM user WHERE uMgr NOT IN (SELECT uMgr FROM user WHERE uId = '"
				+ uId + "')";

		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();

			ArrayList<String> mgrList = new ArrayList<String>();
			while (rs.next()) {
				mgrList.add(rs.getString("uMgr"));
			}

			return mgrList;
		} catch (Exception e) {
			throw e;
		}
	}

	@Override
	public Boolean doUpdateMember(User user) throws Exception {

		String sql = "UPDATE user SET uMgr = '" + user.getuMgr() + "', uEducation = '"
				+ user.getuEducation() + "' WHERE uId = '"+user.getuId()+"'";
		
		try {
			pstmt = conn.prepareStatement(sql);
			int inta = pstmt.executeUpdate();

			if (inta > 0) {
				return true;
			}
		} catch (Exception e) {
			throw e;
		}

		return false;
	}

}
