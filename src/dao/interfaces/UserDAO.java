package dao.interfaces;

public interface UserDAO {

	//验证用户登陆信息
	public Boolean doSelectForSignIn(int string, String uPwd) throws Exception;

}
