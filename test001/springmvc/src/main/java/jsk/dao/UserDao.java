package jsk.dao;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import jsk.vo.User;

public class UserDao extends BaseDao {

	public List<User> getUsers() {
		List<User> list = new ArrayList<User>();
		StringBuffer sqlBuffer = new StringBuffer();
		sqlBuffer.append("Select * from user where 1=1");
		ResultSet rs = null;
		try {
			rs = this.executeQuery(sqlBuffer.toString());
			while (rs.next()) {
				User user = new User();
				user.setId(rs.getString("userid"));
				user.setName(rs.getString("username"));
				list.add(user);
			}
		} catch (Exception e) {
			logger.error(e.getMessage());
		} finally{			
			this.closeResultSet(rs);
		}
		
		return list;
	
	}

}
