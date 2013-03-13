package dao.interfaces;

import java.util.List;

import model.User;

public interface UserDAO {

	// 关闭数据库连接
	public void closeDBC3() throws Exception;

	public void closeDBC2() throws Exception;

	// 验证用户登陆信息
	public Boolean doSelectForSignIn(int uId, String uPwd, int uRole)
			throws Exception;

	// 查询用户,uId=0是查询全部
	public List<User> doSelectById(int uId) throws Exception;

	// 新增成员
	public boolean doInsertMember(User user) throws Exception;

	// 查询所有主管名
	public List<String> doSelectAllMgr(int uId) throws Exception;

	// 查询所有主管名
	public List<String> doSelectAllStf() throws Exception;

	// 修改成员信息
	public Boolean doUpdateMember(User user) throws Exception;

	// 删除成员
	public boolean doDeleteMember(int uId) throws Exception;
}
