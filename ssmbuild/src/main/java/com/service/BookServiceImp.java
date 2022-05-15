package com.service;

import com.dao.BookMapper;
import com.pojo.Books;

import java.util.List;

/**
 * @author lqw
 * @date 2021/11/9-7:42 下午
 */
public class BookServiceImp implements BookService {

    //service层调用 dao层

    private BookMapper bookMapper;

    public void setBookMapper(BookMapper bookMapper) {
        this.bookMapper = bookMapper;
    }

    public int add(Books books) {


        return bookMapper.add(books);

    }

    public int deleteBookById(int id) {

        return bookMapper.deleteBookById(id);

    }

    public int updateBook(Books book) {
        return bookMapper.updateBook(book);
    }

    public Books queryBookById(int id) {
        return bookMapper.queryBookById(id);
    }

    public List<Books> queryAllBook() {

        return bookMapper.queryAllBook();
    }

    public Books queryByBookName(String name) {

        return bookMapper.queryByBookName(name);

    }
}