package com.app.repository;

import org.springframework.data.repository.CrudRepository;

import com.app.model.Book;

public interface BookRepository extends CrudRepository<Book , Integer>{

}
