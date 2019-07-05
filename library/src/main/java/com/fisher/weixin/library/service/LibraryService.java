package com.fisher.weixin.library.service;

import org.springframework.data.domain.Page;

import com.fisher.weixin.library.domain.Book;
import com.fisher.weixin.library.domain.DebitList;

public interface LibraryService {

	Page<Book> search(String keyword, int pageNumber);

	void add(String id, DebitList debitList);

	void remove(String id, DebitList debitList);
	
}
