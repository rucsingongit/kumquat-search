package com.kumquat.search.filtersearch.service;

import com.kumquat.search.filtersearch.repo.Item;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface SearchService {

    public List<Item> getByBrand(String brandName);

    public List<Item> getByColor(String color);



}
