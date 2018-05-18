package com.sopra.facade.Impl;

import com.sopra.facade.IndexFacade;
import com.sopra.service.IndexService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public class IndexFacadeImpl implements IndexFacade {
    private static final Logger logger = Logger.getLogger(IndexFacade.class);

    @Autowired
    private IndexService indexService;
    @Override
    public List getAllProduct(){
        logger.info("getAllProduct");
        return indexService.getAllProduct();
    }
}
