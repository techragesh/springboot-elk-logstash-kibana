package com.techragesh.springclouddemo.controller;

import com.techragesh.springclouddemo.model.Product;
import com.techragesh.springclouddemo.repository.ProductDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.math.BigInteger;
import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {

    @Autowired
    private ProductDao productDao;

    @GetMapping
    public List<Product> findAll() {
        return productDao.findAll();
    }

    @GetMapping("/{id}")
    public Product findById(@PathVariable String id) {
        return productDao.findById(new BigInteger(id));
    }

    @PostMapping
    public Product add(@RequestBody Product product) {
        return productDao.add(product);
    }

    @PutMapping
    public Product update(@RequestBody Product product) {
        return productDao.update(product);
    }

    @DeleteMapping("/{id}")
    public boolean deleteById(@PathVariable String id) {
        return productDao.delete(new BigInteger(id));
    }
}
