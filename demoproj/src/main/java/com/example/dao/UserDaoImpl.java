package com.example.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.blade.ioc.annotation.Bean;
import com.blade.ioc.annotation.Inject;
import com.example.config.DatabaseConfig;
import com.example.model.User;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

@Bean
public class UserDaoImpl implements Userdao {
    @Inject
    private DatabaseConfig databaseConfig;

    public JdbcTemplate getJdbcTemplate() {
        return new JdbcTemplate(databaseConfig.getDataSource());
    }

    @Override
    public int insertUserData(User user) {
        int insertResult=0;
        try {
            insertResult = getJdbcTemplate().update("insert into projects(code,pname,id)" + " values('" + user.getCode()
                    + "','" + user.getProjname() + "','" + user.getCustId() + "');");
            System.out.println("the result of insert operation is :" + insertResult+ " For ID" + user.getCustId());

        } catch (Exception e) {
            e.printStackTrace();
        }
        return insertResult;

    }
    @Override
    public List<User> getProjectDetails() {
        List<User> list = new ArrayList<User>();
        try {
            list = getJdbcTemplate().query("select * from projects", new RowMapper<User>() {

                @Override
                public User mapRow(ResultSet rs, int rowNum) throws SQLException {
                    User user = new User();
                    user.setCode(rs.getString("code"));
                    user.setProjname(rs.getString("pname"));
                    user.setCustId(rs.getString("id"));
                    return user;
                }
            });
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public User getDetailsOnPid(String pid) {
        User user=null;
        try {
            user =  getJdbcTemplate().queryForObject("select * from projects where id=?", new Object[] { pid },
                    new RowMapper<User>() {

                        @Override
                        public User mapRow(ResultSet rs, int rowNum) throws SQLException {
                            User u = new User();
                            u.setCode(rs.getString("code"));
                            u.setProjname(rs.getString("pname"));
                            u.setCustId(rs.getString("id"));
                            return u;
                        }
                    });
        } catch (Exception e) {
            e.printStackTrace();
        }
        return user;
    }

    @Override
    public int deleteDetailOfId(String pid) {
        int deleteResult=0;
        try {
            deleteResult = getJdbcTemplate().update("delete from projects where id=?", new Object[]{pid});
        } catch (Exception e) {
            e.printStackTrace();
        }
        return deleteResult;

    }

}