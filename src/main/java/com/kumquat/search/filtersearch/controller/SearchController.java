package com.kumquat.search.filtersearch.controller;

import com.kumquat.search.filtersearch.repo.Item;
import com.kumquat.search.filtersearch.service.SearchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.List;

@RestController
@RequestMapping("/filter")
public class SearchController {



    @Autowired
    private SearchService searchService;

    @GetMapping(value="/get/brand/{brandName}")
    public ResponseEntity<List<Item>> getItemByBrandName(@PathVariable String brandName) {

            List<Item> itemList = searchService.getByBrand(brandName);
            if(!itemList.isEmpty()) {
                return new ResponseEntity<List<Item>>(itemList, HttpStatus.OK);
            } else {
                return new ResponseEntity<List<Item>>(itemList, HttpStatus.NOT_FOUND);
            }
        }


    @GetMapping(value="/get/color/{color}")
    public ResponseEntity<List<Item>> getItemByColor(@PathVariable String color) {

        List<Item> itemList = searchService.getByColor(color);
        if(!itemList.isEmpty()) {
            return new ResponseEntity<List<Item>>(itemList, HttpStatus.OK);
        } else {
            return new ResponseEntity<List<Item>>(itemList, HttpStatus.NOT_FOUND);
        }
    }

}
