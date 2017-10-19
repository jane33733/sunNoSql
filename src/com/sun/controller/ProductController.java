
package com.sun.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.Gson;
import com.sun.respose.vo.ProductInfoVO;
import com.sun.service.ProductService;
import com.sun.vo.db.Product;



/**
 * The Class ImpeachController.
 */
@Controller
@RequestMapping(value = "product")
public class ProductController  {

    /** The Constant LOGGER. */
    private static final Logger LOGGER = LoggerFactory.getLogger(ProductController.class);

    /** The product service. */
    @Autowired
    private ProductService productService;
    
    private Gson gson = new Gson();
    
    /**
     * Search.
     *
     * @param statisticsRptQueryVO the statistics rpt query VO
     * @return the exe result VO
     * @throws Exception the exception
     */
    @ResponseBody
    @RequestMapping(value = "addProduct", method = RequestMethod.POST)
    public List<Product> addProduct(@RequestBody Product inputVO) throws Exception {
        LOGGER.info("[addProduct]------ Start ");
        LOGGER.debug("inputVO: {} ", gson.toJson(inputVO) );
        return productService.addProduct(inputVO);
    }
    
    @ResponseBody
    @RequestMapping(value = "getAll", method = RequestMethod.GET)
    public List<ProductInfoVO> search() throws Exception {
        LOGGER.debug("[getAll]------ Start ");
        List<ProductInfoVO> productList = productService.search();
        
        return productList;
    }
    
    
    @ResponseBody
    @RequestMapping(value = "deleteProduct", method = RequestMethod.GET)
    public boolean deleteProduct(String pId) throws Exception {
        LOGGER.debug("[deleteProduct]------ Start, pId={} ", pId);
        return productService.deleteProduct(pId);
    }
    

}
