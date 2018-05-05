package jsk.dao;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import jsk.util.DBHelper;

import javax.naming.NamingException;
import java.sql.*;
import java.util.*;

public class BaseDao {
	protected static final Logger logger;
	private static final char UNDERLINE = '_';
	static {
		logger = LoggerFactory.getLogger(BaseDao.class);
	}//
		// 加载数据库驱动 com.mysql.jdbc.Driver
	private static String dbdriver = "com.mysql.jdbc.Driver";
	// 获取mysql连接地址
	private static String dburl = "jdbc:mysql://127.0.0.1:3306/jsk?&useSSL=false";
	// 数据名称
	private static String username = "root";
	// 数据库密码
	private static String userpassword = "385152";
	// 获取一个数据的连接
	public static Connection conn = null;
	// 获取连接的一个状态

	public static void main(String[] args) throws SQLException {
		List<List<Object>> x = getData("mysql", "select * from user");
		System.out.println("x=" + x);
	}
	
	
	public Connection getConnection() {

		try {
			if (conn == null) {
				conn = getConn2();
				//conn = getConn();
			}

		} catch (Exception e) {
			logger.error(e.getMessage());

		}
		return conn;
	}
	/**
	 * 获取数据库连接
	 * 
	 * @param myProjName
	 * @return
	 * @throws NamingException
	 * @throws SQLException
	 */

