package ru.julie.s4task4.services;

import org.springframework.stereotype.Service;
import ru.julie.s4task4.models.Product;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductService {
    List<Product> products = new ArrayList<>();

    public void addProduct(Product product) {
        products.add(product);
    }

    public List<Product> getAllProducts() {
        return products;
    }
}
