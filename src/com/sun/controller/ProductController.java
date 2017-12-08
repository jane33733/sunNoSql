
package com.sun.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.Gson;
import com.sun.service.ProductService;
import com.sun.service.impl.ProductServiceImpl;
import com.sun.vo.db.Product;
import com.sun.vo.output.ProductInfoVO;



@Controller
@RequestMapping(value = "product")
public class ProductController  {

    private static final Logger LOGGER = LoggerFactory.getLogger(ProductController.class);

    private ProductService productService = new ProductServiceImpl();
    
    private Gson gson = new Gson();
    
    @ResponseBody
    @RequestMapping(value = "addProduct", method = RequestMethod.POST)
    public boolean addProduct(@RequestBody Product inputVO) throws Exception {
        LOGGER.info("[addProduct]------ Start ");
        LOGGER.debug("inputVO: {} ", gson.toJson(inputVO) );
        return productService.addProduct(inputVO);
    }
    
    @ResponseBody
    @RequestMapping(value = "getAll", method = RequestMethod.GET)
    public List<ProductInfoVO> getAll() throws Exception {
        LOGGER.debug("[getAll]------ Start ");
        System.out.println("[getAll]------ Start");
        List<ProductInfoVO> productList = productService.queryAll();
        
        return productList;
    }
    
    
    @ResponseBody
    @RequestMapping(value = "deleteProduct", method = RequestMethod.GET)
    public String deleteProduct(String pId) throws Exception {
        LOGGER.debug("[deleteProduct]------ Start, pId={} ", pId);
        return productService.deleteProduct(pId);
    }
    

}
