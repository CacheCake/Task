package dao.interfaces;

import java.util.List;

import model.User;

public interface UserDAO {

	// �ر����ݿ�����
	public void closeDBC3() throws Exception;

	public void closeDBC2() throws Exception;

	// ��֤�û���½��Ϣ
	public Boolean doSelectForSignIn(int uId, String uPwd, int uRole) throws Exception;
	
	// ��ѯ�û�,uId=0�ǲ�ѯȫ��
	public List<User> doSelectById(int uId) throws Exception;

}
