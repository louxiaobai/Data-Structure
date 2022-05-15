package com.controller;

import com.pojo.Books;
import com.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.awt.print.Book;
import java.util.ArrayList;
import java.util.List;


/**
 * @author lqw
 * @date 2021/11/10-10:25 上午
 */
@Controller
@RequestMapping("/book")
public class BookController {

    //controller层调用service层
    @Autowired
    @Qualifier("BookServiceImp")
    private BookService bookService;
    private List<Book> books;

    //查询全部的数据,并且返回到一个书籍展示页面

    @RequestMapping("/allBook")
    public String list(Model model){

        List<Books> list=bookService.queryAllBook();
        model.addAttribute("list", list);
        return "allbook";


    }

    //跳转到增加书籍页面
    @RequestMapping("/toAddBook")
    public String toAddPaper(){

        return "addBook";
    }

    //添加书籍的请求
    @RequestMapping("/addBook")
    public String addBook(Books books){
        System.out.println("addBook=>"+books);
        bookService.add(books);
        return "redirect:/book/allBook";
    }

    //跳转到修改信息的页面
    @RequestMapping("/toUpdate")
    public String toUpdatePaper(int id,Model model){

        Books books = bookService.queryBookById(id);
        model.addAttribute("QBook", books);
        return "updateBook";

    }
    @RequestMapping("/updateBook")
    public String updateBook(Books books){


        System.out.println(books);

        int i = bookService.updateBook(books);

        if (i>0){

            System.out.println("更新book成功"+books);
        }else {

            System.out.println("修改失败");
        }

        return "redirect:/book/allBook";

    }
    @RequestMapping("/deleteBook/{bookId}")
    public String deleteBook(@PathVariable("bookId") int id){


         bookService.deleteBookById(id);

        return "redirect:/book/allBook";

    }

    @RequestMapping("/querBookByName")
    public String  querBookByName(String querBookName,Model model){


        System.out.println(querBookName);
        Books books = bookService.queryByBookName(querBookName);

        System.out.println(books);

        List<Books> list = new ArrayList<Books>();

        if (books==null){
            model.addAttribute("error","查询无果");
            list=bookService.queryAllBook();
        }else{

            list.add(books);
        }

        model.addAttribute("list", list);

        return "allbook";

    }







}