package com.group.libraryapp.service.book;

import com.group.libraryapp.domain.book.Book;
import com.group.libraryapp.domain.book.BookRepository;
import com.group.libraryapp.domain.user.User;
import com.group.libraryapp.domain.user.UserRepositoryV2;
import com.group.libraryapp.domain.user.loanhistory.UserLoanHistory;
import com.group.libraryapp.domain.user.loanhistory.UserLoanHistoryRepository;
import com.group.libraryapp.dto.book.request.BookCreateRequest;
import com.group.libraryapp.dto.book.request.BookLoanRequest;
import com.group.libraryapp.dto.book.request.BookReturnRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class BookService {

    private final BookRepository bookRepository;
    private final UserLoanHistoryRepository userLoanHistoryRepository;
    private final UserRepositoryV2 userRepositoryV2;

    public BookService(BookRepository bookRepository, UserLoanHistoryRepository userLoanHistoryRepository, UserRepositoryV2 userRepositoryV2) {
        this.bookRepository = bookRepository;
        this.userLoanHistoryRepository = userLoanHistoryRepository;
        this.userRepositoryV2 = userRepositoryV2;
    }

    @Transactional
    public void saveBook(BookCreateRequest request) {
        bookRepository.save(new Book(request.getName()));
    }

    @Transactional
    public void loanBook(BookLoanRequest request) {

        //1. 책 정보를 가져온다.
        Book book = bookRepository.findByName(request.getBookName()).orElseThrow(IllegalAccessError::new);

        //2. 대출 기록 정보를 확인해서 대출 중인지 확인한다.
        //3. 만약에 확인 했을 때 대출 중이라면 예외를 발생 시킨다.
        if (userLoanHistoryRepository.existsByBookNameAndIsReturn(book.getName(), false)) {
            throw new IllegalArgumentException("대출 중인 책입니다.");
        }

        //4. 유저 정보를 가져온다.
        User user = userRepositoryV2.findByName(request.getUserName())
                .orElseThrow(IllegalArgumentException::new);
        user.loanBook(book.getName());
    }

    @Transactional
    public void returnBook(BookReturnRequest request) {

        //유저 정보 가져오기
        User user = userRepositoryV2.findByName(request.getUserName())
                .orElseThrow(IllegalArgumentException::new);

        //대출기록 찾기
        UserLoanHistory history = userLoanHistoryRepository.findByUserIdAndBookName(user.getId(), request.getBookName())
                .orElseThrow(IllegalArgumentException::new);

        //대출 기록 반납처리
        history.doReturn();
    }
}