package com.twuc.shopping.service;

import com.twuc.shopping.po.ProductPO;
import com.twuc.shopping.repository.ProductRepository;
import com.twuc.shopping.vo.ProductVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * @Author: xqc
 * @Date: 2020/9/25 - 09 - 25 - 14:07
 * @Description: com.twuc.shopping.service
 * @version: 1.0
 */
@Service
public class ProductService {
    @Autowired
    private ProductRepository productRepository;


    public List<ProductVO> findAll() {

        List<ProductPO> all = productRepository.findAll();
        List<ProductVO> productVOList = all.stream().map(
                item -> ProductVO.builder().id(item.getId())
                                            .pictureUrl(item.getPictureUrl())
                                            .price(item.getPrice()).productName(item.getProductName())
                                            .unit(item.getUnit()).build()
                                           ).collect(Collectors.toList());
        return productVOList;

    }

    public ProductVO findByProductId(Integer id) {
        Optional<ProductPO> byId = productRepository.findById(id);
        if (!byId.isPresent()){
            return  null;
        }
        ProductPO productPO = byId.get();
        ProductVO productVo = ProductVO.builder().id(productPO.getId()).unit(productPO.getUnit()).productName(productPO.getProductName())
                .price(productPO.getPrice())
                .pictureUrl(productPO.getPictureUrl()).build();
        return productVo;
    }
}
