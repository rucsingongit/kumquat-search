package com.kumquat.search.filtersearch.service;

import com.kumquat.search.filtersearch.repo.Item;
import com.kumquat.search.filtersearch.repo.ItemsRepo;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class SearchServiceImpl implements SearchService{

    public List<Item> getByBrand(String brandName) {

        List<Item> allItems = ItemsRepo.getItems();
        List<Item> result = new ArrayList<>();
        for(Item eachItem: allItems){
            if(brandName.equals(eachItem.getBrand()))
            {
                result.add(eachItem);
            }
        }

        return result;
    }

    public List<Item> getByColor(String color){

        List<Item> allItems = ItemsRepo.getItems();
        List<Item> result = new ArrayList<>();
        for(Item eachItem: allItems){
            if(color.equals(eachItem.getColor()))
            {
                result.add(eachItem);
            }
        }

        return result;

    }


}
