package com.sun.test.controller;

import static org.mockito.Mockito.when;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.google.gson.Gson;
import com.sun.controller.ProductController;
import com.sun.entity.Product;
import com.sun.request.vo.ProductQueryVO;
import com.sun.respose.vo.ProductInfoVO;
import com.sun.service.ProductService;

import static org.mockito.Matchers.any;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration("file:WebContent/WEB-INF/context-dispatcher.xml")

public class ProductControllerTest {

	private MockMvc mockMvc;

	@InjectMocks
	@Autowired
	private ProductController productController;

	@Mock
	@Autowired
	private ProductService productService;

	@Before
	public void setUp() throws Exception {
		mockMvc = MockMvcBuilders.standaloneSetup(productController).build();
		MockitoAnnotations.initMocks(this);
	}

	@Test
	public void testGetByPriceSuccess() throws Exception {
		List<Product> productList = new ArrayList<Product>();
		productList.add(new Product("1", "test1", BigDecimal.valueOf(25.5), new Date()));
		
		Gson gson = new Gson();
        String json = gson.toJson(ProductQueryVO.class);

		when(productService.searchByCondition(any(ProductQueryVO.class))).thenReturn(productList);
		
		mockMvc.perform(post("/product/getByPrice").contentType(MediaType.APPLICATION_JSON).content(json))
		.andDo(print())
		.andExpect(status().isOk());
	}

	@Test
	public void testSearchSuccess() throws Exception {
		List<ProductInfoVO> pInfoList = new ArrayList<ProductInfoVO>();
		pInfoList.add(new ProductInfoVO("1", "test1", BigDecimal.valueOf(25.5), new Date()));

		when(productService.search(Mockito.anyInt())).thenReturn(pInfoList);

		mockMvc.perform(get("/product/getAll"))
		.andDo(print())
		.andExpect(status().isOk());
	}
};