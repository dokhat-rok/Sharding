package com.example.sharding.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

public abstract class AbstractControllerDao<E, K> {
    private final DbConnectionManager dbConnectionManager;

    public abstract List<E> getAll() throws SQLException;

    public abstract E get(K id) throws SQLException;

    public abstract E create(E entity) throws SQLException;

    public abstract E update(E entity) throws SQLException;

    public abstract void delete(K id) throws SQLException;

    public AbstractControllerDao(DbConnectionManager dbConnectionManager){
        this.dbConnectionManager = dbConnectionManager;
    }

    // Получение экземпляра PrepareStatement
    public PreparedStatement getPrepareStatement(String sql) throws SQLException {
        Connection connection = dbConnectionManager.getConnection();
        PreparedStatement ps = null;
        try {
            ps = connection.prepareStatement(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return ps;
    }

    // Закрытие PrepareStatement
    public void closePrepareStatement(PreparedStatement ps){
        if (ps != null) {
            try {
                ps.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    // Получение экземпляра Statement
    public Statement getStatement() throws SQLException {
        Connection connection = dbConnectionManager.getConnection();
        Statement s = null;
        try {
            s = connection.createStatement();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return s;
    }

    // Закрытие Statement
    public void closeStatement(Statement s){
        if (s != null) {
            try {
                s.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
