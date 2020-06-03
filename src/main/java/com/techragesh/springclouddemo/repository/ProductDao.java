package com.techragesh.springclouddemo.repository;

import com.techragesh.springclouddemo.model.Product;
import org.springframework.stereotype.Repository;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

@Repository
public class ProductDao  {

    private List<Product> productList;

    public ProductDao() {
        productList = new ArrayList<>();
    }

    public Product findById(BigInteger productId) {
        return productList.stream().filter(product -> product.getProductId().equals(productId)).findAny().orElse(null);
    }

    public List<Product> findAll() {
        return productList;
    }

    public Product add(Product product) {
        productList.add(product);
        return product;
    }

    public boolean delete(BigInteger productId) {
//        return productList.stream().
//                .filter(product -> ! product.getProductId().equals(productId)).collect(Collectors.toList());
        return productList.removeIf(product -> product.getProductId().equals(productId));
    }

    public Product update(Product prod) {
        System.out.println(prod.getProductId());
        productList.stream()
                .filter(product -> product.getProductId().equals(prod.getProductId()))
                .forEach(product -> { product.setProductName(prod.getProductName());});
        return productList.stream().filter(product2 -> product2.getProductId().equals(prod.getProductId())).findAny().orElse(null);
    }
}
