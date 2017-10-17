
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
    
    /**
     * Search.
     *
     * @param statisticsRptQueryVO the statistics rpt query VO
     * @return the exe result VO
     * @throws Exception the exception
     */
    @ResponseBody
    @RequestMapping(value = "getByPrice", method = RequestMethod.POST)
    public List<Product> getByPrice(@RequestBody Product product) throws Exception {
        // LOGGER.debug("[getByPrice]------ Start "+queryVO.getPriceBottom());
//        System.out.println("[getByPrice]------ Start "+queryVO.getPriceBottom());
    	productService.addProduct(product);
        return null;
    }
    
    @ResponseBody
    @RequestMapping(value = "getAll", method = RequestMethod.GET)
    public List<ProductInfoVO> search() throws Exception {
        LOGGER.debug("[getAll]------ Start ");
        List<ProductInfoVO> productList = productService.search(1);
        
        return productList;
    }
    

}
