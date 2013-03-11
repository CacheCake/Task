package dao.utils;

import dao.impl.TaskImpl;
import dao.impl.UserImpl;
import dao.interfaces.TaskDAO;
import dao.interfaces.UserDAO;

public class DAOFactory {

	public static UserDAO getUserDAOInstance() throws Exception {
		return new UserImpl();
	}

	public static TaskDAO getTaskDAOInstance() throws Exception {
		return new TaskImpl();
	}
}
