package com.group.libraryapp.repository.book;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;

@Primary //우선권 결정
@Repository
public class BookMySqlRepository implements BookRepository {

    @Override
    public void saveBook() {

    }
}
