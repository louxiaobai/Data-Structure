package com.service;

import com.pojo.Books;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author lqw
 * @date 2021/11/9-7:42 下午
 */
public interface BookService {


    //增加一本书

    int add(Books books);

    //删除一本书

    int deleteBookById( int id);

    //更新一本书

    int updateBook(Books book);

    //查询一本书

    Books queryBookById(int id);

    //查询全部的书
    List<Books> queryAllBook();

    //根据书籍名字进行查询操作

    Books queryByBookName(String name);
}
