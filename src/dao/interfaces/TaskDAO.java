package dao.interfaces;

import java.util.List;

import model.Task;

public interface TaskDAO {

	// 查询任务列表
	public List<Task> doSelectById(int tId, int uId) throws Exception;

	// 完成任我游
	public Boolean doUpdateStatusToDone(int tId) throws Exception;

	// 归档
	public Boolean doUpdateStatusToCollect(int tId) throws Exception;

	// 新建
	public Boolean doInsertTask(Task task) throws Exception;

	// 修改
	public Boolean doUpdateTask(Task task) throws Exception;
}
