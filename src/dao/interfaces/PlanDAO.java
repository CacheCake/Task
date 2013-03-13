package dao.interfaces;

import java.util.ArrayList;

import model.Plan;

public interface PlanDAO {

	// �ر����ݿ�����
	public void closeDBC3() throws Exception;

	public void closeDBC2() throws Exception;

	public ArrayList<Plan> doSelectBytId(int tId, int uId) throws Exception;

	// �½�
	public Boolean doInsertTask(Plan plan) throws Exception;
}
