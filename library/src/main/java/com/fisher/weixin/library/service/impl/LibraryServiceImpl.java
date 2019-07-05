package com.fisher.weixin.library.service.impl;

import java.util.LinkedList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.fisher.weixin.library.domain.Book;
import com.fisher.weixin.library.domain.DebitList;
import com.fisher.weixin.library.repository.BookRepository;
import com.fisher.weixin.library.service.LibraryService;

@Service
public class LibraryServiceImpl implements LibraryService {
	
	@Autowired
	private BookRepository bookRepository;

	@Override
	public Page<Book> search(String keyword, int pageNumber) {

		// 创建分页条件，页码从外面（页面）传入，每页固定最多显示11条数据
		Pageable pageable = PageRequest.of(pageNumber, 11);

		Page<Book> page;
		if (StringUtils.isEmpty(keyword)) {
			// 没有查询的关键字
			// where disabled == false
			page = this.bookRepository.findByDisabledFalse(pageable);
		} else {
			// 有关键字，要根据关键字来查询数据
			// where name like '%' + keyword + '%' and disabled == false
			page = this.bookRepository.findByNameContainingAndDisabledFalse(keyword, pageable);
		}

		return page;
	}

	@Override
	public void add(String id, DebitList debitList) {
		// 调用方法返回的对象，都可能为null，所以要养成一个习惯：尽量检查一下别人传递过来或者返回的对象是否为null
		if (debitList.getBooks() == null) {
			debitList.setBooks(new LinkedList<>());
		}
		// 1.检查debitList里面是否有id相同的图书，如果有则不能加入
		boolean exists = false;
		for (Book b : debitList.getBooks()) {
			if (b.getId().equals(id)) {
				exists = true;
				break;
			}
		}
		if (!exists) {
//			// 2.根据id查询图书
//			this.bookRepository
//					// 根据id查询对象，可能找不到
//					.findById(id)
//					// 如果存在，则执行括号里面的代码
//					.ifPresent(book -> {
//						// 3.加入借阅列表中
//						debitList.getBooks().add(book);
//					});

//			// 2.根据id查询图书
//			this.bookRepository
//					// 根据id查询对象，可能找不到
//					.findById(id)
//					// 如果存在，则执行括号里面的代码
//					.ifPresent(new Consumer<Book>() {
//						@Override
//						public void accept(Book book) {
//							debitList.getBooks().add(book);
//						}
//					});

			// 2.根据id查询图书
			this.bookRepository
					// 根据id查询对象，可能找不到
					.findById(id)
					// 如果存在，则执行括号里面的代码
					// 3.加入借阅列表中
					.ifPresent(debitList.getBooks()::add);
		}
	}

	@Override
	public void remove(String id, DebitList debitList) {
		// TODO Auto-generated method stub
		debitList.getBooks()
		// 把集合转换为流（Stream）对象，可以用于流式编程。
		.stream()
		// 过滤需要的数据，需要找到图书的id跟传入的id参数相同的图书
		// filter在没有执行find之前不会计算（在函数式编程里面这个叫做【延迟计算】）
		.filter(book -> book.getId().equals(id))
		// 找到过滤之后的第一个结果
		.findFirst()
		// 从集合里面删除找到的图书
		.ifPresent(debitList.getBooks()::remove);
	}
	
}
