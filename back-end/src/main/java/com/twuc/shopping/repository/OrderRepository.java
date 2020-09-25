package com.twuc.shopping.repository;

import com.twuc.shopping.po.OrderPO;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;

/**
 * @Author: xqc
 * @Date: 2020/9/25 - 09 - 25 - 14:05
 * @Description: com.twuc.shopping.repository
 * @version: 1.0
 */
public interface OrderRepository extends PagingAndSortingRepository<OrderPO,Integer> {

    OrderPO  findByOrderName(String orderName);

    @Override
    List<OrderPO> findAll();
}
