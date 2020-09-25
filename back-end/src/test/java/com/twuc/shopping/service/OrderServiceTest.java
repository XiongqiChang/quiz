package com.twuc.shopping.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.twuc.shopping.vo.OrderVO;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.hasSize;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * @Author: xqc
 * @Date: 2020/9/25 - 09 - 25 - 15:15
 * @Description: com.twuc.shopping.service
 * @version: 1.0
 */
@SpringBootTest
@AutoConfigureMockMvc
class OrderServiceTest {

    @Autowired
    private  OrderService orderService;
    @Autowired
    private MockMvc mockMvc;

    @Test
    void addOrderVO() throws Exception {
        OrderVO build = OrderVO.builder().orderAmount(2).orderName("可乐").orderPrice(1).orderUnit("瓶").build();
        ObjectMapper objectMapper = new ObjectMapper();
        String string = objectMapper.writeValueAsString(build);
        mockMvc.perform(post("/order").content(string).contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());

    }

    @Test
    void getAll() throws Exception {
        mockMvc.perform(get("/order"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$",hasSize(1)));
    }

    @Test
    void deleteById() throws Exception {
        mockMvc.perform(delete("/order/" + 122))
                .andExpect(status().isBadRequest());

    }
    @Test
    void deleteByIdSuccess() throws Exception {
        mockMvc.perform(delete("/order/" + 2))
                .andExpect(status().isOk());
    }
}
