package ru.julie.s5task1.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ru.julie.s5task1.model.Product;
import ru.julie.s5task1.repository.ProductRepository;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class ProductService {

    private final ProductRepository productRepository;

    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    public Product getProductById(Long id) {
        return productRepository.findById(id).orElse(null);
    }

    public Product updateProduct(Product productDetails) {
        Product product = getProductById(productDetails.getId());
        product.setId(productDetails.getId());
        product.setName(productDetails.getName());
        product.setCount(productDetails.getCount());
        product.setQuantity(productDetails.getQuantity());
        return productRepository.save(product);
    }

    public Product createProduct(Product product) {
        return productRepository.save(product);
    }

    public void deleteById(Long id) {
        productRepository.deleteById(id);
    }
}
