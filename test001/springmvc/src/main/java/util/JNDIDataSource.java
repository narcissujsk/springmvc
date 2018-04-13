package util;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;


public class JNDIDataSource {

    private static DataSource dataSource = null;
    // 在静态代码块中创建数据库连接池
    static {

        try {
            // 初始化JNDI
            Context initContext = new InitialContext();
            // 得到JNDI容器
            Context envContext = (Context) initContext.lookup("java:comp/env");
            // 从JNDI容器中检索name为jdbc/datasource的数据源
            dataSource = (DataSource) envContext.lookup("jdbc/datasource");
            if (dataSource == null) {

                System.err.println("'DBPool' is an unknown DataSource");
            }

        } catch (Exception e) {

            throw new ExceptionInInitializerError(e);

        }

    }

    public static DataSource getDataSource(){
         return dataSource;
    }
}
