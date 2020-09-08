package com.codegym.controller;

import com.codegym.model.Category;
import com.codegym.model.Product;
import com.codegym.service.CategoryService;
import com.codegym.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/")
public class HomeController {
    @Autowired
    private ProductService productService;
    @Autowired
    private CategoryService categoryService;

    @RequestMapping(method = RequestMethod.GET)
    public String index(@RequestParam("s") Optional<String> s, Pageable pageable, @RequestParam("page") Optional<String> page, Model model) {
        Page<Product> products;
        Iterable<Category> categories = categoryService.findAll();
        int t = 0;
        if (page.isPresent()) {
            t = Integer.parseInt( page.get() );
        }
        pageable = new PageRequest( t, 4 );
        if (s.isPresent()) {
            products = productService.findAllByNameContaining( s.get(), pageable );
        } else {
            products = productService.findAll( pageable );
        }

        model.addAttribute( "products", products );
        model.addAttribute( "categories",categories );
        return "index";
    }

    @GetMapping("/category/{categoryId}")
    public ModelAndView viewCategory(@PathVariable("categoryId") Long id) {
        Iterable<Category> categories = categoryService.findAll();
        Category category = categoryService.findById( id );
        Iterable<Product> products = productService.findAllByCategory( category );

        ModelAndView modelAndView = new ModelAndView( "index1" );

        modelAndView.addObject( "products", products );
//        modelAndView.addObject( "categories",categories );
        return modelAndView;
    }

    @GetMapping("about")
    public String about() {
        return "about";
    }
    @GetMapping("blog")
    public String blog() {
        return "blog";
    }

    @GetMapping("blog/details")
    public String blogDetail() {
        return "blog_details";
    }
}
