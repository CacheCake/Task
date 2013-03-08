package dao.interfaces;

public interface UserDAO {

	// 关闭数据库连接
	public void closeDBC3() throws Exception;

	public void closeDBC2() throws Exception;

	// 验证用户登陆信息
	public Boolean doSelectForSignIn(int string, String uPwd) throws Exception;

}
