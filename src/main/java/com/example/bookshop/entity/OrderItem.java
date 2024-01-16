package com.example.bookshop.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class OrderItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int itemId;
    private int quantity;

    @OneToMany(mappedBy = "orderItem")
    private List<Book> books = new ArrayList<>();

    public void addBook(Book book){
        book.setOrderItem(this);
        books.add(book);
    }

    @JoinColumn(name = "order_id_fk")
    @ManyToOne
    private Order order;
}
