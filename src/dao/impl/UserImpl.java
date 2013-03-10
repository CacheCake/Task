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

	private Connection conn = null; // �������ݿ����Ӷ���
	private PreparedStatement pstmt = null; // �������ݿ��������
	private DatabaseConn dbc = null;// �������ݿ�����
	private ResultSet rs = null;

	public UserImpl() throws Exception { // �������ݿ�����

		this.dbc = new DatabaseConn();// ʵ�������ݿ�����
		this.conn = dbc.getConnection();// ��ȡ���ݿ�����

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

		// ��֤����
		String sqlPwd = "SELECT uPwd FROM user WHERE uId = '" + uId + "'";
		// ��֤Ȩ��
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
					user.setuRole("����");
					break;
				case 3:
					user.setuRole("Ա��");
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
		if (user.getuRole().equals("����Ա")) {
			uRole = 1;
		} else if (user.getuRole().equals("����")) {
			uRole = 2;
		} else if (user.getuRole().equals("Ա��")) {
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
