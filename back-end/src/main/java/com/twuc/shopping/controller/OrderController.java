package com.twuc.shopping.controller;

import com.twuc.shopping.service.OrderService;
import com.twuc.shopping.vo.OrderVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

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

    @DeleteMapping("/order/{id}")
    public ResponseEntity deleteById(@PathVariable Integer id){
        boolean flag = orderService.deleteOrderById(id);
        if (!flag){
            return  ResponseEntity.badRequest().body("“订单删除失败，请稍后再试");
        }
        return  ResponseEntity.ok().body("删除成功");
    }
}
