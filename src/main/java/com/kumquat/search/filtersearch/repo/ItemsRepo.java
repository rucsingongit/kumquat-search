package com.kumquat.search.filtersearch.repo;

import java.util.ArrayList;
import java.util.List;

public class ItemsRepo {

    public static List<Item> itemslist = new ArrayList<Item>();

    static {
        itemslist.add(new Item("dresses","Gucci","yellow", 2272.00));
        itemslist.add(new Item("dresses","Gucci","red", 3372.00));
        itemslist.add(new Item("dresses","Gucci","green", 5572.00));

        itemslist.add(new Item("dresses","Marni","brown", 999.00));
        itemslist.add(new Item("dresses","Bottega Veneta","black", 2200.00));
    }

    public static List<Item> getItems(){
        return itemslist;
    }

}
