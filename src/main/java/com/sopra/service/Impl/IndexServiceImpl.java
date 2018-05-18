package com.sopra.service.Impl;

import com.sopra.dao.IndexDAO;
import com.sopra.service.IndexService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public class IndexServiceImpl implements IndexService {
    private static final Logger logger = Logger.getLogger(IndexService.class);

    @Autowired
    private IndexDAO indexDAO;

    @Override
    public List getAllProduct(){
        logger.info("getAllProduct");
        return indexDAO.getAllProduct();
    }

}
