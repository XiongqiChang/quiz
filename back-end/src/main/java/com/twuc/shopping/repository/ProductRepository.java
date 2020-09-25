package com.twuc.shopping.repository;

import com.twuc.shopping.po.ProductPO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;

/**
 * @Author: xqc
 * @Date: 2020/9/25 - 09 - 25 - 14:04
 * @Description: com.twuc.shopping.repository
 * @version: 1.0
 */
public interface ProductRepository extends CrudRepository<ProductPO,Integer> {

    @Override
    List<ProductPO> findAll();


    ProductPO findByProductName(String productName);
}
