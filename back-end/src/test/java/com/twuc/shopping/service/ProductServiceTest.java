package com.twuc.shopping.service;

import com.twuc.shopping.vo.ProductVO;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import java.util.List;

import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * @Author: xqc
 * @Date: 2020/9/25 - 09 - 25 - 14:22
 * @Description: com.twuc.shopping.service
 * @version: 1.0
 */
@SpringBootTest
@AutoConfigureMockMvc
class ProductServiceTest {

    @Autowired
    private ProductService productService;

    @Autowired
    private MockMvc mockMvc;
    @Test
    void findAll() throws Exception {
        List<ProductVO> all = productService.findAll();
        mockMvc.perform(get("/products"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$",hasSize(2)));

    }

    @Test
    void findById() throws Exception {
        mockMvc.perform(get("/product/" + 1))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.productName",is("可乐")))
                .andExpect(jsonPath("$.price",is(2)));

    }
}
