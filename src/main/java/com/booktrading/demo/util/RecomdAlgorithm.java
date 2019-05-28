package com.booktrading.demo.util;

import com.booktrading.demo.Model.Book;
import com.booktrading.demo.Model.Record;
import com.booktrading.demo.Model.User;

import java.util.*;

public class RecomdAlgorithm {

    public List<Integer> AlgorithmRecommd(List<Book> books)
    {
        List<Integer> bookList = new ArrayList<>();
        Iterator<Book> it = books.listIterator();
        PriorityQueue<samllBook> bookPriorityQueue = new PriorityQueue<>(5);
        while (it.hasNext())
        {
            Book book = it.next();
            samllBook samllbook = new samllBook(book.getBookid());
            samllbook.value = (int)(book.getNormalcost()*10/book.getCost());
            bookPriorityQueue.add(samllbook);
        }
        int len = bookPriorityQueue.size();
        for(int i = 0;i<len;i++)
        {
            bookList.add(bookPriorityQueue.poll().bookid);
        }
        return bookList;
    }

    public RecomdAlgorithm() {
    }
}
