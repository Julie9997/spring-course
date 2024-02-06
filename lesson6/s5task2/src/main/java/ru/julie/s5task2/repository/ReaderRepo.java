package ru.julie.s5task2.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.julie.s5task2.model.Reader;

@Repository
public interface ReaderRepo extends JpaRepository<Reader, Long> {
}