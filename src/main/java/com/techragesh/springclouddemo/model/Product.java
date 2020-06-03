package com.techragesh.springclouddemo.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.math.BigInteger;

@Data
@AllArgsConstructor
public class Product {

    private BigInteger productId;
    private String productName;
    private String productDescription;
}
