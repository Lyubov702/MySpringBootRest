package com.mycode.model;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "purchase")
public class Purchase {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "date")
    private Date date;

    @Column(name = "seller")
    private int seller;

    @Column(name = "customerid")
    private int customerId;

    @Column(name = "bookid")
    private int bookId;

    @Column(name = "number")
    private int number;

    @Column(name = "sum")
    private int sum;

//-------------------------------------------------






    /*  @OneToMany(mappedBy = "purchase", cascade = CascadeType.ALL, orphanRemoval = true)
        private List<Book> books;

        @OneToMany(mappedBy = "purchase", cascade = CascadeType.ALL, orphanRemoval = true)
        private List<Customer> customers;

        @OneToMany(mappedBy = "purchase", cascade = CascadeType.ALL, orphanRemoval = true)
        private List<Shop> shops;*/

    protected Purchase() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public int getSum() {
        return sum;
    }

    public void setSum(int sum) {
        this.sum = sum;
    }

    public int getSeller() {
        return seller;
    }

    public void setSeller(int seller) {
        this.seller = seller;
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public int getBookId() {
        return bookId;
    }

    public void setBookId(int bookId) {
        this.bookId = bookId;
    }

    @Override
    public String toString() {
        return "Purchase{" +
                "id=" + id +
                ", date=" + date +
                ", number=" + number +
                ", sum=" + sum +
                ", seller=" + seller +
                ", customerId=" + customerId +
                ", bookId=" + bookId +
                '}';
    }
}
