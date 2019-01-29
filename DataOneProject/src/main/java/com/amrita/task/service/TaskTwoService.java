package com.amrita.task.service;

import com.amrita.task.entity.products;
import com.amrita.task.repository.ProductsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class TaskTwoService {

    @Autowired ProductsRepository productsRepository;

    public TreeMap<String, List> getAllProducts() {
        List<products> allProduct = productsRepository.getAllProducts();
        Map<String, List> map = new HashMap<>();
        for (products product: allProduct) {
            if(!map.containsKey(product.getBrand())) {
                List list = new ArrayList();
                Map<String, Object> temp = new HashMap<>();
                temp.put("id", product.getId());
                temp.put("name", product.getName());
                temp.put("price", product.getPrice());
                if(product.isOnSale()){
                    temp.put("event", "ON SALE");
                }
                list.add(temp);
                map.put(product.getBrand(), list);
            }
            else {
                List list = map.get(product.getBrand());
                Map<String, Object> temp = new HashMap<>();
                temp.put("id", product.getId());
                temp.put("name", product.getName());
                temp.put("price", product.getPrice());
                if(product.isOnSale()){
                    temp.put("event", "ON SALE");
                }
                list.add(temp);
                map.put(product.getBrand(), list);

            }
        }
        TreeMap<String, List> response = new TreeMap<>(map);
        return response;
    }
}
