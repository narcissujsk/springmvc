package jsk.util;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DBHelper {

//  // 在静态代码块中创建数据库连接池
//  static {
//
//      try {
//          ApplicationContext scheduleFactory = new ClassPathXmlApplicationContext(
//                  "beans.xml");
////          // 初始化JNDI
////          Context initContext = new InitialContext();
////          // 得到JNDI容器
////          Context envContext = (Context) initContext.lookup("java:comp/env");
//          // 从JNDI容器中检索name为jdbc/datasource的数据源
////          ds = (DataSource) envContext.lookup("jdbc/datasource");
//          ds = (DataSource) scheduleFactory.getBean("quartzDataSource");
//          if (ds == null) {
//
//              System.err.println("'DBPool' is an unknown DataSource");
//          }
//
//      } catch (Exception e) {
//
//          throw new ExceptionInInitializerError(e);
//
//      }
//
//  }
	private static DataSource ds = null;
	// 在静态代码块中创建数据库连接池
	static {

		try {
			// 初始化JNDI
			Context initContext = new InitialContext();
			
			// 得到JNDI容器
			Context envContext = (Context) initContext.lookup("java:comp/env");
			// 从JNDI容器中检索name为jdbc/datasource的数据源
			ds = (DataSource) envContext.lookup("jdbc/datasource");
			if (ds == null) {

				System.err.println("'DBPool' is an unknown DataSource");
			}

		} catch (Exception e) {

			throw new ExceptionInInitializerError(e);

		}

	}

	public static Connection getConnection() throws SQLException,
			NamingException {
		// 从数据源中获取数据库连接
		return ds.getConnection();

	}

	public static DataSource getDataSource() {
		// 从数据源中获取数据库连接
		return ds;

	}

	public static void release(Connection conn, Statement st, ResultSet rs) {
		if (rs != null) {
			try {// 关闭存储查询结果的ResultSet对象
				rs.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
			rs = null;
		}
		if (st != null) {
			try {// 关闭负责执行SQL命令的Statement对象
				st.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		if (conn != null) {
			try {// 将Connection连接对象还给数据库连接池
				conn.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	public static void releaseSta(Connection conn, Statement st) {

		if (st != null) {
			try {// 关闭负责执行SQL命令的Statement对象
				st.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		if (conn != null) {
			try {// 将Connection连接对象还给数据库连接池
				conn.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	
	public static void release(Connection conn, PreparedStatement pst) {

		if (pst != null) {
			try {// 关闭负责执行SQL命令的PreparedStatement对象
				pst.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		if (conn != null) {
			try {// 将Connection连接对象还给数据库连接池
				conn.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	public static void release(Connection conn, Statement pst) {

		if (pst != null) {
			try {// 关闭负责执行SQL命令的PreparedStatement对象
				pst.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		if (conn != null) {
			try {// 将Connection连接对象还给数据库连接池
				conn.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
}
