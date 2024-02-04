package ru.julie.example2_library.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.julie.example2_library.model.Book;

public interface BookRepository extends JpaRepository<Book, Long> {

}
