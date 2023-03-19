package com.example.sharding.repository;

import com.example.sharding.dao.AbstractControllerDao;
import com.example.sharding.dao.DbConnectionManager;
import com.example.sharding.exception.DataSourceException;
import com.example.sharding.model.User;
import com.example.sharding.model.enums.City;
import com.example.sharding.model.enums.UserStatus;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserRepository extends AbstractControllerDao<User, Long> {

    public UserRepository(DbConnectionManager dbConnectionManager) {
        super(dbConnectionManager);
    }

    @Override
    public List<User> getAll() {
        try {
            PreparedStatement usersState = super.getPrepareStatement(
                    "select * from public.user order by id;");
            ResultSet usersResult = usersState.executeQuery();

            List<User> users = new ArrayList<>();
            while (usersResult.next()) {
                users.add(User.builder()
                        .id(usersResult.getLong("id"))
                        .login(usersResult.getString("login"))
                        .city(City.valueOf(usersResult.getString("city")))
                        .status(UserStatus.valueOf(usersResult.getString("status")))
                        .build());
            }
            return users;
        } catch (SQLException ex) {
            throw new DataSourceException(ex.getMessage());
        }
    }

    @Override
    public User get(Long id) {
        try {
            PreparedStatement usersState = super.getPrepareStatement(
                    "select * from public.user where id = " + id + ";");
            ResultSet userResult = usersState.executeQuery();

            return userResult.next() ? User.builder()
                    .id(userResult.getLong("id"))
                    .login(userResult.getString("login"))
                    .city(City.valueOf(userResult.getString("city")))
                    .status(UserStatus.valueOf(userResult.getString("status")))
                    .build()
                    : null;
        } catch (SQLException ex) {
            throw new DataSourceException(ex.getMessage());
        }
    }

    @Override
    public User create(User entity) {
        try {
            super.getPrepareStatement("insert into public.user(login, city, status values "
                            + "(" + entity.getLogin() + ", " + entity.getCity() + ", " + entity.getStatus() + ");")
                    .executeQuery();
            Long last = super.getPrepareStatement("select max(id) from public.user;")
                    .executeQuery().getLong(1);
            return this.get(last);
        } catch (SQLException ex) {
            throw new DataSourceException(ex.getMessage());
        }
    }

    @Override
    public User update(User entity) {
        try {
            super.getPrepareStatement("update public.user set login = " + entity.getLogin()
                    + ", city = " + entity.getCity() + ", status = " + entity.getStatus() + ";").executeQuery();
            return this.get(entity.getId());
        } catch (SQLException ex) {
            throw new DataSourceException(ex.getMessage());
        }
    }

    @Override
    public void delete(Long id) {
        try {
            super.getPrepareStatement("delete from public.user where id = " + id + ";").executeQuery();
        } catch (SQLException ex) {
            throw new DataSourceException(ex.getMessage());
        }
    }
}
