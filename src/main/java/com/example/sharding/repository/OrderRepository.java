package com.example.sharding.repository;

import com.example.sharding.dao.AbstractControllerDao;
import com.example.sharding.dao.DbConnectionManager;
import com.example.sharding.exception.DataSourceException;
import com.example.sharding.model.Order;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class OrderRepository extends AbstractControllerDao<Order, Long> {

    private final UserRepository userRepository;

    public OrderRepository(DbConnectionManager dbConnectionManager, UserRepository userRepository) {
        super(dbConnectionManager);
        this.userRepository = userRepository;
    }

    @Override
    public List<Order> getAll() {
        try {
            PreparedStatement ordersState = super.getPrepareStatement(
                    "select * from public.order order by id;");
            ResultSet ordersResult = ordersState.executeQuery();

            List<Order> orders = new ArrayList<>();
            while (ordersResult.next()) {
                orders.add(Order.builder()
                        .id(ordersResult.getLong("id"))
                        .user(userRepository.get(ordersResult.getLong("user_id")))
                        .product(ordersResult.getString("product"))
                        .count(ordersResult.getLong("count"))
                        .build());
            }
            return orders;
        } catch (SQLException ex) {
            throw new DataSourceException(ex.getMessage());
        }
    }

    @Override
    public Order get(Long id) {
        try {
            PreparedStatement orderState = super.getPrepareStatement(
                    "select * from public.order where id = " + id + ";");
            ResultSet orderResult = orderState.executeQuery();

            return orderResult.next() ? Order.builder()
                    .id(orderResult.getLong("id"))
                    .user(userRepository.get(orderResult.getLong("user_id")))
                    .product(orderResult.getString("product"))
                    .count(orderResult.getLong("count"))
                    .build()
                    : null;
        } catch (SQLException ex) {
            throw new DataSourceException(ex.getMessage());
        }
    }

    @Override
    public Order create(Order entity) {
        try {
            super.getPrepareStatement("insert into public.order(user_id, product, count) values "
                            + "('" + entity.getUser().getId() + "', '" + entity.getProduct()
                            + "', '" + entity.getCount() + "');")
                    .executeUpdate();
            ResultSet resultSet = super.getPrepareStatement("select max(id) from public.order;").executeQuery();
            resultSet.next();
            Long last = resultSet.getLong("max");
            return this.get(last);
        } catch (SQLException ex) {
            throw new DataSourceException(ex.getMessage());
        }
    }

    @Override
    public Order update(Order entity) {
        try {
            super.getPrepareStatement("update public.order set user_id = '" + entity.getUser().getId()
                    + "', product = '" + entity.getProduct() + "', count = '" + entity.getCount() + "'" +
                            "where id = " + entity.getId() + ";")
                    .executeUpdate();
            return this.get(entity.getId());
        } catch (SQLException ex) {
            throw new DataSourceException(ex.getMessage());
        }
    }

    @Override
    public void delete(Long id) {
        try {
            super.getPrepareStatement("delete from public.order where id = " + id + ";").executeUpdate();
        } catch (SQLException ex) {
            throw new DataSourceException(ex.getMessage());
        }
    }
}
