package com.twuc.shopping.vo;

import lombok.Builder;
import lombok.Data;

import javax.persistence.Column;

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

    private Integer price;


    private String unit;


    private  String pictureUrl;
}
