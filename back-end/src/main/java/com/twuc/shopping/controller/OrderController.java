package com.twuc.shopping.controller;

import com.sun.org.apache.regexp.internal.RE;
import com.twuc.shopping.service.OrderService;
import com.twuc.shopping.vo.OrderVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

/**
 * @Author: xqc
 * @Date: 2020/9/25 - 09 - 25 - 15:03
 * @Description: com.twuc.shopping.controller
 * @version: 1.0
 */
@Controller
public class OrderController {

    @Autowired
    private OrderService orderService;


    @PostMapping("/order")
    public ResponseEntity addOrder(@RequestBody OrderVO orderVO){
        orderService.addOrderVO(orderVO);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/order")
    public  ResponseEntity<List<OrderVO>> orderList(){
        List<OrderVO> all = orderService.findAll();
        return  ResponseEntity.ok(all);
    }



}
