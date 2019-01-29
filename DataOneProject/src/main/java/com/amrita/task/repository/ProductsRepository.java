package com.amrita.task.repository;

import com.amrita.task.entity.products;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ProductsRepository {

    @Autowired JdbcTemplate jdbcTemplate;

    public products findById(Long id) {
        return jdbcTemplate.queryForObject("select * from products where id=?", new Object[] {
            id
        },
            new BeanPropertyRowMapper<products>(products.class));
    }

    public List<products> getAllProducts() {
        return jdbcTemplate.query("SELECT * FROM PRODUCTs ORDER BY  brand, price", new BeanPropertyRowMapper<products>(products.class));
    }
}
