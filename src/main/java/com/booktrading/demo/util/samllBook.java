package com.booktrading.demo.util;

public class samllBook implements Comparable<samllBook>{
    public int bookid;
    public int value;


    public samllBook(int bookid) {
        this.bookid = bookid;
    }

    public int compareTo(samllBook samllbook)
    {
        return samllbook.value-this.value;
    }
}
