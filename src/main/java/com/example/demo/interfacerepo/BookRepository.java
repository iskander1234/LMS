package com.example.demo.interfacerepo;

import com.example.demo.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {
    Book findByIdAndDeletedAtIsNull(long id);
    Book findByAuthorAndDeletedAtIsNull(String author);
    Book findByGenreAndDeletedAtIsNull(String genre);
    Book findByNameAndDeletedAtIsNull(String name);
    Book findByPriceAndDeletedAtIsNull(int price);
    List<Book> findAllByDeletedAtIsNull();
    List<Book> findAllByLibraryIdAndDeletedAtIsNull(long id);
}
