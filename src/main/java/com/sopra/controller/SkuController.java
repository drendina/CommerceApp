package com.sopra.controller;

import com.sopra.facade.SkuFacade;
import com.sopra.model.Sku;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.transaction.Transactional;

@Controller
@Transactional
@RequestMapping(value = "/sku")
public class SkuController {
    private static final Logger logger = Logger.getLogger(SkuController.class);

    @Autowired
    private SkuFacade skuFacade;
//    @RequestMapping(value = "/productDetails")
//    public ModelAndView deployHomepage(@RequestParam int idProduct ){
//        logger.info("Deploying productDetailsPage");
//        logger.info(idProduct);
//
//        Sku temp = retrieveSkuById(idProduct);
//        logger.info("Find: " + temp);
//
//        return new ModelAndView("productDetails", "sku" , temp);
//    }
//
//    public Sku retrieveSkuById(int idProduct){
//        return skuFacade.retrieveSkuById(idProduct);
//    }
}
