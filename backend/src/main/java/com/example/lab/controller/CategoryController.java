package com.example.lab.controller;


import com.example.lab.entity.enums.Category;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:3000/")
@RequestMapping(value = "/api/")
public class CategoryController {

    @GetMapping("/categories")
    public List<Category> getCategories() {
        return Arrays.stream(Category.values()).toList();
    }
}
