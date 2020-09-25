package com.twuc.shopping.service;

import com.twuc.shopping.po.ProductPO;
import com.twuc.shopping.repository.ProductRepository;
import com.twuc.shopping.vo.ProductVO;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import java.math.BigDecimal;
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

    public boolean  addProduct(ProductVO productVO) {
        ProductPO byProductName = productRepository.findByProductName(productVO.getProductName());
        if (byProductName != null){
            return false;
        }
        ProductPO buildProduct = ProductPO.builder().pictureUrl(productVO.getPictureUrl())
                .price(productVO.getPrice())
                .productName(productVO.getProductName())
                .unit(productVO.getUnit()).build();
        productRepository.save(buildProduct);
        return true;
    }
}
