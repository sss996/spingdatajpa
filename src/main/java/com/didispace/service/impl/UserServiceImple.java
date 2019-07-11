package com.didispace.service.impl;

import com.didispace.bean.User;
import com.didispace.connn.SexEnum;
import com.didispace.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.util.List;

public class UserServiceImple implements UserService {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    // 获取映射关系
    private RowMapper<User> getUserMapper(){
        // 使用Lambda 表达式创建用户关系映射表
        RowMapper<User> userRowMapper = (ResultSet rs,int rownum) ->{
            User user = new User();
            user.setId(rs.getLong("id"));
            user.setUserName(rs.getString("username"));
            int sexId = rs.getInt("sex");
            SexEnum sex = SexEnum.getEnumById(sexId);
            user.setSex(sex);
            user.setNote(rs.getString("note"));

            return  user;
        };
        return  userRowMapper;
    }

    @Override
    public User getUser(Long id) {
        // 执行sql
        String sql = " select id, username,sex note from user where id = ?";
        Object[] params =new Object[]{id};
        User user = jdbcTemplate.queryForObject(sql,params,getUserMapper());
        return  user;
    }

    @Override
    public List<User> findUsers(String userName, String note) {
        return null;
    }

    @Override
    public int insertUser(User user) {
        return 0;
    }

    @Override
    public int updateUser(User user) {
        return 0;
    }

    @Override
    public int deleteUser(Long id) {
        return 0;
    }
}
