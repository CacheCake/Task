package dao.interfaces;

import java.util.List;

import com.sun.org.apache.xpath.internal.operations.Bool;

import model.Task;

public interface TaskDAO {

	// 查询任务列表
	public List<Task> doSelectById(int tId, int uId) throws Exception;
	
	//完成任我游
	public Boolean doUpdateStatusToDone(int tId) throws Exception;
	
	//归档
	public Boolean doUpdateStatusToCollect(int tId) throws Exception;
}
