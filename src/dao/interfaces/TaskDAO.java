package dao.interfaces;

import java.util.List;

import model.Task;

public interface TaskDAO {

	// ��ѯ�����б�
	public List<Task> doSelectById(int tId, int uId) throws Exception;
}
