package dao.interfaces;

import java.util.List;

import model.Task;

public interface TaskDAO {

	// 查询任务列表
	public List<Task> doSelectById(int tId, int uId) throws Exception;
}
