package com.sopra.controller;

import com.sopra.dao.CartDAO;
import com.sopra.data.UserData;
import com.sopra.facade.*;
import com.sopra.model.SkuCart;
import com.sopra.model.SkuOrder;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Controller
@Transactional
@RequestMapping(value = "/order")
public class OrderController {

    private static final Logger logger = Logger.getLogger(OrderController.class);

    @Autowired
    private UserFacade userFacade;

    @Autowired
    private OrderFacade orderFacade;

    @Autowired
    private CartFacade cartFacade;

    @Autowired
    private SkuOrderFacade skuOrderFacade;

    @Autowired
    private StockFacade stockFacade;

    @Autowired
    private CartDAO cartDAO;

    @RequestMapping(value = "/createOrder")
    public void createOrder(HttpSession session){
//      AGGIUNGO NUOVO ORDINE NEL DB
        int idUser = ((UserData) session.getAttribute("loggedUser")).getIdUser();
        Date today = new Date();
        String nowDate = today.toString();
        logger.info("La data di oggi e': " + nowDate);
        int idAddress = userFacade.getIdAddressByIdUser(idUser);
        int idOrder = orderFacade.insertOrder(nowDate, idUser, idAddress);
        
//      AGGIUNGO ALL'ORDINE I PRODOTTI ACQUISTATI
        List prodList = cartDAO.getProductList(idUser); //Lista SkuCart
        int size = prodList.size();
        List prodListOrder = new ArrayList();
        for(int i = 0; i < size; i++){
          SkuCart temp = (SkuCart) prodList.get(i);
          int idSkuTemp = temp.getIdSku();
          SkuOrder skuOrderTemp = new SkuOrder(idSkuTemp, idOrder);
          prodListOrder.add(skuOrderTemp);
          logger.info(skuOrderTemp.toString());
        }

        logger.info(prodList + "  " + prodListOrder);
        skuOrderFacade.insertItems(prodListOrder);
//        cartFacade.deleteItems(prodList);

        int[] stockUpdate = new int[size];

//      TODO: 3 - AGGIORNARE STOCK
        //creo array contenente i valori degli id da cancellare
        for(int i = 0; i < size; i++){
            SkuCart temp = (SkuCart) prodList.get(i);
            stockUpdate[i] = temp.getIdSku();
        }
        logger.info(stockUpdate);
        stockFacade.updateStock(stockUpdate);

//      CANCELLARE ELEMENTI DAL CARRELLO
        cartFacade.deleteItems(prodList);
        logger.info("Finish");

    }
}
