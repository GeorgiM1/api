package com.example.android.api.model;

import java.util.ArrayList;

/**
 * Created by pc on 1/18/2018.
 */

public class BookModel {
    String kind;
    int totalItems;
    ArrayList<Books> items;

    public String getKind() {
        return kind;
    }

    public void setKind(String kind) {
        this.kind = kind;
    }

    public int getTotalItems() {
        return totalItems;
    }

    public void setTotalItems(int totalItems) {
        this.totalItems = totalItems;
    }

    public ArrayList<Books> getBooks() {
        return items;
    }

    public void setBooks(ArrayList<Books> items) {
        this.items = items;
    }
}
