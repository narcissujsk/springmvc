package learn.springInAction.spittr.data;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import jsk.dao.BaseDao;
import jsk.vo.User;
import learn.springInAction.spittr.Spitter;
import learn.springInAction.spittr.Spittle;

@Repository("jdbcSpittleRepository")
public class JdbcSpittleRepository2 extends BaseDao implements SpittleRepository {
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
	public List<Spittle> findRecentSpittles() {

		String sql = "select id, message, created_at, latitude, longitude" + " from Spittle"
				+ " order by created_at desc limit 20";
		List<Spittle> list = new ArrayList<Spittle>();
		ResultSet rs = null;
		try {
			rs = executeQuery(sql);
			while (rs.next()) {
				Spittle ss = new Spittle(rs.getLong("id"), rs.getString("message"), rs.getDate("created_at"),
						rs.getDouble("longitude"), rs.getDouble("latitude"));
				list.add(ss);
			}
		} catch (Exception e) {
			logger.error(e.getMessage());
		} finally {
			this.closeResultSet(rs);
		}

		return list;

	}

	@Override
	public List<Spittle> findSpittles(long max, int count) {
		String sql = "select id, message, created_at, latitude, longitude  from Spittle  where 1=1 and id < ? order by created_at desc limit 20";
		List<Object> params = new ArrayList<Object>();
		params.add(count);
		List<Spittle> list = new ArrayList<Spittle>();
		ResultSet rs = null;
		try {
			rs = executeQuery(sql, params);
			while (rs.next()) {
				Spittle ss = new Spittle(rs.getLong("id"), rs.getString("message"), rs.getDate("created_at"),
						rs.getDouble("longitude"), rs.getDouble("latitude"));
				list.add(ss);
			}
		} catch (Exception e) {
			logger.error(e.getMessage());
		} finally {
			this.closeResultSet(rs);
		}

		return list;

	}

	@Override
	public Spittle findOne(long id) {
		String sql = "select id, message, created_at, latitude, longitude" + " from Spittle" + " where id = ?";
		List<Object> params = new ArrayList<Object>();
		params.add(id);
		ResultSet rs = null;
		Spittle ss = new Spittle(null, null);
		try {
			rs = executeQuery(sql, params);
			while (rs.next()) {
				ss = new Spittle(rs.getLong("id"), rs.getString("message"), rs.getDate("created_at"),
						rs.getDouble("longitude"), rs.getDouble("latitude"));

			}
		} catch (Exception e) {
			logger.error(e.getMessage());
		} finally {
			this.closeResultSet(rs);
		}

		return ss;

	}

	@Override
	public void save(Spittle spittle) {

		String sql = "insert into Spittle (message, created_at, latitude, longitude)" + " values (?, ?, ?, ?)";
		List<Object> params = new ArrayList<Object>();

		params.add(spittle.getMessage());
		params.add(spittle.getTime());
		params.add(spittle.getLatitude());
		params.add(spittle.getLongitude());
		ResultSet rs = null;
		Spittle ss = new Spittle(null, null);
		try {
			executeUpdate(sql, params);
		} catch (Exception e) {
			logger.error(e.getMessage());
		} finally {
			this.closeResultSet(rs);
		}
	}

}
