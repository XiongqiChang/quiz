package com.twuc.shopping.service;

import com.twuc.shopping.po.OrderPO;
import com.twuc.shopping.repository.OrderRepository;
import com.twuc.shopping.vo.OrderVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * @Author: xqc
 * @Date: 2020/9/25 - 09 - 25 - 15:04
 * @Description: com.twuc.shopping.service
 * @version: 1.0
 */
@Service
public class OrderService {
    @Autowired
    private OrderRepository orderRepository;

    public void addOrderVO(OrderVO orderVO) {
        OrderPO byOrderName = orderRepository.findByOrderName(orderVO.getOrderName());
        if (byOrderName != null){
            byOrderName.setOrderAmount(byOrderName.getOrderAmount() + orderVO.getOrderAmount());
            orderRepository.save(byOrderName);
            return;
        }
        OrderPO buildOrderPo = OrderPO.builder().orderName(orderVO.getOrderName()).orderAmount(orderVO.getOrderAmount())
                .orderPrice(orderVO.getOrderPrice()).orderUnit(orderVO.getOrderUnit()).build();
        orderRepository.save(buildOrderPo);


    }


    public List<OrderVO> findAll() {

        List<OrderPO> all = orderRepository.findAll();
        List<OrderVO> collectOrderList = all.stream().map(item -> OrderVO.builder().orderPrice(item.getOrderPrice()).orderAmount(item.getOrderAmount())
                .orderName(item.getOrderName()).orderUnit(item.getOrderUnit()).id(item.getId()).build()
        ).collect(Collectors.toList());

        return  collectOrderList;
    }

    public boolean deleteOrderById(Integer id) {
        Optional<OrderPO> byId = orderRepository.findById(id);
        if (!byId.isPresent()){
            return  false;
        }
        orderRepository.deleteById(id);
        return true;
    }
}
