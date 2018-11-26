package com.sopra.controller;

import com.sopra.facade.ProductFacade;
import com.sopra.form.LoginForm;
import com.sopra.service.ProductService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.transaction.Transactional;
import java.util.List;

@Controller
@Transactional
@RequestMapping(value = "/category")
public class CategoryPageController {

    private static final Logger logger = Logger.getLogger(CategoryPageController.class);

    @Autowired
    private ProductService productService;

    @Autowired
    private ProductFacade productFacade;

    @RequestMapping(value = {"/", ""}, method = RequestMethod.GET)
    public ModelAndView deployPage(@ModelAttribute("login") LoginForm loginForm, @RequestParam String gender, @RequestParam String category){
        logger.info("gender: "+gender+" category: "+category);
        logger.info("Deploying CategoryPage");
        //return new ModelAndView("categoryPage").addObject("categoryList", productService.getListProductByGenderAndCategory(gender,category));
        return new ModelAndView("categoryPage").addObject("genderInPage", gender).addObject("categoryInPage", category);
    }

    @RequestMapping(value = "/getAllProduct", method = RequestMethod.GET)
    public @ResponseBody List getAllProduct(@RequestParam String gender, @RequestParam String category){
        logger.info("Getting product list from database");
        List list = productFacade.getAllProductsByCategoryAndGender(gender, category);
        logger.info("List is: "+ list);
        return list;
    }
}
