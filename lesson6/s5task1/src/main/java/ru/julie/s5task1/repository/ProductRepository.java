package ru.julie.s5task1.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.julie.s5task1.model.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
}
