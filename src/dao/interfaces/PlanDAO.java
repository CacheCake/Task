package dao.interfaces;

import java.util.ArrayList;

import model.Plan;

public interface PlanDAO {

	// 关闭数据库连接
	public void closeDBC3() throws Exception;

	public void closeDBC2() throws Exception;

	public ArrayList<Plan> doSelectBytId(int tId, int uId) throws Exception;

	// 新建
	public Boolean doInsertTask(Plan plan) throws Exception;
}
