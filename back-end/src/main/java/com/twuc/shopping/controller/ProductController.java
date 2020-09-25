package com.twuc.shopping.controller;

import com.twuc.shopping.service.ProductService;
import com.twuc.shopping.vo.ProductVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @Author: xqc
 * @Date: 2020/9/25 - 09 - 25 - 14:08
 * @Description: com.twuc.shopping.controller
 * @version: 1.0
 */
@RestController
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping("/products")
    public ResponseEntity<List<ProductVO>> getProductList(){
        List<ProductVO> all = productService.findAll();
        return ResponseEntity.ok(all);
    }

    @GetMapping("/product/{id}")
    public ResponseEntity<ProductVO> getProductById(@PathVariable Integer id){
        ProductVO byProductId = productService.findByProductId(id);
        return ResponseEntity.ok(byProductId);

    }

    @PostMapping("/product")
    public ResponseEntity addProduct(@RequestBody ProductVO  productVO){
         if (!productService.addProduct(productVO)){
             return ResponseEntity.badRequest().body("商品名称已经存在，请输入新的商品");
        }
        return  ResponseEntity.ok().build();
    }




}
