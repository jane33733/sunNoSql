
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
import com.sun.service.SaleRecordService;
import com.sun.service.impl.SaleRecordServiceImpl;
import com.sun.vo.db.Product;
import com.sun.vo.output.SaleRecordReportInfoVO;
import com.sun.vo.transfer.SaleRecordQueryVO;


@Controller
@RequestMapping(value = "saleRecord")
public class SaleRecordController  {

    private static final Logger LOGGER = LoggerFactory.getLogger(SaleRecordController.class);

    private SaleRecordService saleRecordService = new SaleRecordServiceImpl();
    
    private Gson gson = new Gson();
    
    @ResponseBody
    @RequestMapping(value = "notReady", method = RequestMethod.POST)
    public boolean addProduct(@RequestBody Product inputVO) throws Exception {
        LOGGER.info("[addProduct]------ Start ");
        LOGGER.debug("inputVO: {} ", gson.toJson(inputVO) );
        return false;
    }
    
    @ResponseBody
    @RequestMapping(value = "monthSaleRecord", method = RequestMethod.GET)
    public List<SaleRecordReportInfoVO> monthSaleRecord() throws Exception {
        LOGGER.debug("[monthSaleRecord]------ Start ");
        System.out.println("[monthSaleRecord]------ Start");
        SaleRecordQueryVO queryVO = new SaleRecordQueryVO();
        List<SaleRecordReportInfoVO> infoList = saleRecordService.queryTopAndLast(queryVO);
        
        return infoList;
    }
    
    @ResponseBody
    @RequestMapping(value = "insert200ThousandSale", method = RequestMethod.GET)
    public boolean insert200ThousandSale() throws Exception {
    	LOGGER.debug("[insert200ThousandSale]------ Start ");
    	System.out.println("[insert200ThousandSale]------ Start");
    	boolean result = saleRecordService.randomAddSale();
    	return result;
    }
    
    @ResponseBody
    @RequestMapping(value = "deleteSale", method = RequestMethod.GET)
    public boolean deleteSale() throws Exception {
    	LOGGER.debug("[deleteSale]------ Start ");
    	System.out.println("[deleteSale]------ Start");
    	boolean result = saleRecordService.deleteAllSale();
    	return result;
    }
    
    

}
