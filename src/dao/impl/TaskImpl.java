package dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import model.Task;
import dao.interfaces.TaskDAO;
import dao.utils.DatabaseConn;

public class TaskImpl implements TaskDAO {
	private Connection conn = null; // �������ݿ����Ӷ���
	private PreparedStatement pstmt = null; // �������ݿ��������
	private DatabaseConn dbc = null;// �������ݿ�����
	private ResultSet rs = null;

	public TaskImpl() throws Exception { // �������ݿ�����

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

	public List<Task> doSelectById(int tId, int uId) throws Exception {

		String sql = null;
		if (uId == 0) {
			sql = "SELECT * FROM task ORDER BY tEndDate";
		} else if (tId == 0) {
			sql = "SELECT * FROM task WHERE user_uId = '"
					+ uId
					+ "' OR user_uMgr = ANY (SELECT uName FROM user WHERE uId ='"
					+ uId + "') ORDER BY tEndDate";
		} else {
			sql = "SELECT * FROM task WHERE user_uId = '"
					+ uId
					+ "' OR user_uMgr = ANY (SELECT uName FROM user WHERE uId ='"
					+ uId + "') AND tId = '" + tId + "' ORDER BY tEndDate";
		}

		System.out.println(sql);
		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();

			ArrayList<Task> tList = new ArrayList<Task>();

			while (rs.next()) {
				Task task = new Task();
				task.settId(rs.getInt("tId"));
				task.settName(rs.getString("tName"));
				task.settDescription(rs.getString("tDescription"));
				task.settBeginDate(rs.getString("tBeginDate"));
				task.settEndDate(rs.getString("tEndDate"));
				task.settRealBeginDate(rs.getString("tRealBeginDate"));
				task.settRealEndDate(rs.getString("tRealBeginDate"));
				task.settStatus(rs.getString("tStatus"));
				task.setUser_uId(rs.getInt("User_uId"));
				task.setUser_uMgr(rs.getString("User_uMgr"));
				tList.add(task);
			}

			return tList;

		} catch (Exception e) {
			throw e;
		}

	}

	@Override
	public Boolean doUpdateStatusToDone(int tId) throws Exception {
		String sql = "UPDATE task SET tStatus = '�����' WHERE tId = '" + tId
				+ "'";

		try {
			pstmt = conn.prepareStatement(sql);
			int inta = pstmt.executeUpdate();

			if (inta > 0) {
				return true;
			}

			return false;

		} catch (Exception e) {
			throw e;
		}
	}

	@Override
	public Boolean doUpdateStatusToCollect(int tId) throws Exception {
		String sql = "UPDATE task SET tStatus = '�鵵' WHERE tId = '" + tId + "'";

		try {
			pstmt = conn.prepareStatement(sql);
			int inta = pstmt.executeUpdate();

			if (inta > 0) {
				return true;
			}

			return false;

		} catch (Exception e) {
			throw e;
		}
	}

	@Override
	public Boolean doInsertTask(Task task) throws Exception {
		String sql = "INSERT INTO task (tName,tDescription,tBeginDate,tEndDate,tStatus,user_uId,user_uMgr) values ('"
				+ task.gettName()
				+ "','"
				+ task.gettDescription()
				+ "','"
				+ task.gettBeginDate()
				+ "','"
				+ task.gettEndDate()
				+ "','δʵʩ','"
				+ task.getUser_uId()
				+ "','"
				+ task.getUser_uMgr() + "')";

		System.out.println(sql);

		try {
			pstmt = conn.prepareStatement(sql);
			int inta = pstmt.executeUpdate();

			if (inta > 0) {
				return true;
			}

			return false;

		} catch (Exception e) {
			throw e;
		}
	}

}
