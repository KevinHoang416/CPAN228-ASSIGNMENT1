package com.cpan228.Assignment1.model;

import java.util.ArrayList;
import java.util.List;

import lombok.Data;

@Data
public class ItemPool {
    private List<Item> items;

    public ItemPool() {
        this.items = new ArrayList<>();
    }

    public void add(Item item) {
        this.items.add(item);
    }
}
