package com.fisher.weixin.library.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.fisher.weixin.library.domain.Book;

@Repository
public interface BookRepository extends JpaRepository<Book, String>{

	Page<Book> findByDisabledFalse(Pageable pageable);

	Page<Book> findByNameContainingAndDisabledFalse(String keyword, Pageable pageable);

}
