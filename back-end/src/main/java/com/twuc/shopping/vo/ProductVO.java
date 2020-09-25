package com.twuc.shopping.vo;

import lombok.Builder;
import lombok.Data;

import javax.persistence.Column;
import java.math.BigDecimal;

/**
 * @Author: xqc
 * @Date: 2020/9/25 - 09 - 25 - 14:10
 * @Description: com.twuc.shopping.vo
 * @version: 1.0
 */
@Data
@Builder
public class ProductVO {

    private Integer id;

    private String productName;


    private BigDecimal price;


    private String unit;


    private  String pictureUrl;
}
