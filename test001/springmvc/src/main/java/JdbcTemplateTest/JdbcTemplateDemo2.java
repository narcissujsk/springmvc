package JdbcTemplateTest;



import org.springframework.jdbc.core.JdbcTemplate;

import java.sql.*;
import java.util.List;

/**
 * 功能：通过JdbcTemplate实现查询操作
 * 查询结果需要自己封装(实现RowMapper接口)
 */

public class JdbcTemplateDemo2 {
// JdbcTemplate使用步骤：
// 1、导入jar包；2、设置数据库信息；3、设置数据源；4、调用jdbcTemplate对象中的方法实现操作

    public static void main(String[] args) {
        // 设置数据库信息和据源
        JdbcTemplateObject jdbcTemplateObject = new JdbcTemplateObject();
        JdbcTemplate jdbcTemplate = jdbcTemplateObject.getJdbcTemplate();

//        插入数据
//        insertData();

//        查询返回某一个值：查询表中数据总数
        queryForOne(jdbcTemplate);

//        查询返回对象
        queryForObject(jdbcTemplate);

//        查询返回list集合
        queryForList(jdbcTemplate);

//        使用JDBC底层实现查询
        queryWithJDBC();
    }

    //  插入数据
    public static void insertData() {
        JdbcTemplateObject jdbcTemplateObject = new JdbcTemplateObject();
        JdbcTemplate jdbcTemplate = jdbcTemplateObject.getJdbcTemplate();
//        调用jdbcTemplate对象中的方法实现操作
        String sql = "insert into user value(?,?,?)";
        //表结构：id（int、自增）,name(varchar 100),age(int 10)
        int rows = jdbcTemplate.update(sql, null, "Tom", 35);
        System.out.println("插入行数：" + rows);
    }

    /**
     * 查询返回某一个值：查询表中数据总数
     */
    public static void queryForOne(JdbcTemplate jdbcTemplate) {
        String sql = "select count(*) from user";
//        调用方法获得记录数
        int count = jdbcTemplate.queryForObject(sql, Integer.class);
        System.out.println("数据总数：" + count);
    }

    /**
     * 功能：查询返回单个对象
     * 步骤：新建MyRowMapper类实现RowMapper接口，重写mapRow方法，指定返回User对象
     */
    public static void queryForObject(JdbcTemplate jdbcTemplate) {
        String sql = "select * from user where username = ?";
//        新建MyRowMapper类实现RowMapper接口，重写mapRow方法，指定返回User对象
        User user = jdbcTemplate.queryForObject(sql, new MyRowMapper(), "name1");
        System.out.println(user);
    }

    /**
     * 功能：查询返回对象集合
     * 步骤：新建MyRowMapper类实现RowMapper接口，重写mapRow方法，指定返回User对象
     */
    public static void queryForList(JdbcTemplate jdbcTemplate) {
        String sql = "select * from user";
//        第三个参数可以省略
        List<User> users = jdbcTemplate.query(sql, new MyRowMapper());
        System.out.println(users);
    }

    /**
     * 使用JDBC底层实现查询
     */
    public static void queryWithJDBC() {
        Connection conn = null;
        PreparedStatement psmt = null;
        ResultSet rs = null;
        String jdbcUrl = "jdbc:mysql://127.0.0.1:3306/jsk?useUnicode=true&amp;characterEncoding=UTF-8";

        try {
//            加载驱动
            Class.forName("com.mysql.jdbc.Driver");
//            创建连接
            conn = DriverManager.getConnection(jdbcUrl, "root", "385152");
            String sql = "select * from user where username = ?";
//            预编译sql
            psmt = conn.prepareStatement(sql);
//            从1开始，没有就不需要
            psmt.setString(1, "name1");
//            执行sql
            rs = psmt.executeQuery();
//            int num = psmt.executeUpdate(); //增删改，返回操作记录数

//            遍历结果集
            while (rs.next()) {
                //根据列名查询对应的值，也可以是位置序号
                String name = rs.getString("username");
                String age = rs.getString("age");
                System.out.println(name);
                System.out.println(age);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                rs.close();
                psmt.close();
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

}