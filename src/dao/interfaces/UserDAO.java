package dao.interfaces;

import java.util.List;

import model.User;

public interface UserDAO {

	// �ر����ݿ�����
	public void closeDBC3() throws Exception;

	public void closeDBC2() throws Exception;

	// ��֤�û���½��Ϣ
	public Boolean doSelectForSignIn(int uId, String uPwd, int uRole)
			throws Exception;

	// ��ѯ�û�,uId=0�ǲ�ѯȫ��
	public List<User> doSelectById(int uId) throws Exception;

	// ������Ա
	public boolean doInsertMember(User user) throws Exception;

	// ��ѯ����������
	public List<String> doSelectAllMgr(int uId) throws Exception;

	// ��ѯ����������
	public List<String> doSelectAllStf() throws Exception;

	// �޸ĳ�Ա��Ϣ
	public Boolean doUpdateMember(User user) throws Exception;

	// ɾ����Ա
	public boolean doDeleteMember(int uId) throws Exception;
}
