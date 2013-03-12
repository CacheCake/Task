package dao.interfaces;

import java.util.List;

import com.sun.org.apache.xpath.internal.operations.Bool;

import model.Task;

public interface TaskDAO {

	// ��ѯ�����б�
	public List<Task> doSelectById(int tId, int uId) throws Exception;
	
	//���������
	public Boolean doUpdateStatusToDone(int tId) throws Exception;
	
	//�鵵
	public Boolean doUpdateStatusToCollect(int tId) throws Exception;
}