	private static Connection getConn2() {
		Connection conn = null;
		try {
			Class.forName(dbdriver);
			String myjdbcUrl = dburl.replace("jsk", "jsk");
			conn = DriverManager.getConnection(myjdbcUrl, username, userpassword);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return conn;
	}

	private static Connection getConn() {
		Connection conn = null;
		try {
			conn = DBHelper.getConnection();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (NamingException e) {
			e.printStackTrace();
		}

		return conn;
	}

	/**
	 * 关闭数据库连接
	 * 
	 * @param rs
	 * @param ps
	 * @param conn
	 */
	private static void closeAll(ResultSet rs, PreparedStatement ps, Connection conn) {
		if (rs != null) {
			try {
				rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		if (ps != null) {
			try {
				ps.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		if (conn == null)
			return;
		try {
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	/**
	 * 查表，返回行的列表，每个列表中包含列的列表。
	 * 
	 * @param ProjName
	 * @param sql
	 * @return
	 */
	public static List<List<Object>> getData(String ProjName, String sql) {
		Connection conn = getConn2();
		PreparedStatement ps = null;
		List<List<Object>> list = new ArrayList<List<Object>>();
		ResultSet rs = null;
		try {
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			ResultSetMetaData md = rs.getMetaData();
			int columnCount = md.getColumnCount();
			while (rs.next()) {
				List<Object> lst = new ArrayList<Object>();
				for (int i = 1; i <= columnCount; ++i) {
					lst.add(rs.getObject(i) == null ? "" : rs.getObject(i));
				}
				list.add(lst);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			closeAll(rs, ps, conn);
		}
		return list;
	}

	Statement stmt = null;
	PreparedStatement preparedStatement = null;

	public BaseDao() {

	}



	/**
	 * 关闭连接、事务、结果集的方法，供子类调用
	 *
	 * @param rs
	 */
	public void closeResource2(ResultSet rs, Statement statement, Connection connection) {
		if (rs != null) {
			try {
				rs.close();

			} catch (Exception e) {
				logger.error(e.getMessage());
			}
			rs = null;
		}
		if (statement != null) {
			try {
				statement.close();
				statement = null;
			} catch (Exception e) {
				logger.error(e.getMessage());
			}
		}

		if (connection != null) {
			try {
				connection.close();
				connection = null;

			} catch (Exception e) {
				logger.error(e.getMessage());
			}
		}
	}

	/**
	 * 关闭连接、事务、结果集的方法，供子类调用
	 *
	 * @param rs
	 */
	public void closeResultSet(ResultSet rs) {
		if (rs != null) {
			try {
				rs.close();

			} catch (Exception e) {
				logger.error(e.getMessage());
			}
			rs = null;
		}
		if (stmt != null) {
			try {
				stmt.close();
				stmt = null;
			} catch (Exception e) {
				logger.error(e.getMessage());
			}
		}
		if (preparedStatement != null) {
			try {
				preparedStatement.close();
				preparedStatement = null;
			} catch (Exception e) {
				logger.error(e.getMessage());
			}
		}

		if (conn != null) {
			try {
				conn.close();
				conn = null;

			} catch (Exception e) {
				logger.error(e.getMessage());
			}
		}
	}

	/**
	 * 关闭连接、事务、结果集的方法，供子类调用
	 *
	 * @param rs
	 * @param statement
	 * @param connection
	 */
	public void closeResource(ResultSet rs, Statement statement, Connection connection) {
		if (rs != null) {
			try {
				rs.close();

			} catch (Exception e) {
				logger.error(e.getMessage());
			}
			rs = null;
		}
		if (statement != null) {
			try {
				statement.close();
				statement = null;
			} catch (Exception e) {
				logger.error(e.getMessage());
			}
		}

		if (connection != null) {
			try {
				connection.close();
				connection = null;

			} catch (Exception e) {
				logger.error(e.getMessage());
			}
		}
	}

	/**
	 * 关闭连接、事务的方法，供子类调用
	 */
	public void closeResultSet() {
		if (stmt != null) {
			try {
				stmt.close();
				stmt = null;
			} catch (Exception e) {
				logger.error(e.getMessage());
			}
		}
		if (preparedStatement != null) {
			try {
				preparedStatement.close();
				preparedStatement = null;
			} catch (Exception e) {
				logger.error(e.getMessage());
			}
		}
		if (conn != null) {
			try {
				conn.close();
				conn = null;

			} catch (Exception e) {
				logger.error(e.getMessage());
			}
		}
	}

	/**
	 * 调用jdbc查询sql返回结果集的方法
	 *
	 * @param sql
	 * @return rs
	 */
	public ResultSet executeQuery(String sql, List<Object> params) {
		ResultSet retSet = null;
		try {
			if (conn == null) {
				conn = getConnection();
			}
			preparedStatement = conn.prepareStatement(sql);
			if (params != null && !params.isEmpty()) {
				for (int i = 0; i < params.size(); i++) {
					preparedStatement.setObject(i + 1, params.get(i));
				}
			}
			retSet = preparedStatement.executeQuery();

		} catch (Exception e) {
			logger.error(e.getMessage());
			logger.error(sql);
		}
		return retSet;
	}

	/**
	 * 调用jdbc查询sql返回结果集的方法
	 *
	 * @param sql
	 * @return rs
	 */
	public ResultSet executeQuery(String sql) {
		ResultSet rs = null;
		try {
			if (conn == null) {
				conn = getConnection();
			}
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
		} catch (Exception e) {
			logger.error(e.getMessage());
			logger.error(sql);
		}
		return rs;
	}

	/**
	 * 调用jdbc执行sql update类语句，返回执行结果true/false
	 *
	 * @param sql
	 * @return
	 * @throws SQLException
	 * @throws NamingException
	 */
	public Boolean executeUpdate(String sql) {
		Boolean suc = true;
		try {
			if (conn == null) {
				conn = getConnection();
			}
			if (stmt == null) {
				stmt = conn.createStatement();
			}

			stmt.executeUpdate(sql);
		} catch (Exception e) {
			suc = false;
			logger.error(e.getMessage());
			logger.error(sql);
		} finally {
			this.closeResultSet();
		}
		return suc;
	}
	/*
	 * protected Boolean executeUpdate(String sql) throws Exception { Boolean suc =
	 * true; try { if (conn == null) { conn = getConnection(); } if (stmt == null) {
	 * stmt = conn.createStatement(); }
	 * 
	 * stmt.executeUpdate(sql); } catch (Exception e) { suc = false;
	 * logger.error(e.getMessage()); logger.error(sql); throw e; } finally {
	 * this.closeResultSet(); } return suc; }
	 */

	/**
	 * 带列表参数实体查询
	 *
	 * @param sql
	 * @param params
	 * @return
	 */
	public int getTotal(String sql, List<Object> params) {
		ResultSet retSet = null;
		try {
			if (conn == null) {
				conn = getConnection();
			}
			if (params != null) {
				if (preparedStatement == null) {
					preparedStatement = conn.prepareStatement(sql);
				}
				for (int i = 0; i < params.size(); i++) {
					preparedStatement.setObject(i + 1, params.get(i));
				}
			}

			retSet = preparedStatement.executeQuery();

			int count = -1;
			while (retSet.next()) {
				count = retSet.getInt(1);
			}

			return count;
		} catch (Exception e) {
			return -1;
		} finally {
			this.closeResultSet(retSet);
		}
	}

	/**
	 * 获取String类型的list
	 * 
	 * @param sql
	 * @param params
	 * @return
	 */
	public List<String> getStringList(String sql, List<Object> params) {
		List<String> list = new ArrayList<String>();
		ResultSet resultSet = null;
		try {
			if (conn == null) {
				conn = getConnection();
			}
			if (preparedStatement == null) {
				preparedStatement = conn.prepareStatement(sql);
			}
			if (params != null) {
				for (int i = 0; i < params.size(); i++) {
					preparedStatement.setObject(i + 1, params.get(i));
				}
			}
			resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {
				list.add(resultSet.getString(1));
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			this.closeResultSet(resultSet);
		}
		return list;
	}

	/**
	 * 事务处理
	 *
	 * @param sqls
	 * @return
	 */
	public int[] executeBatch(String[] sqls) {
		int[] re = null;
		try {
			if (conn == null) {
				conn = getConnection();
			}
			conn.setAutoCommit(false);
			stmt = conn.createStatement();
			for (String sql : sqls) {
				stmt.addBatch(sql);
			}
			re = stmt.executeBatch();

			// add by sungg 20171130 如果某条语句执行失败，回滚
			for (int temp : re) {
				if (temp == Statement.EXECUTE_FAILED) {
					conn.rollback();
					return re;
				}
			}

			conn.commit();
			return re;
		} catch (Exception e) {
			try {
				conn.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			e.printStackTrace();
			return re;
		} finally {
			this.closeResultSet();
		}
	}

	public int getTotal(String sql, String[] args, String[] types) {
		ResultSet resultSet = null;
		try {
			if (conn == null) {
				conn = getConnection();
			}
			if (preparedStatement == null) {
				preparedStatement = conn.prepareStatement(sql);
			}
			for (int i = 0; i < args.length; i++) {
				if ("String".equals(types[i])) {
					preparedStatement.setString(i + 1, String.valueOf(args[i]));
				} else if ("Integer".equals(types[i])) {
					preparedStatement.setInt(i + 1, Integer.parseInt(String.valueOf(args[i])));
				} else {
					preparedStatement.setObject(i + 1, args[i]);
				}

			}
			resultSet = preparedStatement.executeQuery();

			int count = -1;
			while (resultSet.next()) {
				count = resultSet.getInt(1);
			}
			return count;
		} catch (Exception e) {
			return -1;
		} finally {
			this.closeResultSet(resultSet);
		}
	}

	/**
	 * 调用jdbc执行sql update类语句，返回执行结果true/false(预编译)
	 *
	 * @param sql
	 * @return
	 */
	public Boolean executeUpdate(String sql, Object... args) {
		Boolean suc = true;
		try {
			if (conn == null) {
				conn = getConnection();
			}
			preparedStatement = conn.prepareStatement(sql);
			for (int i = 0; i < args.length; i++) {
				preparedStatement.setObject(i + 1, args[i]);
			}
			preparedStatement.execute(); // 此处的返回值false不是代表执行失败!
		} catch (Exception e) {
			suc = false;
			logger.error(e.getMessage());
			logger.error(sql);
		} finally {
			this.closeResultSet();
		}
		return suc;
	}

	/**
	 * 调用jdbc执行sql update类语句，返回执行结果true/false(预编译)
	 *
	 * @param sql
	 * @return
	 */
	public Boolean executeUpdate(String sql, List<Object> params) {
		Boolean suc = true;
		try {
			if (conn == null) {
				conn = getConnection();
			}
			preparedStatement = conn.prepareStatement(sql);
			if (params != null) {
				for (int i = 0; i < params.size(); i++) {
					preparedStatement.setObject(i + 1, params.get(i));
				}
			}
			logger.info(sql);
			preparedStatement.execute();
		} catch (Exception e) {
			suc = false;
			logger.error(e.getMessage());
			logger.error(sql);
		} finally {
			this.closeResultSet();
		}
		return suc;
	}

	/**
	 * 注意这个方法的参数，和上面的方法不同 ，方法中说关闭的对象也不相同 关闭连接、事务的方法，供子类调用
	 */
	public void closeResultSet(ResultSet resultSet, Statement statement, Connection connection) {
		if (resultSet != null) {
			try {
				resultSet.close();
			} catch (SQLException e) {
				e.printStackTrace();
				logger.error(e.toString());
			}
		}
		if (statement != null) {
			try {
				statement.close();
				statement = null;
			} catch (Exception e) {
				logger.error(e.getMessage());
			}
		}
		if (connection != null) {
			try {
				connection.close();
				connection = null;
			} catch (Exception e) {
				logger.error(e.getMessage());
			}
		}
	}

	/**
	 * 执行后不关闭与数据库的连接 jiangfw_20170306 调用jdbc执行sql update类语句，返回执行结果true/false
	 *
	 * @param sql
	 * @return
	 * @throws SQLException
	 */
	public Boolean executeUpdateNoColse(String sql) {
		Boolean suc = true;
		try {
			if (conn == null) {
				conn = getConnection();
			}
			if (stmt == null) {
				stmt = conn.createStatement();
			}
			stmt.executeUpdate(sql);
		} catch (Exception e) {
			suc = false;
			logger.error(e.getMessage());
			logger.error(sql);
		}
		return suc;
	}

	/**
	 * 事务处理
	 *
	 * @param sqls
	 * @return
	 */
	public boolean executeIpPreOccupyBatch(String[] sqls) {
		boolean bRes = true;
		int[] re = null;
		try {
			if (conn == null) {
				conn = getConnection();
			}
			conn.setAutoCommit(false);
			stmt = conn.createStatement();
			for (String sql : sqls) {
				stmt.addBatch(sql);
			}
			re = stmt.executeBatch();
			if (re == null || (re.length != sqls.length)) {
				conn.rollback();
				bRes = false;
			} else {
				for (int i = 0; i < re.length; i++) {
					if (re[i] != 1) {
						conn.rollback();
						bRes = false;
						return bRes;
					}
				}
				conn.commit();
				bRes = true;
			}
			return bRes;
		} catch (Exception e) {
			e.printStackTrace();
			bRes = false;
			return bRes;
		} finally {
			this.closeResultSet();
		}
	}

	/**
	 * 事务处理
	 *
	 * @param sqls
	 * @return
	 */
	public boolean executeBatchs(String[] sqls) {
		boolean bRes = true;
		int[] re = null;
		try {
			if (conn == null) {
				conn = getConnection();
			}
			conn.setAutoCommit(false);
			stmt = conn.createStatement();
			for (String sql : sqls) {
				stmt.addBatch(sql);
			}
			re = stmt.executeBatch();
			if (re == null || (re.length != sqls.length)) {
				conn.rollback();
				bRes = false;
			} else {
				conn.commit();
				bRes = true;
			}
			return bRes;
		} catch (Exception e) {
			e.printStackTrace();
			bRes = false;
			return bRes;
		} finally {
			this.closeResultSet();
		}
	}

	/**
	 * 获取PreparedStatement
	 * 
	 * @param sqltxt
	 *            String
	 * @return PreparedStatement PreparedStatement
	 * @throws Exception
	 *             抛出异常
	 */
	public PreparedStatement getPreparedStatement(String sqltxt) throws Exception {
		// 获取ps
		try {
			if (conn == null) {
				conn = this.getConnection();
			}

			preparedStatement = conn.prepareStatement(sqltxt);
		} catch (SQLException e) {
			// 捕获异常
			logger.error("getPreparedStatement(), error:", e);
			throw new Exception("Get prepared statement error(" + e.getMessage()
					+ ") error in getPreparedStatement()!\r\n error is " + e);
		} catch (Exception e) {
			// 捕获异常
			logger.error("getPreparedStatement(), error:", e);
			throw new Exception("Get prepared statement error(" + e.getMessage()
					+ ") error in getPreparedStatement()!\r\n error is " + e);
		}
		return preparedStatement;
	}
}
