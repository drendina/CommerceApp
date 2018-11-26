package com.sopra.controller;

import com.sopra.facade.ProductFacade;
import com.sopra.facade.SkuFacade;
import com.sopra.form.LoginForm;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.transaction.Transactional;
import java.util.List;

@Controller
@Transactional
@RequestMapping(value = "/product")
public class ProductController {

    private static final Logger logger = Logger.getLogger(ProductController.class);

    @Autowired
    private ProductFacade productFacade;


    @Autowired
    private SkuFacade skuFacade;
    @RequestMapping(value = "/productDetails")
    public ModelAndView deployProductHomepage(@RequestParam int idProduct, @ModelAttribute("login") LoginForm loginForm ){
        logger.info("Deploying productDetailsPage");
        logger.info("idProduct: " + idProduct);

        ModelAndView mv = new ModelAndView("productDetailsPage");
        mv.addObject("productData", productFacade.getProductDataById(idProduct));
        mv.addObject("listaSku", skuFacade.getSkuDataList(idProduct));
        mv.addObject("login", loginForm);
        return mv;
    }

    @RequestMapping(value = "/getSizes")
    public @ResponseBody List getAllSizes(int idProduct){
        logger.info("Getting sizes");
         List skuList = skuFacade.getSkuDataList(idProduct);
         logger.info("Lista sku 4 js " + skuList);
         return skuList;
    }
}

