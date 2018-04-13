
package JdbcTemplateTest;

import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * 实现RowMapper接口，返回User对象
 * */
public class MyRowMapper implements RowMapper<User>{

    @Override
    public User mapRow(ResultSet resultSet, int i) throws SQLException {
//        获取结果集中的数据
        String name = resultSet.getString("username");
        String age = resultSet.getString("age");
//        把数据封装成User对象
        User user = new User();
        user.setName(name);
        user.setAge(age);
        return user;
    }
}