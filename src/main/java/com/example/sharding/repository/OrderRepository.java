package com.example.sharding.repository;

import com.example.sharding.dao.AbstractControllerDao;
import com.example.sharding.dao.DbConnectionManager;
import com.example.sharding.model.Order;
import com.example.sharding.model.User;
import com.example.sharding.model.enums.UserStatus;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class OrderRepository extends AbstractControllerDao<Order, Long> {

    public OrderRepository(DbConnectionManager dbConnectionManager) {
        super(dbConnectionManager);
    }

    @Override
    public List<Order> getAll() throws SQLException {
        PreparedStatement ordersState = super.getPrepareStatement(
                "select * from public.order order by id;");
        ResultSet ordersResult = ordersState.executeQuery();

        List<Order> orders = new ArrayList<>();
        while (ordersResult.next()) {
            orders.add(Order.builder()
                    .id(ordersResult.getLong("id"))
                    .user(this.getUser(ordersResult.getLong("user_id")))
                    .product(ordersResult.getString("product"))
                    .count(ordersResult.getLong("count"))
                    .build());
        }
        return orders;
    }

    @Override
    public Order get(Long id) throws SQLException {
        PreparedStatement orderState = super.getPrepareStatement(
                "select * from public.order where id = " + id + ";");
        ResultSet orderResult = orderState.executeQuery();

        return orderResult.next() ? Order.builder()
                .id(orderResult.getLong("id"))
                .user(this.getUser(orderResult.getLong("user_id")))
                .product(orderResult.getString("product"))
                .count(orderResult.getLong("count"))
                .build()
                : null;
    }

    @Override
    public Order create(Order entity) throws SQLException {
        super.getPrepareStatement("insert into public.order(user_id, product, count values "
                        + "(" + entity.getUser().getId() + ", " + entity.getProduct() + ", " + entity.getCount() + ");")
                .executeQuery();
        Long last = super.getPrepareStatement("select max(id) from public.order;")
                .executeQuery().getLong(1);
        return this.get(last);
    }

    @Override
    public Order update(Order entity) throws SQLException {
        super.getPrepareStatement("update public.order set user_id = " + entity.getUser().getId()
                + ", product = " + entity.getProduct() + ", count = " + entity.getCount() + ";").executeQuery();
        return this.get(entity.getId());
    }

    @Override
    public void delete(Long id) throws SQLException {
        super.getPrepareStatement("delete from public.order where id = " + id + ";").executeQuery();
    }

    private User getUser(Long id) throws SQLException {
        PreparedStatement userState = super.getPrepareStatement(
                "select * from public.user where id = " + id + ";"
        );
        ResultSet userResult = userState.executeQuery();
        return userResult.next() ? User.builder()
                .id(userResult.getLong("id"))
                .login(userResult.getString("login"))
                .city(userResult.getString("city"))
                .status(UserStatus.valueOf(userResult.getString("status")))
                .build()
                : null;
    }
}
