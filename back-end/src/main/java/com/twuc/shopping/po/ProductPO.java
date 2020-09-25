package com.twuc.shopping.po;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

/**
 * @Author: xqc
 * @Date: 2020/9/25 - 09 - 25 - 13:53
 * @Description: com.twuc.shopping.po
 * @version: 1.0
 */
@Entity
@Table(name = "product")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ProductPO {

    @GeneratedValue
    @Id
    private Integer id;

    @Column(name = "product_name")
    private String productName;

    @Column(name = "product_price")
    private Integer price;

    @Column(name = "product_unit")
    private String unit;

    @Column(name = "picture_url")
    private  String pictureUrl;
}
