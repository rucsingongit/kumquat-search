package com.kumquat.search.filtersearch;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.kumquat.search.filtersearch.controller.SearchController;
import com.kumquat.search.filtersearch.repo.Item;
import com.kumquat.search.filtersearch.service.SearchServiceImpl;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;
import org.mockito.Mockito;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.mockito.Mockito.when;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;



@RunWith(SpringRunner.class)
@SpringBootTest(classes = SearchController.class)
@AutoConfigureMockMvc
public class SearchControllerTest {


    private ObjectMapper mapper = new ObjectMapper();

    @Autowired
    private MockMvc mockMvc;


    @MockBean
    SearchServiceImpl service;

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }

    /*As a customer, I can filter search results by brand.*/

    @Test
    public void getItemByBrandNameTest() throws Exception {
        Item item = new Item("dresses","Gucci","yellow", 2272.00);
        List<Item> itemslist = new ArrayList<Item>();
        itemslist.add(item);

        when(service.getByBrand(anyString())).thenReturn(itemslist);

        mockMvc.perform(MockMvcRequestBuilders
                .get("/filter/get/brand/{brandName}", anyString())
                .accept(MediaType.APPLICATION_JSON_UTF8))
//                .andExpect(status().isOk())
//                .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8))
                .andDo(print())
                .andReturn();

        verify(service, Mockito.times(1)).getByBrand(anyString());
    }

   /* @Test
    public void getItemByColorTest() throws Exception {
        Item item = new Item("dresses","Gucci","yellow", 2272.00);
        List<Item> itemslist = new ArrayList<Item>();
        itemslist.add(item);

        when(service.getByColor(anyString())).thenReturn(itemslist);

        mockMvc.perform(MockMvcRequestBuilders
                .get("/filter/get/color/{color}", anyString())
                .accept(MediaType.APPLICATION_JSON_UTF8))
 //               .andExpect(status().isOk())
 //               .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8))
                .andDo(print())
                .andReturn();

        verify(service, Mockito.times(1)).getByColor(anyString());
    }*/


}
