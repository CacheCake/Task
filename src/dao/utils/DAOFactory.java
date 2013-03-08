package dao.utils;

import dao.impl.UserImpl;
import dao.interfaces.UserDAO;

public class DAOFactory {

	public static UserDAO getUserDAOInstance() throws Exception {
		return new UserImpl();
	}

}
