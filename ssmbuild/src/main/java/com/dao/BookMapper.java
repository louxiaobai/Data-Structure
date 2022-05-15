package com.dao;

import com.pojo.Books;
import org.apache.ibatis.annotations.Param;

import java.awt.*;
import java.awt.print.Book;
import java.util.List;

/**
 * @author lqw
 * @date 2021/11/9-5:13 下午
 */
public interface BookMapper {

    //增加一本书

     int add(Books books);

    //删除一本书

    int deleteBookById(@Param("bookId") int id);

    //更新一本书

    int updateBook(Books book);

    //查询一本书

    Books queryBookById(@Param("bookId")int id);

    //查询全部的书
    List<Books> queryAllBook();

    //根据书籍名字进行查询操作

    Books queryByBookName(@Param("bookName") String name);

}