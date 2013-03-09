package dao.interfaces;

import java.util.List;

import model.User;

public interface UserDAO {

	// 关闭数据库连接
	public void closeDBC3() throws Exception;

	public void closeDBC2() throws Exception;

	// 验证用户登陆信息
	public Boolean doSelectForSignIn(int uId, String uPwd, int uRole) throws Exception;
	
	// 查询用户,uId=0是查询全部
	public List<User> doSelectById(int uId) throws Exception;

}
