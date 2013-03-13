package dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import model.Plan;
import model.Task;
import dao.interfaces.PlanDAO;
import dao.utils.DatabaseConn;

public class PlanImpl implements PlanDAO {

	private Connection conn = null; // �������ݿ����Ӷ���
	private PreparedStatement pstmt = null; // �������ݿ��������
	private DatabaseConn dbc = null;// �������ݿ�����
	private ResultSet rs = null;

	public PlanImpl() throws Exception { // �������ݿ�����

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
	public ArrayList<Plan> doSelectBytId(int tId, int uId) throws Exception {
		String sql = null;
		if (tId == 0) {
			sql = "SELECT * FROM plan WHERE user_uId = '" + uId + "'";
		} else if (uId == 0) {
			sql = "SELECT * FROM plan";
		} else {
			sql = "SELECT * FROM plan WHERE task_tId = '" + tId + "'";
		}

		System.out.println(sql);
		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();

			ArrayList<Plan> pList = new ArrayList<Plan>();

			while (rs.next()) {
				Plan plan = new Plan();
				plan.setpId(rs.getInt("pId"));
				plan.setpName(rs.getString("pName"));
				plan.setpDescription(rs.getString("pDescription"));
				plan.setpBeginDate(rs.getString("pBeginDate"));
				plan.setpEndDate(rs.getString("pEndDate"));
				plan.setpStatus(rs.getString("pStatus"));
				plan.setpFeedback(rs.getInt("pFeedback"));
				plan.setpFeedbackMsg(rs.getString("pFeedbackMsg"));
				plan.setUser_uId(rs.getInt("User_uId"));
				plan.setTask_tId(rs.getInt("Task_tId"));
				pList.add(plan);
			}

			return pList;

		} catch (Exception e) {
			throw e;
		}

	}

	@Override
	public Boolean doInsertTask(Plan plan) throws Exception {
		String sql = "INSERT INTO plan (pName,pDescription,pBeginDate,pEndDate,pStatus,user_uId,task_tId) values ('"
				+ plan.getpName()
				+ "','"
				+ plan.getpDescription()
				+ "','"
				+ plan.getpBeginDate()
				+ "','"
				+ plan.getpEndDate()
				+ "','δʵʩ','"
				+ plan.getUser_uId()
				+ "','"
				+ plan.getTask_tId() + "')";

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
