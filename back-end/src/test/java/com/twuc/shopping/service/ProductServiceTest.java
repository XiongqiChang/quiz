package com.twuc.shopping.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.twuc.shopping.vo.ProductVO;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.List;

import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

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

    @Test
    void shouldAddProduct() throws Exception {

        ProductVO build = ProductVO.builder().pictureUrl("xxxx").unit("碗").productName("麻辣烫").price(10).build();
        ObjectMapper objectMapper = new ObjectMapper();
        String string = objectMapper.writeValueAsString(build);

        mockMvc.perform(post("/product").content(string).contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
        mockMvc.perform(get("/products"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$",hasSize(3)));


    }
}
