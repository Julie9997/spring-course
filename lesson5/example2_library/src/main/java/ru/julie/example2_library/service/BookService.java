package ru.julie.example2_library.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ru.julie.example2_library.model.Book;
import ru.julie.example2_library.repository.BookRepository;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class BookService {

    private final BookRepository bookRepository;

    /**
     * Получение списка всех книг
     * @return список книг
     */
    public List<Book> getAllBooks() {
         return bookRepository.findAll();
    }

    /**
     * Поиск книг по id
     * @param id
     * @return
     */
    public Optional<Book> getBookById(Long id) {
        return bookRepository.findById(id);
    }

    /**
     * Создание книги
     * @param book
     * @return созданная книга
     */
    public Book createBook(Book book) {
        return bookRepository.save(book);
    }

    /**
     * Обновление книги
     * @param id
     * @param bookDetails
     * @return обновленная книга
     */
    public Book ubdateBook(Long id, Book bookDetails) {
        Optional<Book> optionalBook = bookRepository.findById(id);
        if (optionalBook.isPresent()) {
            Book book = optionalBook.get();
            book.setId(bookDetails.getId());
            book.setTitle(bookDetails.getTitle());
            book.setAuthor(bookDetails.getAuthor());
            book.setPublicationYear(bookDetails.getPublicationYear());
            return bookRepository.save(book);
        } else {
            throw new IllegalArgumentException("Book not found eith id: " + id);
        }
    }

    /**
     * удаление книги по id
     * @param id
     */
    public void deleteBook(Long id) {
        bookRepository.deleteById(id);
    }

}

