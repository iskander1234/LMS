package com.example.demo.services;

import com.example.demo.interfacerepo.BookRepository;
import com.example.demo.model.Book;
import com.example.demo.model.Order;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class BookService {
        private final BookRepository bookRepo;

        public BookService(BookRepository bookRepo) {
            this.bookRepo = bookRepo;
        }

        public Optional<Book> getId(Long id) {
            return bookRepo.findById(id);
        }

        public Book add(Book book) {
            return bookRepo.save(book);
        }

        public List<Book> listAvailableBooks() {
            List<Book> books = new ArrayList<Book>();
            Book book = new Book();
            Order order = new Order();
            if(order.getBook().getId() == book.getId()) {
                System.out.println("this book is not available");
            } else {
                books.add(book);
            }
            return books;
        }

        public Book addAuthor(Book bookRequestAuthor) {
            Book book = new Book();
            book.setAuthor(bookRequestAuthor.getAuthor());
            return bookRepo.save(book);
        }

        public Book addGenre(Book bookRequestGenre) {
            Book book = new Book();
            book.setGenre(bookRequestGenre.getGenre());
            return bookRepo.save(book);
        }

        public Book findById(Long id) {
            return bookRepo.findByIdAndDeletedAtIsNull(id);
        }

        public Book findByAuthor(String author) {
            return bookRepo.findByAuthorAndDeletedAtIsNull(author);
        }

        public Book findByGenre(String genre) {
            return bookRepo.findByGenreAndDeletedAtIsNull(genre);
        }

        public Book findByName(String name) {
            return bookRepo.findByNameAndDeletedAtIsNull(name);
        }

        public Book findByPrice(int price) {
            return bookRepo.findByPriceAndDeletedAtIsNull(price);
        }

        public String updateGenre(Long id, String genre) {
            Book book = bookRepo.findByIdAndDeletedAtIsNull(id);
            book.setGenre(genre);
            bookRepo.save(book);
            return "updated genre";
        }

        public String updatePrice(Long id, int price) {
            Book book = bookRepo.findByIdAndDeletedAtIsNull(id);
            book.setPrice(price);
            bookRepo.save(book);
            return "price updated";
        }

        public String updateAll(Long id, String author, String genre, String name, int price) {
            Book book = bookRepo.findByIdAndDeletedAtIsNull(id);
            book.setAuthor(author);
            book.setGenre(genre);
            book.setName(name);
            book.setPrice(price);
            bookRepo.save(book);
            return "updated all";
        }

        public String delete(Long id) {
            Date date = new Date();
            Book book = bookRepo.findByIdAndDeletedAtIsNull(id);
            book.setDeletedAt(date);
            bookRepo.save(book);
            return "deleted";
        }

        public List<Book> findAll() {
            return bookRepo.findAllByDeletedAtIsNull();
        }

        public List<Book> findAllByLibrary(Long id) {
            return bookRepo.findAllByLibraryIdAndDeletedAtIsNull(id);
        }
}
