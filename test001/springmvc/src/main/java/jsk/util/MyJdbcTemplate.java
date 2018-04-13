package jsk.util;
import org.springframework.jdbc.core.JdbcTemplate;
public class MyJdbcTemplate {


    private static JdbcTemplate jdbcTemplate;

    static {
        jdbcTemplate = new JdbcTemplate(JNDIDataSource.getDataSource());

    }

    public static JdbcTemplate getJdbcTemplate(){

        return jdbcTemplate;
    }


}