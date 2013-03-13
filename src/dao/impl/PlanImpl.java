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

	private Connection conn = null; // 定义数据库连接对象
	private PreparedStatement pstmt = null; // 定义数据库操作对象
	private DatabaseConn dbc = null;// 定义数据库连接
	private ResultSet rs = null;

	public PlanImpl() throws Exception { // 设置数据库连接

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
				+ "','未实施','"
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
