package dao.interfaces;

public interface UserDAO {

	// �ر����ݿ�����
	public void closeDBC3() throws Exception;

	public void closeDBC2() throws Exception;

	// ��֤�û���½��Ϣ
	public Boolean doSelectForSignIn(int string, String uPwd) throws Exception;

}
