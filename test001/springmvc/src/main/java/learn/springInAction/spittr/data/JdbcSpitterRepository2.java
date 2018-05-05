package learn.springInAction.spittr.data;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import jsk.dao.BaseDao;
import jsk.vo.User;
import learn.springInAction.spittr.Spitter;
import learn.springInAction.spittr.Spittle;

@Repository("jdbcSpitterRepository")
public class JdbcSpitterRepository2 extends BaseDao implements SpitterRepository {
	//
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
		} finally {
			this.closeResultSet(rs);
		}

		return list;

	}

	@Override
	public Spitter save(Spitter spitter) {

		String sql = "insert into Spitter (username, password, first_name, last_name, email)"
				+ " values (?, ?, ?, ?, ?)";
		List<Object> params = new ArrayList<Object>();
		params.add(spitter.getUsername());
		params.add(spitter.getPassword());
		params.add(spitter.getFirstName());
		params.add(spitter.getLastName());
		params.add(spitter.getEmail());
		ResultSet rs = null;
		try {
			executeUpdate(sql, params);
		} catch (Exception e) {
			logger.error(e.getMessage());
		} finally {
			this.closeResultSet(rs);
		}
		return spitter;
	}

	@Override
	public Spitter findByUsername(String username) {
		String sql = "select id, username, null, first_name, last_name, email from Spitter where username=?";
		List<Object> params = new ArrayList<Object>();
		params.add(username);
		ResultSet rs = null;
		Spitter ss = new Spitter();
		try {
			rs = executeQuery(sql, params);
			while (rs.next()) {
				ss = new Spitter(rs.getLong("id"), rs.getString("username"), null, rs.getString("first_name"),
						rs.getString("last_name"), rs.getString("email"));

			}
		} catch (Exception e) {
			logger.error(e.getMessage());
		} finally {
			this.closeResultSet(rs);
		}

		return ss;

	}

}
