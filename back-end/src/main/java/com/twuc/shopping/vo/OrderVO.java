package com.twuc.shopping.vo;

import lombok.Builder;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.math.BigDecimal;

/**
 * @Author: xqc
 * @Date: 2020/9/25 - 09 - 25 - 15:03
 * @Description: com.twuc.shopping.vo
 * @version: 1.0
 */
@Data
@Builder
public class OrderVO {

    private  Integer id;


    private  String orderName;


    private BigDecimal orderPrice;


    private Integer orderAmount;


    private String  orderUnit;

}
