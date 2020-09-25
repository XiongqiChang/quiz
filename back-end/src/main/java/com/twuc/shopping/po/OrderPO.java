package com.twuc.shopping.po;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigDecimal;

/**
 * @Author: xqc
 * @Date: 2020/9/25 - 09 - 25 - 13:59
 * @Description: com.twuc.shopping.po
 * @version: 1.0
 */
@Entity
@Table(name = "product_order")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class OrderPO {

    @GeneratedValue
    @Id
    private  Integer id;

    @Column(name = "order_name")
    private  String orderName;

    @Column(name = "order_price")
    private BigDecimal orderPrice;
    @Column(name = "order_amount")

    private Integer orderAmount;

    @Column(name = "order_unit")
    private String orderUnit;


}
